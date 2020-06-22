## Install S2I ( mac ):

- Install GO from golang.org and add to your /etc/paths file
- Invoke : go get github.com/openshift/source-to-image/cmd/s2i 
- brew install source-to-image
- s2i ( should see help information)

## Build image:

- docker pull registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift
- docker images. ( verify that open jdk8 image is there)
- s2i build https://github.com/IndraniDey1/spring-boot-s2i-app registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift spring-boot-s2i-app
                             or
- s2i build .  registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift spring-boot-s2i-app

- docker images ( verify that new spring-boot-s2i-app image exist)
- docker run -d -p 8080:8080 spring-boot-s2i-app
curl http://localhost:8080/catfactservice/facts
curl http://localhost:8080/bookservice/books

Enjoy !!!

-------------------------------------------------
docker commands:
-------------------------------------------------
**to remove a docker image

docker images
docker image remove spring-boot-s2i-app      
docker stop aed5ccda1ad0
docker rm aed5ccda1ad0
docker image remove spring-boot-s2i-app      

**to prune images
docker container ls
docker container stop <id>
docker container rm <id>
docker container prune
  
