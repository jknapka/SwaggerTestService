# SwaggerTestService

This is a simple test service generated by the "delegate" version of Swagger codegen at https://github.com/jknapka/swagger-codegen (based on joegnelson's fork of the canonical swagger-codegen), and a separate project containing the API implementation code. The service provides a simple name:value store managed by POST operations and accessed with GET operations; see swagger.yaml for the complete specification.

There are two Maven projects here:

1) testsvc/jaxrs is the Swagger-Codegen[-JaxRSServerCodegenDelegate]-generated service. The pom.xml had a couple of things added to it, as mentioned below, but the Java code can be run unchanged; the service-specific behavior is implemented by classes implemented elsewhere.

2) testsvcImpl/testsvcImpl is the project that implements the service-specific behavior. The project framework was gnerated by Maven.

Read the "oddities" section below before you try to build this code.

Other files (the scripts may contain hard-coded paths which need to be changed):

  * swagger.yaml - Swagger spec for the test service.
 
  * gen1.cmd - Generates testsvc from swagger.yaml
 
  * bldSw.cmd - Invokes Maven to build testsvc.
 
  * bldImpl.cmd - Invokes Maven to build testsvcImpl.
 
  * pom.xml - gen1.cmd copies this over the generated testsvc/jaxrs/pom.xml to fix some issues. A hack!
 
  * test.in - JSON input file read by test1.cmd.
 
  * test1.cmd - Uses curl to send a POST of test.in

Notes, problems, oddities:

I know that some of this is wrong, in the sense that it is not using Maven's capabilities in the best way. I'm extremely new to Maven, Swagger, and Jetty. With that said:

1) The Maven-generated testsvc/jaxrs/pom.xml has been changed to include a runtime dependency on testsvcImpl. This lets testsvc load the implementation classes from testsvcImpl.

2) However, testsvcImpl depends on testsvc at *compile* time, since it gets its API interface and model classes from testsvc. That means we cannot build testsvcImpl until testsvc is built. Because Maven tries to resolve all dependencies before a build, this effectively results in a circular dependency where there's no need for one: you can't build testsvcImpl without testsvc in the Maven repo, but you can't build *testsvc* without *testsvcImpl* in the repo because of the annoying runtime dependency.  What this means is, the first time you build testsvc, you need to supply the property "-Dbootstrap=1", which deactivates the problematic dependency on testsvcImpl using a Maven profile. See pom.xml for details. After testscvImpl is built, testsvc will build without the bootstrap option, because it's happy as long as there's some version of testsvcImpl in the Maven repo.

3) I had to manually add scala-library.jar to testsvc/jaxrs/pom.xml as a "system" dependency. I'm not sure why Maven isn't getting that dependency in the normal way. (As I mentioned above, I'm very new to Maven.)

4) The file testsvc/jaxrs/src/main/resources/META-INF/com.jknapka.testsvc.api.TestApiInterface has been created in order to tell testsvc what class to load to implement TestApiInterface; specifically, TestApiImpl from the testsvcImpl project. See the documentation for the J2SE class java.util.ServiceLoader, and then the code in testsvc/jaxrs/src/main/java/com/jknapka/testsvc/api/TestApi.java, to understand how that works.

5) I have not been able to figure out how to get logging to work correctly. Jetty always complains about log4j not being configured correctly, even though I thought I did that by supplying a log4j.properties in testsvc/jaxrs/main/resources.
