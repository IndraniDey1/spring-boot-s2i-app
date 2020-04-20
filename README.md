## Overivew 

This is a springboot app which intereacts with a mysql database and also invokes a pubic webservice url. This app is developed to learn openshift deployment mainly but one can learn just how to use springboot with mysql 

- This app will be used to demonstrate how to create a docker image from raw source from github using S2I tool. 
- Once the image is built then it will be pushed from local docker registry to an external registry. In this case to quay.io registry.
- Once the image is in quay registry then it will be used to create a new-app in openshift.


## Install S2I ( mac ):

- Install GO from golang.org and add to your /etc/paths file
- Invoke : go get github.com/openshift/source-to-image/cmd/s2i 
- brew install source-to-image
- s2i ( should see help information)

## Build image:

- docker pull registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift
- docker images. ( verify that open jdk8 image is there)
- s2i build https://github.com/IndraniDey1/spring-boot-s2i-app registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift spring-boot-s2i-app
- docker images ( verify that new spring-boot-s2i-app image exist)
- Test the image : docker run -d -p 8080:8080 spring-boot-s2i-app
- invoke http://localhost:8080/catfactservice/facts

## Upload the image on a registry ( quay.io in this case)

- Create an account in quay.io . https://docs.quay.io/solution/getting-started.html
- login to quay from docker
    - docker login quay.io  (username/password)
- Create an empty repository in quay.io called : 'spring-boot-s2i-app'
- spring-boot-s2i-app container should be running at this point. 
   - docker ps -l ( verify)
- copy the container id : 
   - docker ps -l
- commit the container id to quay.io
    - docker commit <container-id> quay.io/<username>/<reponame>. ( reponame created on step 3 )
- push the container image to a quay
    - docker push quay.io/<username>/<reponame>
   
## Pull the image from registry and deploy on openshift

- An openshift cluster should be running
- Create a new project : oc new-project s2i-demo
- Create a new-app using the image from the registry
    - oc new-app quay.io/<username>/spring-boot-s2i-app
- oc expose svc/spring-boot-s2i-app
- oc get routes
- invoke the url given by route
    - <route>/bookservice/books
    - <route>/catfactservice/facts
 
 ## Update Deployment Config with ConfigMap and Secrets
 
 - create configmap: Change one of the property
   - oc create configmap spring-boot-s2i-app-cm --from-literal cat-fact.url="https://catfact.ninja/facts"

 - Verify : oc describe cm/springboot-mysql-config-cm

 - create secrets  : use the mysql username and password and create secrets
   - create a file named springboot-mysql-config.sec    
   - spring.datasource.username=root spring.datasource.password=tcT7mYOQYLqg804e
   - oc create secret generic spring-boot-s2i-app-sec --from-file spring-boot-s2i-app.sec 
   - verify : oc get secret/spring-boot-s2i-app-sec -o json

 - inject configuration 
   - oc set env dc/spring-boot-s2i-app  --from configmap/spring-boot-s2i-cm

 - inject secret into deployment 
   - oc set volume dc/spring-boot-s2i-app --add -t secret -m /opt/app-root/secure --name spring-boot-s2i-app-sec-vol --secret-name spring-boot-s2i-app-sec 
   
 - Trigget a new deployment
   - oc rollout latest dc/myapp


Enjoy !!!
  
