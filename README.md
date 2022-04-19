# psychic-happiness
# Configuration of components
AMQ Streams installation
Knative installation
Knative eventing, serving and knative kafka installation
create event soruce kafkasource

# Fuse project
Based on Red Hat Fuse 7.10 (Apache Camel 2.x) and SpringBoot 2

## description

## deployment on OpenShift
using jkube plugin
`mvn  install -Popenshift`

## usage

# Quarkus project


## deployment on OpenShift
using the serverless option in application.properties
`quarkus.kubernetes.deployment-target=knative`

to deploy use:
`mvn clean package -Dquarkus.kubernetes.deploy=true`


