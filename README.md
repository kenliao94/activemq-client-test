Copy the compiled jar from activemq-client to this directory
* Example
```shell
$ cp /Users/qrl/amzn/personal_workspace/activemq/activemq-client/target/activemq-client-6.2.0-SNAPSHOT.jar ~/IdeaProjects/AmazonMqTeamDevScripts/src/AmazonMqTeamDevScripts/activemq_oss/ActiveMqSDKTestClient
```
Because the pom.xml will install this jar and it assumes the jar to be `activemq-client-6.2.0-SNAPSHOT.jar`

Once this step is done, to test your locally built ActiveMQ client
```shell
$ mvn initialize # install the local jar into this test client dependencies
$ mvn clean package # compile
$ java -jar target/gs-maven-0.1.0.jar 
```
Remember, please fill in your broker connection info in `TestActiveMqSDK.java` before compilation.