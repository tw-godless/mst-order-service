#! /usr/bin/env bash
set -x
set -e
export RANCHER_URL=http://10.202.129.18:8080/v2-beta/projects/1a5
export RANCHER_ACCESS_KEY=948B1C2BB5B74DEA1E82
export RANCHER_SECRET_KEY=fpWkrio33Eq1thW2kTdrzmW6dANVRaS5LCVgb6zt

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
      DOCKER_REGISRTY=10.11.179.48:5000
    fi
   
        IMAGE_NAME=${DOCKER_REGISRTY}/tw-godless/order-service:${GO_PIPELINE_COUNTER}

        sed -i "s#<IMAGE_NAME>#$IMAGE_NAME#g" docker-compose.yml

        rancher-compose -p mst-order-service up -d -c --upgrade
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
