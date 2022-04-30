## **For starting.**

#### 1) Run Covenant

        docker run -it -p 7443:7443 -p 80:80 -p 443:443 --name covenant -v /Users/apple/Covenant/Covenant/Data:/app/Data covenant --username AdminUser --computername 0.0.0.0

#### 2) Create user admin with password 123

#### 3) Run test pipeline.

## Technologies:
* Create Java project with Gradlew
* Lombok, RoboPOJOGenerator and Jackson for easy work with JSON Object
* RestAssured, Aeonbits for easy work with api
* Jcraft for remote control by SSH

## Workflow:
* I realised package config for connecting to Covenant
* I realised package model for verifying response and creating request body
* I modified some code example for working with jcraft from stack overflow and create package service.ssh

## API test is in UserTest class:
* createUser - login with admin and create new user
* loginTest - new user login and get user auth token
* createListenerTest - User create http listener
* generateLauncherTest - User generate and host Binary launcher
* downloadLauncherTest - User download launcher
* transferFileTest - Connect and transfer file on remote machine
* execLauncherFileTest - Execute launcher on remote machine
* verifyConnectionTest - Check grunt creation
* taskKillLauncherFileTest - Kill process on remote machine
* deleteListenerTest - Delete created listener
* deleteUserTest - delete created user

        Here is a problem. I download a file from GET api/listeners/{id}/hostedfiles. It is in "content" in Base64.
        This test may work on different environment. It needs to be added wtih endopoint for hosting file.

## UI test in FrontendTest class:
* configuration - configure chrome driver
* createUser - login with admin and create new user
* loginTest - new user login and get user auth token
* createListenerTest - User create http listener
* generateLauncherTest - User generate and host Binary launcher
* downloadLauncherTest - Chrome driver download file
* transferFileTest - Connect and transfer file on remote machine
* execLauncherFileTest - Execute launcher on remote machine
* verifyConnectionTest - Check grunt creation
* taskKillLauncherFileTest - Kill process on remote machine
* deleteListenerTest - Delete created listener
* deleteUserTest - delete created user
* driverClose

        This test will work on Windows system only. It depeneds from Chrom driver version.
        Im not sure that it will work on remote server, because chrome driver download file on local directory. 
