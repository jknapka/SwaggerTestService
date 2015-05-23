# SwaggerTestService

A simple test service generated by the "delegate" version of Swagger codegen at https://github.com/jknapka/swagger-codegen (based on joegnelson's fork of the canonical swagger-codegen), and a separate project containing the API implementation code. There are two Maven projects here:

1) testsvc/jaxrs is the Swagger-Codegen[-JaxRSServerCodegenDelegate]-generated service. The pom.xml had a couple of things added to it, as mentioned below, but the Java code can be run unchanged; the service-specific behavior is implemented by classes implemented elsewhere.

2) testsvcImpl/testsvcImpl is the project that implements the service-specific behavior. The project framework was gnerated by Maven.

Other files (the scripts may contain hard-coded paths which need to be changed):

  * swagger.yaml - Swagger spec for the test service.
 
  * bldImpl.cmd - Invokes Maven to build the testsvcImpl code.
 
  * bldSw.cmd - Invokes Maven to build the testsvc code.
 
  * gen1.cmd - Generates testsvc from swagger.yaml
 
  * pom.xml - gen1.cmd copies this over the generated testsvc/jaxrs/pom.xml to fix some issues. A hack!
 
  * test.in - JSON input file read by test1.cmd.
 
  * test1.cmd - Uses curl to send a POST of test.in

Notes, problems, oddities:

I know that some of this is wrong, in the sense that it is not using Maven's capabilities in the best way. I'm extremely new to Maven, Swagger, and Jetty. With that said:

1) The Maven-generated testsvc/jaxrs/pom.xml has been changed to include a runtime dependency on testsvcImpl. This lets it load the implementation classes.

2) However, testsvcImpl also depends on testsvc at *compile* time, since it gets its API interface and model classes from testsvc. That means we cannot build testsvcImpl until testsvc is build. But it's not possible to tell Maven to ignore the runtime dependency on testsvcImpl while building, which means that the first time you build testsvc, you need to remove the dependency on testsvcImpl from testsvc/jaxrs/pom.xml. Once some version of testsvcImpl.jar is in the Maven repository, testsvc will build successfully with the testsvcImpl dependency in its pom.xml.

3) I had to manually add scala-library.jar to the testsvc/jaxrs/pom.xml. I'm not sure why Swagger isn't getting that dependency in the normal way. (I'm extremely new to Maven, Swagger, Jetty, etc.)

4) The file testsvc/jaxrs/src/main/resources/META-INF/com.jknapka.testsvc.api.TestApiInterface has been created in order 

5) I have not been able to figure out how to get logging to work correctly. Jetty always complains about log4j not being configured correctly, even though I thought I did that by supplying a log4j.properties in testsvc/jaxrs/main/resources.
