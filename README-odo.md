## ODO TOOL 
Developers can also use ODO tool to run this application
Please learn more details from here: https://docs.openshift.com/container-platform/4.3/cli_reference/openshift_developer_cli/understanding-odo.html

It builds your code locally and deployes to openshift. No need for external registry or code must be in git. Once the application is in openshift you can login to openshift and do any manipulation. Stay tuned for other features of ODO tool

## Install odo
- Installing odo on macOS (Binary installation, you may have to use sudo for the commands)
   - curl -L https://mirror.openshift.com/pub/openshift-v4/clients/odo/latest/odo-darwin-amd64 -o /usr/local/bin/odo
   - chmod +x /usr/local/bin/odo.   

**Login to openshift using odo and do the following steps

- odo login url -u username -p password

                  
## Single component application :Build and Deploy to opemshift

- Go to your code base and issue these commands
  - odo project create some-project-name      ( this will create a project in openshift)
  - odo create java            ( since this is a java project, if nodejs project then do oc create nodejs )
  - odo push
  - odo url create --port 8080
  - odo push
  - odo url list
  - curl url
  
## Multi component application: Build and Deploy to openshift

- Create a directory to place both your backend and frontend code base
   - mkdir mycomponents
   - cd mycomonent
   - Copy your source codes under this direcotory for all the components. For example : front-end-codo-dir, backend-code-dir
   - odo login -u username - p password api-url
   - ode project create

 **Backend-code deploy
 
   - cd to backend-code-dir
   - oc create java
   - odo push ( this will push the backend code. no need to specify port)
   
 **Front-end code deploy
   - cd to front-end-code-dir
   - oc create nodejs
   - odo push ( this will push the frontend code. no need to specify port)


   - for more information please see this url https://docs.openshift.com/container-platform/4.3/cli_reference/openshift_developer_cli/creating-a-multicomponent-application-with-odo.html



That is it. 


Again this is all in one shot. Good but as a developer you need to know the manual process in order to debug issue. Therefore look at the project from console and using cli tool to understand what was deployed

Enjoy !!!

