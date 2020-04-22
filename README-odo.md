## ODO TOOL 
Developers can also use ODO tool to run this application
Please learn more details from here: https://docs.openshift.com/container-platform/4.3/cli_reference/openshift_developer_cli/understanding-odo.html

It builds your code locally and deployes to openshift. No need for external registry or code must be in git. Once the application is in openshift you can login to openshift and do any manipulation. Stay tuned for other features of ODO tool

## Install odo
- curl -L https://github.com/openshift/odo/raw/master/scripts/installer.sh | bash


**Login to openshift using odo and do the following steps

- login url -u username -p password

                  
**Build and Deploy to opemshift

- odo project create project some-project-name  ( this will create a project in openshift)
- Go to your code base and issue this command
  - odo create java ( since this is a java project, if nodejs project then do oc create nodejs )
- odo push
- odo url create --port 8080
- odo push
- odo url list
- curl <url>
  
-   
That is it. 
Again this is all in one shot. Good but as a developer you need to know the manual process in order to debug issue. Therefore look at the project from console and using cli tool to understand what was deployed

Enjoy !!!

