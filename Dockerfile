FROM openjdk:8
EXPOSE 8080
ADD target/social-shout-backend.jar social-shout-backend
ENTRYPOINT ["java","-jar","/social-shout-backend.jar"]