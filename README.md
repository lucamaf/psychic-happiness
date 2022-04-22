# Overview
In this tutorial we will show how to build 2 simple examples of serverless enabled microservice architecture.  
In the first one we will explore how events coming from Kafka can trigger the execution of a serveless component that based on the payload of the event, will query an external service.  
In the second example we will see how variations in a NoSQL database can trigger events and be visualized.  

## Prerequisites
* having a running OpenShift cluster or CodeReady Containers (v4.6+)
* having installed Serverless operators on the cluster [like this](https://docs.openshift.com/container-platform/4.9/serverless/install/install-serverless-operator.html)
* having prepared the cluster for Fuse [deployments](https://access.redhat.com/documentation/en-us/red_hat_fuse/7.10/html/fuse_on_openshift_guide/get-started-admin)

# Components setup
## AMQ Streams installation
## Knative installation
Knative eventing, serving and knative kafka installation in default knative namespaces
create event source kafkasource in case of connecting directly kafkasource with serving endpoint
otherwise connect kafkasource to default knative broker and then create trigger with filtering
## Fuse installation

# First example
## Fuse project
Based on Red Hat Fuse 7.10 (Apache Camel 2.x) and SpringBoot 2

### description

### deployment on OpenShift
using jkube plugin
`mvn  install -Popenshift`

### usage

## Quarkus project

### description

### deployment on OpenShift
using the serverless option in application.properties
`quarkus.kubernetes.deployment-target=knative`

to deploy use:
`mvn clean package -Dquarkus.kubernetes.deploy=true`

### usage

# Second example

## mongodb events
installed mongodb bitnami
https://dev.to/tylerauerbeck/deploying-bitnami-s-postgres-helm-chart-on-openshift-1mcl
https://github.com/bitnami/charts/tree/master/bitnami/mongodb
built serving with event display

kamelet source mongodb
https://camel.apache.org/camel-kamelets/0.7.x/mongodb-source.html
tracking id option working only with capped collection (https://www.mongodb.com/docs/manual/reference/glossary/#std-term-capped-collection)