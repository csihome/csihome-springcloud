# csihome-springcloud
demo of spring cloud project in docker compose

## Centralized Properties by Pull mode 
* Spring Cloud Config Repo in GitHub: config-repo
* Spring Cloud Config Server: config-server
* Spring Cloud Config Client App: foo-service

```commandline
# Step 1 Check current property value
curl -i -X GET http://localhost:8090/foo

# Step 2 Update property: foo.service.message by increasing Version No.
https://github.com/csihome/csihome-springcloud-config-repo/blob/master/foo-service.properties

# Step 3 Check what value in Git repo now:
curl -i -X GET http://localhost:8888/foo-service/default

# Step 4 Trigger App service to refresh property value
curl -i -X POST http://localhost:8090/refresh

# Step 5 Check what value in App Service now:
curl -i -X GET http://localhost:8090/foo
```

## Centralized Properties by Pull mode, plus Discovery Service
* Spring Cloud Config Repo in GitHub: config-repo
* Spring Cloud Config Server: config-server
* Spring Cloud Discovery Server: discovery-server
* Spring Cloud Config Client App: foo-service

```commandline
# Step 1 Build docker image for all 4 components
cd {bar-service|spring-cloud-config|spring-cloud-discovery}
mvn docker:build

# Step 2 Run docker compose command
docker-compose up

# Step 3 Check if bar-service and config-server up, and what property value getting? 
curl -i -X GET http://localhost:8091/bar
curl -i -X GET http://localhost:8888/bar-service/default

# Step 4 Check if services registered in discovery server
open browser http://localhost:8761/

# Step 5 Refresh bar-service to fetch possible update:
curl -i -X POST http://localhost:8091/refresh

# Step 6 Check again what property value bar-service is using?
curl -i -X GET http://localhost:8091/bar
```

## Centralized Properties by Post mode
 
### Spring Cloud Config Client App: dv-service

### Spring Cloud Discovery Server: eureka-service

### RabbitMQ


```commandline
docker-compose up
```