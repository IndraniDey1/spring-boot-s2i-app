## ODO TOOL 
Developers can also use ODO tool to run this application
Please learn more details from here: https://docs.openshift.com/container-platform/4.3/cli_reference/openshift_developer_cli/understanding-odo.html

It builds your code locally and deployes to openshift. No need for external registry or code must be in git. Once the application is in openshift you can login to openshift and do any manipulation. Stay tuned for other features of ODO tool


**Loging to openshift using odo and do the following steps

- odo login -u <username> -p <password>
- odo project create <project name>  ( this will create a project in openshift)
- Go to your code base and issue this command
  - odo create java ( since this is a java project, if nodejs project then do oc create nodejs )
- odo push
- odo url create --port 8080
- odo push
- odo url list
- curl <url>

