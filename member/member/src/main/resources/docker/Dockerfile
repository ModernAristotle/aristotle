FROM ping2ravi/tomcat:8.0.33_oracle_jdk8.91.14_ubuntu16.04
MAINTAINER Ravi Sharma 

ADD ./member-0.0.1-SNAPSHOT.war ROOT.war
RUN rm -fR $TOMCAT_HOME/webapps/*; cp ROOT.war $TOMCAT_HOME/webapps/.
