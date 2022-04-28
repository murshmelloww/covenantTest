For realizing this case I used technologies:
* Create Java project with Gradlew
* Lombok, RoboPOJOGenerator and Jackson for easy work with JSON Object
* RestAssured, Aeonbits for easy work with api
* Jcraft for remote control by SSH

I realised package config for connecting to Covenant

I realised package model for verifying response and creating request body

I modified some code example for working with jcraft from stack overflow and create package service.ssh

Main test is in UserTest class
* loginTest - User login and get user auth token
* createListenerTest - User create http listener
* generateLauncherTest - User generate and host Binary launcher
* downloadLauncherTest - User download launcher
* transferFileTest - Connect and transfer file on remote machine
* execLauncherFileTest - Execute launcher on remote machine
* verifyConnectionTest - Check grunt creation
* taskKillLauncherFileTest - Kill process on remote machine
* deleteListenerTest - Delete created listener