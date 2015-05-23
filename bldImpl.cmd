REM Build the code in the testsvcImp directory.
setlocal
cd testsvcImpl/testsvcImpl
call mvn clean -Dbootstrap=1
call mvn package -Dbootstrap=1
call mvn install -Dbootstrap=1
endlocal
