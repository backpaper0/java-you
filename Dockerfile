FROM centos

MAINTAINER Taichi Uragami <backpaper0@gmail.com>

# https://s3-eu-west-1.amazonaws.com/payara.co/Payara+Downloads/Payara+4.1.1.154/payara-micro-4.1.1.154.jar
ENV PAYARA_URL http://bit.ly/1W9d2Lb

RUN yum install -y java-1.8.0-openjdk-devel ipa-gothic-fonts

ADD $PAYARA_URL /opt/java-you/payara-micro-4.1.1.154.jar
ADD build/libs/java-you.war /opt/java-you/java-you.war

WORKDIR /opt/java-you

ENTRYPOINT ["java", "-jar", "payara-micro-4.1.1.154.jar", "--noCluster", "--deploy", "java-you.war"]
