REM Generate the Java server stub for the test service.
setlocal
cd testsvc\jaxrs
call mvn clean -Dbootstrap=1
call mvn package -Dbootstrap=1
call mvn install -Dbootstrap=1
endlocal
