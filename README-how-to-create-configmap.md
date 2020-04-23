## Update Deployment Config with ConfigMap

Steps are you create a configmap and then inject that configmap into the openshift deployment config. There are two ways to build the configmap. One is that you specify the properties on command line one at a time or you provided a file like application.properties file and create a configmap that way. 

## Create a configmap and add properties using 'from-literal'

  - Create the configmap
    - oc create configmap spring-boot-s2i-app-cm --from-literal cat-fact.url="https://catfact.ninja/facts"
  - Verify 
    - oc describe cm/spring-boot-s2i-cm
  - Inject the configmap into deployment config
    - oc set env dc/spring-boot-s2i-app --from configmap/spring-boot-s2i-cm

## Create a configmap from application.properties file

  - Copy the properties file where oc client can read
  - Create the configmap from a file
    - oc create configmap spring-boot-s2i-app-cm1 --from-file application.properties
  - Verify 
    - oc describe cm/spring-boot-s2i-cm1
  - Inject the configmap into deployment config
    - oc set volume dc/spring-boot-s2i-app --add -t configmap -m /opt/app-root/secure --name spring-boot-s2i-cm1-vol --configmap-name name spring-boot-s2i-cm1

 ## Update a configmap 
  Scenario:  you need to delete or add an item from confifmap. 
  Answer: You cannot update configmap directly. You have to replace the configmap.
  Here are the steps:
  1. Make the change in your properties file. For example in application.properties file. Add or delete a property. 
  2. oc create configmap spring-boot-s2i-app-cm1 --from-file fresenius/application.properties --dry-run -o yaml | oc replace -f -
  
  
  

