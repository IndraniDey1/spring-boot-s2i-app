s2i-app setup
1. create -f s2i-app.cm
2. create -f s2i-app.sec
3. delete the .odo directory
4. oc set env dc/s2i-app --from configmap/s2i-cm
5. oc set env dc/s2i-app --from secret/s2i-sec
6. oc expose svc/s2i-app
7. oc get route
8. test : http://<route>/catfactservice/facts
          http://<route>/bookservice/books
