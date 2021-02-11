# Getting Started

## Install Java and Maven
This project has been written in Java so need to install Java (JDK) 8 or later. After JDK installation set JAVA_HOME path so that maven can pick JDK appropriately. 

The Apache Maven build tool used in this project, so install Maven (Apache Maven installation documentation).

Once ready check Maven is working properly. Run below command on your command line:
mvn -version



  

## Project build
Checkout the project on your local directory

Before starting build, one must have below installed properly:
- JDK 8
- NodeJS
- Azure CLI
- Azure Function Core Tool
- .Net SDK
- Apache Maven 3.5x or later

Steps:
1. Install NodeJS, download latest NodeJS and install on machine
2. Install .Net SDK latest
3. Install Microsoft Azure CLI
4. With NodeJS, Install Function Core Tool by running below command
```
npm i -g azure-functions-core-tools@3
```

In case facing issue, check NPM registry, disable SSL or use unsafe-perm as,
```
npm i -g azure-functions-core-tools@3
```
5. Install JDK 8, OracleJDK or OpenJDK
6. Setup maven


Once, all above steps completed, now ready to perform package by using below command
```
mvn clean package azure-functions:package
```



mvn package azure-functions:package
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------< com.azure.function:azure-function >------------------
[INFO] Building Azure-Function v0.0.1
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:3.1.0:resources (default-resources) @ azure-function ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ azure-function ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:3.1.0:testResources (default-testResources) @ azure-function ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Sandeep\code\azure\azure-function\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ azure-function ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ azure-function ---
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.azure.function.FunctionTest
Feb 11, 2021 11:01:22 AM com.azure.function.Function Run
INFO: Java EventGrid trigger function begun

