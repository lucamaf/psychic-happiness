# psychic-happiness
# Configuration of components
AMQ Streams installation
Knative installation
Knative eventing, serving and knative kafka installation in default knative namespaces
create event source kafkasource in case of connecting directly kafkasource with serving endpoint
otherwise connect kafkasource to default knative broker and then create trigger with filtering

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


