**Overivew 
This is a springboot app which intereacts with a mysql database and also invokes a pubic webservice url. This app is developed to learn openshift deployment mainly but one can learn just how to use springboot with mysql 

1. This app will be used to demonstrate how to create a docker image from raw source from github using S2I tool. 
2. Once the image is built then it will be pushed from local docker registry to an external registry. In this case to quay.io registry.
3. Once the image is in quay registry then it will be used to create a new-app in openshift.


**Install S2I ( mac ):

1. Install GO from golang.org and add to your /etc/paths file
2. Invoke : go get github.com/openshift/source-to-image/cmd/s2i 
3. brew install source-to-image
4. s2i ( should see help information)

**Build image:

1. docker pull registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift
2. docker images. ( verify that open jdk8 image is there)
3. s2i build https://github.com/<your-username>/spring-boot-app registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift s2i-spring-boot-app