Feb 11, 2021 11:01:22 AM com.azure.function.Function Run
INFO: Data: {"topic":"","subject":"","eventType":"Microsoft.Storage.BlobCreated","id":"","data":{"api":"","clientRequestId":"","requestId":"","eTag":"","contentType":"","contentLength":19117,"blobType":"BlockBlob","url":"<enter url>","sequencer":"","storageDiagnostics":{"batchId":""}},"dataVersion":"","metadataVersion":"1","eventTime":"2021-02-01T10:32:58.1406068Z"}
Feb 11, 2021 11:01:22 AM com.azure.function.Function loadYamlFile
INFO: Inside the G2BConverterServiceImpl:: loadYamlFile method
Feb 11, 2021 11:01:23 AM com.azure.function.Function Run
INFO: Yaml Loading
Feb 11, 2021 11:01:23 AM com.azure.function.Function Run
INFO: StorageBlobCreatedEvent  Created
Feb 11, 2021 11:01:23 AM com.azure.function.Function Run
INFO: GSON Created
Feb 11, 2021 11:01:23 AM com.azure.function.Function Run
INFO: EventGridEvent Cast to Java POJO
Feb 11, 2021 11:01:23 AM com.azure.function.Function Run
INFO: EventGridEvent - Blob Created Event
Feb 11, 2021 11:01:23 AM com.azure.function.Function Run
INFO: EventGridEvent - Event Info Obtained
Feb 11, 2021 11:01:23 AM com.azure.function.Function Run
INFO: EventGridEvent URI: <enter url>
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.752 s - in com.azure.function.FunctionTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-dependency-plugin:3.1.1:copy-dependencies (copy-dependencies) @ azure-function ---
[INFO] com.microsoft.azure:azure-eventgrid:jar:1.1.0 already exists in destination.
[INFO] org.apache.commons:commons-lang3:jar:3.9 already exists in destination.
[INFO] com.twelvemonkeys.imageio:imageio-core:jar:3.5 already exists in destination.
[INFO] com.twelvemonkeys.imageio:imageio-tiff:jar:3.5 already exists in destination.
[INFO] com.twelvemonkeys.imageio:imageio:pom:3.3.2 already exists in destination.
[INFO] org.slf4j:slf4j-api:jar:1.7.12 already exists in destination.
[INFO] com.squareup.okhttp3:logging-interceptor:jar:3.4.2 already exists in destination.
[INFO] com.fasterxml.jackson.datatype:jackson-datatype-joda:jar:2.7.2 already exists in destination.
[INFO] com.github.jai-imageio:jai-imageio-core:jar:1.4.0 already exists in destination.
[INFO] io.reactivex:rxjava:jar:1.2.4 already exists in destination.
[INFO] com.microsoft.azure:azure-annotations:jar:1.2.0 already exists in destination.
[INFO] com.fasterxml.jackson.core:jackson-core:jar:2.12.0 already exists in destination.
[INFO] com.twelvemonkeys.common:common-io:jar:3.3.2 already exists in destination.
[INFO] com.twelvemonkeys.imageio:imageio-metadata:jar:3.5 already exists in destination.
[INFO] com.microsoft.azure:azure-client-runtime:jar:1.5.0 already exists in destination.
[INFO] com.squareup.retrofit2:retrofit:jar:2.1.0 already exists in destination.
[INFO] com.twelvemonkeys.common:common-lang:jar:3.3.2 already exists in destination.
[INFO] com.squareup.okhttp3:okhttp-urlconnection:jar:3.4.2 already exists in destination.
[INFO] com.microsoft.rest:client-runtime:jar:1.5.0 already exists in destination.
[INFO] com.fasterxml.jackson.core:jackson-annotations:jar:2.7.0 already exists in destination.
[INFO] com.squareup.retrofit2:converter-jackson:jar:2.1.0 already exists in destination.
[INFO] com.microsoft.azure:azure-storage:jar:7.0.0 already exists in destination.
[INFO] com.google.code.gson:gson:jar:2.8.5 already exists in destination.
[INFO] com.microsoft.azure:azure-keyvault-core:jar:1.0.0 already exists in destination.
[INFO] com.google.guava:guava:jar:20.0 already exists in destination.
[INFO] com.microsoft.azure:azure-functions-java-core:jar:1.0.0-beta-3 already exists in destination.
[INFO] joda-time:joda-time:jar:2.4 already exists in destination.
[INFO] com.twelvemonkeys.common:common-image:jar:3.3.2 already exists in destination.
[INFO] com.squareup.okhttp3:okhttp:jar:3.4.2 already exists in destination.
[INFO] com.squareup.okio:okio:jar:1.9.0 already exists in destination.
[INFO] com.squareup.retrofit2:adapter-rxjava:jar:2.1.0 already exists in destination.
[INFO] com.fasterxml.jackson.core:jackson-databind:jar:2.7.2 already exists in destination.
[INFO] org.yaml:snakeyaml:jar:1.21 already exists in destination.
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ azure-function ---
[INFO] Building jar: C:\Sandeep\code\azure\azure-function\target\azure-function-v0.0.1.jar
[INFO]
[INFO] --- azure-functions-maven-plugin:1.6.0:package (package-functions) @ azure-function ---
[WARNING] The POM for com.microsoft.azure.applicationinsights.v2015_05_01:azure-mgmt-insights:jar:1.0.0-beta is invalid, transitive dependencies (if any) will not be available, enable debug logging for more details
Downloading from nexus-db: http://mvn-repo/repository/maven-public/net/minidev/json-smart/maven-metadata.xml
[WARNING] Could not transfer metadata net.minidev:json-smart/maven-metadata.xml from/to nexus-db (http://mvn-repo/repository/maven-public): Connect to mvn-repo [/mvn-repo] failed: Connection timed out: connect
Downloading from nexus-db: http://mvn-repo/repository/maven-public/com/nimbusds/lang-tag/maven-metadata.xml
[WARNING] Could not transfer metadata com.nimbusds:lang-tag/maven-metadata.xml from/to nexus-db (http://mvn-repo/repository/maven-public): Connect to mvn-repo [/mvn-repo] failed: Connection timed out: connect
Downloading from nexus-db: http://mvn-repo/repository/maven-public/com/nimbusds/nimbus-jose-jwt/maven-metadata.xml
[WARNING] Could not transfer metadata com.nimbusds:nimbus-jose-jwt/maven-metadata.xml from/to nexus-db (http://mvn-repo/repository/maven-public): Connect to mvn-repo [/mvn-repo] failed: Connection timed out: connect
[INFO]
[INFO] Step 1 of 7: Searching for Azure Functions entry points
[INFO] 1 Azure Functions entry point(s) found.
[INFO]
[INFO] Step 2 of 7: Generating Azure Functions configurations
[INFO] Generation done.
[INFO]
[INFO] Step 3 of 7: Validating generated configurations
[INFO] Validation done.
[INFO]
[INFO] Step 4 of 7: Saving host.json
[INFO] Successfully saved to C:\Sandeep\code\azure\azure-function\target\azure-functions\my-azure-function\host.json
[INFO]
[INFO] Step 5 of 7: Saving configurations to function.json
[INFO] Starting processing function: my-azure-function
[INFO] Successfully saved to C:\Sandeep\code\azure\azure-function\target\azure-functions\my-azure-function\my-azure-function\function.json
[INFO]
[INFO] Step 6 of 7: Copying JARs to staging directoryC:\Sandeep\code\azure\azure-function\target\azure-functions\my-azure-function
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource to C:\Sandeep\code\azure\azure-function\target\azure-functions\my-azure-function
[INFO] Copied successfully.
[INFO] Step 7 of 7: Installing function extensions if needed
Microsoft (R) Build Engine version 16.8.3+39993bd9d for .NET
Copyright (C) Microsoft Corporation. All rights reserved.

  Determining projects to restore...
  All projects are up-to-date for restore.
  extensions -> C:\Sandeep\code\azure\azure-function\target\azure-functions\my-azure-function\bin\extensions.dll

Build succeeded.
    0 Warning(s)
    0 Error(s)

Time Elapsed 00:00:08.49


[INFO] Function extension installation done.
[INFO] Successfully built Azure Functions.
[INFO]
[INFO] --- maven-resources-plugin:3.1.0:copy-resources (copy-resources) @ azure-function ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 2 resources
[INFO]
[INFO] --- azure-functions-maven-plugin:1.6.0:package (default-cli) @ azure-function ---
[INFO]
[INFO] Step 1 of 7: Searching for Azure Functions entry points
[INFO] 1 Azure Functions entry point(s) found.
[INFO]
[INFO] Step 2 of 7: Generating Azure Functions configurations
[INFO] Generation done.
[INFO]
[INFO] Step 3 of 7: Validating generated configurations
[INFO] Validation done.
[INFO]
[INFO] Step 4 of 7: Saving host.json
[INFO] Successfully saved to C:\Sandeep\code\azure\azure-function\target\azure-functions\my-azure-function\host.json
[INFO]
[INFO] Step 5 of 7: Saving configurations to function.json
[INFO] Starting processing function: my-azure-function
[INFO] Successfully saved to C:\Sandeep\code\azure\azure-function\target\azure-functions\my-azure-function\my-azure-function\function.json
[INFO]
[INFO] Step 6 of 7: Copying JARs to staging directoryC:\Sandeep\code\azure\azure-function\target\azure-functions\my-azure-function
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource to C:\Sandeep\code\azure\azure-function\target\azure-functions\my-azure-function
[INFO] Copied successfully.
[INFO] Step 7 of 7: Installing function extensions if needed
Microsoft (R) Build Engine version 16.8.3+39993bd9d for .NET
Copyright (C) Microsoft Corporation. All rights reserved.

  Determining projects to restore...
  All projects are up-to-date for restore.
  extensions -> C:\Sandeep\code\azure\azure-function\target\azure-functions\my-azure-function\bin\extensions.dll

Build succeeded.
    0 Warning(s)
    0 Error(s)

Time Elapsed 00:00:02.39


[INFO] Function extension installation done.
[INFO] Successfully built Azure Functions.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 03:08 min
[INFO] Finished at: 2021-02-11T11:04:19+05:30
[INFO] ------------------------------------------------------------------------









## Deployment 
Below is command for deployment.
```
mvn azure-functions:deploy
```
