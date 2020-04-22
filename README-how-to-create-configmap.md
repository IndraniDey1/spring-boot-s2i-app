## Update Deployment Config with ConfigMap and Secrets

Steps are you create a configmap and then inject that configmap into the openshift deployment config. There are two ways to build the configmap. One is that you specify the properties on command line one at a time or you provided a file like application.properties file and create a configmap that way. 

** Create a configmap and add properties using 'from-literal'

  - Create the configmap
    - oc create configmap spring-boot-s2i-app-cm --from-literal cat-fact.url="https://catfact.ninja/facts"
  - Verify 
    - oc describe cm/spring-boot-s2i-cm
  - Inject the configmap into deployment config
    - oc set env dc/spring-boot-s2i-app --from configmap/spring-boot-s2i-cm

**Create a configmap from application.properties file

  - Copy the properties file where oc client can read
  - Create the configmap from a file
    - oc create configmap spring-boot-s2i-app-cm1 --from-file application.properties
  - Verify 
    - oc describe cm/spring-boot-s2i-cm1
  - Inject the configmap into deployment config
    - oc set env dc/spring-boot-s2i-app --from configmap/spring-boot-s2i-cm

