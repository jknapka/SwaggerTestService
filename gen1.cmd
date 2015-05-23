bREM Generate the Java server stub for the test service. Assumes that Maven
REM and swagger-codegen[-delegate] are installed in C:\Libraries
move ..\Downloads\swagger.yaml . 
rmdir /s testsvc
java -Dswagger.codegen.apiPackage=com.jknapka.testsvc.api -Dswagger.codegen.modelPackage=com.jknapka.testsvc.model -jar C:/Libraries/swagger-codegen-delegate/modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate  -i swagger.yaml  -l jaxrsDelegate  -o testsvc/jaxrs -v
xcopy pom.xml testsvc\jaxrs\pom.xml
set RESOURCE_DIR=testsvc\jaxrs\src\main\resources\META-INF\services
mkdir %RESOURCE_DIR%
echo com.jknapka.testsvcImpl.TestApiImpl > %RESOURCE_DIR%\com.jknapka.testsvc.api.TestApiInterface
