create -f s2i-app.cm
create -f s2i-app.sec
oc new-app java8~https://github.com/IndraniDey1/spring-boot-s2i-app.git --name s2i-app


oc set env dc/s2i-app --from configmap/s2i-app.cm
oc set env dc/s2i-app --from secret/s2i-app.sec
oc rollout latest dc/s2i-ap

