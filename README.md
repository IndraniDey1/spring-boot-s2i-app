***Overivew 

This is a springboot app which intereacts with a mysql database and also invokes a pubic webservice url. This app is developed to learn openshift deployment mainly but one can learn just how to use springboot with mysql 

1. This app will be used to demonstrate how to create a docker image from raw source from github using S2I tool. 
2. Once the image is built then it will be pushed from local docker registry to an external registry. In this case to quay.io registry.
3. Once the image is in quay registry then it will be used to create a new-app in openshift.


***Install S2I ( mac ):

1. Install GO from golang.org and add to your /etc/paths file
2. Invoke : go get github.com/openshift/source-to-image/cmd/s2i 
3. brew install source-to-image
4. s2i ( should see help information)://localhost:8080/

***Build image:

1. docker pull registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift
2. docker images. ( verify that open jdk8 image is there)
3. s2i build https://github.com/IndraniDey1/spring-boot-s2i-app registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift spring-boot-s2i-app
3. docker images ( verify that new spring-boot-s2i-app image exist)
4. Test the image : docker run -d -p 8080:8080 spring-boot-s2i-app
5. invoke http://://localhost:8080/catfactservice/facts

***Upload the image on a registry ( quay.io in this case)

1. Create an account in quay.io . https://docs.quay.io/solution/getting-started.html
2. login to quay from docker
    docker login quay.io 
    (username/password)
3. Create an empty repository in quay.io called : 'spring-boot-s2i-app'
4. spring-boot-s2i-app container should be running at this point. 
   docker ps -l ( verify)
5. copy the container id : 
   docker ps -l
6. commit the container id to quay.io
    docker commit <container-id> quay.io/<username>/<reponame>. ( reponame created on step 3 )
7. push the container image to a quay
    docker push quay.io/<username>/<reponame>
   
***Pull the image from registry and deploy on openshift

1. An openshift cluster should be running
2. Create a new project : oc new-project s2i-demo
3. Create a new-app using the image from the registry
   oc new-app quay.io/<username>/spring-boot-s2i-app
4. oc expose svc/spring-boot-s2i-app
5. oc get routes
6. invoke the url given by route
    <route>/bookservice/books
    <route>/catfactservice/facts
      
Enjoy !!!
  
