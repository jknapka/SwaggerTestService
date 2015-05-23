REM Generate the Java server stub for the test service.
setlocal
cd testsvc\jaxrs
call mvn clean
call mvn package
call mvn install
endlocal
