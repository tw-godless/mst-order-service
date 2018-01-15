#! /usr/bin/env bash
set -x
set -e

function test {
    docker run --rm -v /tmp/gradle-caches:/root/.gradle/caches -v $WORKDIR/pipelines/$GO_PIPELINE_NAME:/opt/app -w /opt/app gradle:4.4.1-jdk8 gradle clean test
}

function build {
    docker run --rm -v /tmp/gradle-caches:/root/.gradle/caches -v $WORKDIR/pipelines/$GO_PIPELINE_NAME:/opt/app -w /opt/app gradle:4.4.1-jdk8 gradle clean bootRepackage
    if [[ -z $DOCKER_REGISRTY ]]; then
        DOCKER_REGISRTY=127.0.0.1:5000
    fi
    IMAGE_NAME=${DOCKER_REGISRTY}/tw-godless/order-service:${GO_PIPELINE_COUNTER}
    docker build -t $IMAGE_NAME .
    docker push $IMAGE_NAME
    docker rmi $IMAGE_NAME
}

function deploy {
    if [[ -z $DOCKER_REGISRTY ]]; then
      DOCKER_REGISRTY=127.0.0.1:5000
    fi
   
        IMAGE_NAME=${DOCKER_REGISRTY}/tw-godless/order-service:${GO_PIPELINE_COUNTER}

        sed -i "s#<IMAGE_NAME>#$IMAGE_NAME#g" docker-compose.yml

        rancher-compose -p mst-user-service up -d -c --upgrade
}

case $1 in
    test)
        test
        ;;
    build)
        build
        ;;
    deploy)
        deploy
        ;;
    *)
        display-usage
        exit -1
esac
