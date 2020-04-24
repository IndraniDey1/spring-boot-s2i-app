## Update deployment config with secrets
Secrets are used to secure sensitive data that goes into the application.properties file. You can create secrets for the credential use to access some components like database, queues, topics etc
read more https://docs.openshift.com/container-platform/4.3/nodes/pods/nodes-pods-secrets.html

## how to create secrets
For this application create secrets for the mysql username and password.

- create a file named spring-boot-s2i-app.sec and set the following two properties in it. 
  - spring.datasource.username=root 
  - spring.datasource.password=
- create secrets using the .sec file
  - oc create secret generic spring-boot-s2i-app-sec --from-file spring-boot-s2i-app.sec
- verify 
  - oc get secret/spring-boot-s2i-app-sec -o json
  
## Inject secret into deployment config in crc environment 

- oc set env dc/spring-boot-s2i-app --from secret/spring-boot-s2i-app-sec

## Inject secret into deployment config in higher environment
  - oc set volume dc/spring-boot-s2i-app --add -t secret -m /opt/app-root/secure --name spring-boot-s2i-app-sec-vol --secret-name spring-boot-s2i-app-sec


## Trigger a new deployment to verify the changes
  - oc rollout latest dc/spring-boot-s2i-app

