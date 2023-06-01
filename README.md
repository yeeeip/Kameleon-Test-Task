# Kameleoon-Test-Task

This application uses <a href=https://maven.apache.org/install.html>Maven</a> build system.

In order to start the app you need to clone this project in some directory on your machine and execute the following command in the project directory: <b>mvn spring-boot:run</b>

After the application has started, go the url address: http://localhost:8080/swagger-ui.html

Here you can hit different API endpoints and test them.

# Starting Application in the docker container
First thing you need to start this application in the docker container is to *(guess what?)* install Docker

Then, go to the directory where you cloned the project and execute the following command: <b>docker compose up</b>

Note that you should have the Docker daemon running while executing this command.
