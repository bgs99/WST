/*
 * Copyright 2001-2010 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package bgs;

import org.uddi.api_v3.*;
import org.apache.juddi.api_v3.*;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.apache.juddi.v3.client.transport.Transport;
import org.uddi.v3_service.UDDISecurityPortType;
import org.uddi.v3_service.UDDIPublicationPortType;

public class SimplePublish {

        private static UDDISecurityPortType security = null;
        private static UDDIPublicationPortType publish = null;

        public SimplePublish() {
                try {
                        UDDIClient uddiClient = new UDDIClient("META-INF/simple-browse-uddi.xml");
                        Transport transport = uddiClient.getTransport("default");
                        security = transport.getUDDISecurityService();
                        publish = transport.getUDDIPublishService();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public void publish(String business, String service, String wsdl) {
                try {
                        GetAuthToken getAuthTokenMyPub = new GetAuthToken();
                        getAuthTokenMyPub.setUserID("uddiadmin");
                        getAuthTokenMyPub.setCred("da_password1");
                        AuthToken myPubAuthToken = security.getAuthToken(getAuthTokenMyPub);

                        BusinessEntity myBusEntity = new BusinessEntity();
                        Name myBusName = new Name();
                        myBusName.setValue(business);
                        myBusEntity.getName().add(myBusName);

                        SaveBusiness sb = new SaveBusiness();
                        sb.getBusinessEntity().add(myBusEntity);
                        sb.setAuthInfo(myPubAuthToken.getAuthInfo());
                        BusinessDetail bd = publish.saveBusiness(sb);
                        String myBusKey = bd.getBusinessEntity().get(0).getBusinessKey();
                        System.out.println("Business key:  " + myBusKey);

                        BusinessService myService = new BusinessService();
                        myService.setBusinessKey(myBusKey);
                        Name myServName = new Name();
                        myServName.setValue(service);
                        myService.getName().add(myServName);

                        BindingTemplate myBindingTemplate = new BindingTemplate();
                        AccessPoint accessPoint = new AccessPoint();
                        accessPoint.setUseType(AccessPointType.WSDL_DEPLOYMENT.toString());
                        accessPoint.setValue(wsdl);
                        myBindingTemplate.setAccessPoint(accessPoint);
                        BindingTemplates myBindingTemplates = new BindingTemplates();

                        myBindingTemplate = UDDIClient.addSOAPtModels(myBindingTemplate);
                        myBindingTemplates.getBindingTemplate().add(myBindingTemplate);

                        myService.setBindingTemplates(myBindingTemplates);

                        SaveService ss = new SaveService();
                        ss.getBusinessService().add(myService);
                        ss.setAuthInfo(myPubAuthToken.getAuthInfo());
                        ServiceDetail sd = publish.saveService(ss);
                        String myServKey = sd.getBusinessService().get(0).getServiceKey();
                        System.out.println("Service key:  " + myServKey);

                        security.discardAuthToken(new DiscardAuthToken(myPubAuthToken.getAuthInfo()));

                        System.out.println("Success!");

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
