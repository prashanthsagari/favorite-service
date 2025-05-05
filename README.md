# Favorite Service

This project involves deploying the `favorites-service` with a MySQL database on Minikube.

## Prerequisites

Before you begin, ensure you have the following installed:

- **Minikube**: For local Kubernetes clusters.
- **Docker**: To build and manage container images.
- **Maven**: To build the Java project.
- **kubectl**: To interact with the Kubernetes cluster.
- **MySQL Docker Image**: Used to create the MySQL database.

## Setup Instructions

### 1. Start Minikube

Run the following command to start Minikube with Docker as the driver:

Run below commands using Powershell if  you are using Windows OS
# start minikube in docker 
minikube start --driver=docker

# run below command Connect to Minikube Docker (`& minikube docker-env  Invoke-Expression`)
# Otherwise the image will be in your local PC, not inside Minikube’s Docker engine.
& minikube docker-env | Invoke-Expression

docker pull mysql:8.0

# (Name: minikube)
docker info  

# run below command 
mvn clean install  

# Build image 
docker build -t favorites-service:latest .
docker tag favorites-service:latest sagariprashanth/favorites-service:latest
docker push sagariprashanth/favorites-service:latest


# verify image is creation
docker images


-- kubectl scale deployment mysql --replicas=0

kubectl apply -f k8s/mysql-deployment.yaml
kubectl apply -f k8s/mysql-service.yaml
kubectl apply -f k8s/favorites-deployment.yaml
kubectl apply -f k8s/favorites-service.yaml


kubectl port-forward svc/favorites-service 9000:9000
kubectl port-forward svc/mysql 3307:3306

# Delete old deployments 
kubectl delete deployment favorites-service
kubectl delete service favorites-service
kubectl delete -f k8s/mysql-deployment.yaml
kubectl delete -f k8s/mysql-service.yaml

# Stop minikube
minikube stop