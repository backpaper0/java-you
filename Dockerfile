FROM centos

MAINTAINER Taichi Uragami <backpaper0@gmail.com>

ENV PAYARA_URL build/payara-micro-4.1.1.154.jar

RUN yum install -y java-1.8.0-openjdk-devel ipa-gothic-fonts

ADD $PAYARA_URL /opt/java-you/payara-micro-4.1.1.154.jar
ADD build/libs/java-you.war /opt/java-you/java-you.war

WORKDIR /opt/java-you

ENTRYPOINT ["java", "-jar", "payara-micro-4.1.1.154.jar", "--noCluster", "--deploy", "java-you.war"]
