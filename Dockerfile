FROM centos

MAINTAINER Taichi Uragami <backpaper0@gmail.com>

ENV PAYARA_URL https://s3-eu-west-1.amazonaws.com/payara.co/Payara+Downloads/payara-micro-4.1.152.1.jar

RUN yum install -y java-1.8.0-openjdk-devel ipa-gothic-fonts

ADD $PAYARA_URL /opt/java-you/payara-micro-4.1.152.1.jar
ADD build/libs/java-you.war /opt/java-you/java-you.war

WORKDIR /opt/java-you

ENTRYPOINT ["java", "-jar", "payara-micro-4.1.152.1.jar", "--deploy", "java-you.war"]
