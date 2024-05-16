FROM alpine:3.19

RUN apk add openjdk17

COPY build/libs/sms-verify.jar /sms-verify.jar

ENTRYPOINT ["java","-jar","sms-push.jar"]
