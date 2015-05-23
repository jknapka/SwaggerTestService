REM Build the code in the testsvcImp directory.
setlocal
cd testsvcImpl/testsvcImpl
call mvn clean
call mvn package
call mvn install
endlocal
