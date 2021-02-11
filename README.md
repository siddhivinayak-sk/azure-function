# Azure Function - With Event Grid Handler

## Description
This Java based project has been written to deploy as function in Azure Cloud environment to create EventGrid so than it can intercept event from the configured event subscription.

The data model used to capture the event fulfill the need of events created by Azure Blob Storage. It means whenever an event will occur it will be invoked and the event data fill be provided as input into the function.

Following events can be captured:
- Blob Created
- Blob Deleted
- Directory Created
- Directory Deleted
- Blob Renamed
- Directory Renamed


The events will be coming to the function based upon event subscription configuration.

## Use Case
Azure Functions are fully managed services provided by Azure which does not requires to own VMs, only need to make functionality as Azure function and deployed into the server less Function App.

Though, it can be used for various use cases but popular choice it to create server less application pipe lines. Consider the example,
Suppose, there is requirement in application that, Mobile/WebApp users will take picture and upload. Once it has been uploaded it will be stored and then OCR will run on the same image and the data will be used into further processing of user request.

This will create mainly two parts:
- Storage of image
- Once image stored, then OCR will run and output will go back to application

This piped operation must be highly responsive as user can not feel blockage. Here we can used Azure Blob Storage and Azure Function to create pipeline for this operation. Example:

User/Application -> Blob Storage -> Function App -> User/Application 

This project contains similar functionality where a function app has been created to take input from EventGrid and action. So whenever user uploads any file, a Block Blob Object created and event fired and the same event intercept by Azure Function and action written into the function will execute.

## Technology Stack
- Java 8 or later
- Maven as build tool
- Azure Blob Storage


## Build
Maven has been used as build tool for this project with default Azure SDK, CLI build plugin.

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
mvn package azure-functions:package
```

## Deployment 
Below is command for deployment.
```
mvn azure-functions:deploy
```

Notes: 
The Build Steps must be completed successfully then only deploy can be performed.
The details about function name, region, resource group and platform version will be picked up from pom.xml file
The user must be login in Azure CLI to deploy succuessfully by running below command
```
az login
```
 

## Configuraiton
There are many configuration required when a function app is created in Azure from Azure Portal:
 - Subscription and Resource Group - Select the subscription and resource group for azure function
 - App Name - Provide Azure function name, same name will be used into POM
 - Publish - There are two publish plan available as code or docker. In this case select Code
 - Runtime Stack - When publish is selected as Code then Need to select the technology as Java 
 - Version - Select the version of Java, here select 8
 - Region - Select the region of deployment of azure function app
 - Storage Account - An account for storage need to create/configure to store the Function App stuffs
 - Operating System - For Java based function typically Linux is used
 - Plan Type - Normally Server less selected
 - Enable Application Insight - If you want to track logs and metrics enable it. It can be enabled at later as well.
 - Tags - You can provide tags as you want to identify the resource
  

Once Function App created into the Azure Portal, below need to configure into pom.xml

- Define the function name
```
		<functionAppName>my-azure-function</functionAppName> <!-- Azure Function Name -->
```

- Define the region
```
		<functionAppRegion>Central India</functionAppRegion> <!-- Region -->
```

- Define the Resource Group for the function
```
		<functionResourceGroup>my-azure-function-RG</functionResourceGroup> <!-- Azure Function Resource Group -->
```

- Define the FUNCTIONS_EXTENSION_VERSION
Latest stable version is
```
<value>~3</value>
```
