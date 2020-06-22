mysql-container-setup
  
1. Run  the following script to create an ephemeral mysql container

   init-db-container.sh/bat

2. oc get pod

3. Copy the pod name and set the value in the populate-db.sh/bat
     mpod=mysql-1-cj68h

4. populate-db.sh/bat

5. if issue with grant then
    oc rsh mysql pod
        mysql -u root
        GRANT ALL PRIVILEGES ON *.* TO 'user1'@'%';


