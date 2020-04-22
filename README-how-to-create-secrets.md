## Update deployment config with secrets
Secrets are used to secure sensitive data that goes into the application.properties file. You can create secrets for the credential use to access some components like database, queues, topics etc

## how to create secrets
For this application create secrets for the mysql username and password.

- create a file named spring-boot-s2i-app.sec
  - spring.datasource.username=root 
  - spring.datasource.password=
- create secrets using the .sec file
  - oc create secret generic spring-boot-s2i-app-sec --from-file spring-boot-s2i-app.sec
- verify 
  - oc get secret/spring-boot-s2i-app-sec -o json
  
## Inject secret into deployment config
  - oc set volume dc/spring-boot-s2i-app --add -t secret -m /opt/app-root/secure --name spring-boot-s2i-app-sec-vol --secret-name spring-boot-s2i-app-sec


## Trigger a new deployment to verify the changes
  - oc rollout latest dc/spring-boot-s2i-app

