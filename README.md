# csihome-springcloud
demo of spring cloud project in docker compose

## Centralized Properties by Pull mode 
* Spring Cloud Config Repo in GitHub: config-repo
* Spring Cloud Config Server: config-server
* Spring Cloud Config Client App: foo-service

```commandline
# Step 1 Check current property value
curl -i -X GET http://localhost:8090/message

# Step 2 Update property: foo.service.message by increasing Version No.
https://github.com/csihome/csihome-springcloud-config-repo/blob/master/foo-service.properties

# Step 3 Check what value in Git repo now:
curl -i -X GET http://localhost:8888/foo-service/default

# Step 4 Trigger App service to refresh property value
curl -i -X POST http://localhost:8090/refresh

# Step 5 Check what value in App Service now:
curl -i -X GET http://localhost:8090/message
```

## Centralized Properties by Post mode
 
### Spring Cloud Config Client App: dv-service

### Spring Cloud Discovery Server: eureka-service

### RabbitMQ


```commandline
docker-compose up
```