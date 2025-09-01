## Comando para execução do RabbitMQ em container

```cmd
docker run -d --name myRabbit -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=123456 -p 5672:5672 -p 8080:15672 rabbitmq:3-management
```