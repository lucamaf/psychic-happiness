# Overview
In this tutorial we will show how to build two simple examples of serverless enabled microservice architecture.  

In the first one we will explore how events coming from Kafka can trigger the execution of a serveless component that based on the payload of the event, will query an external service.

In the second example we will see how variations in a NoSQL database can trigger events and be visualized.  

## Prerequisites
* having a running OpenShift cluster or CodeReady Containers (v4.6+)
* having installed Serverless operators on the cluster [like this](https://docs.openshift.com/container-platform/4.9/serverless/install/install-serverless-operator.html)
* having prepared the cluster for Fuse [deployment](https://access.redhat.com/documentation/en-us/red_hat_fuse/7.10/html/fuse_on_openshift_guide/get-started-admin)
* having a working version of apache maven [v3.8.1 minimum](https://access.redhat.com/documentation/en-us/red_hat_build_of_quarkus/2.2/guide/e75e6f99-0d92-4236-bfb8-2de30a6a605d)
* updating the maven settings to point to <span style="color:red">Red Hat</span> repository [like this](https://access.redhat.com/documentation/en-us/red_hat_build_of_quarkus/2.2/guide/e75e6f99-0d92-4236-bfb8-2de30a6a605d#_edb1ae30-5684-4d33-965e-793f06026280)

# Components setup
## AMQ Streams installation
You first need to install AMQ Streams operator [like this]()  
AMQ Streams as an Operator will give you access to the whole Kafka ecosystem managed in a kubernetes way

You can then create the Kafka cluster 

### Monitoring AMQ Streams

## Knative installation
Knative eventing, serving and knative kafka installation in default knative namespaces
create event source kafkasource in case of connecting directly kafkasource with serving endpoint
otherwise connect kafkasource to default knative broker and then create trigger with filtering

### Monitoring Knative


## Fuse installation

# First example
## [Fuse project](https://github.com/lucamaf/psychic-happiness/tree/main/grateful-hill)
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