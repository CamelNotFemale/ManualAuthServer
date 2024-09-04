```
docker pull postgres:12-alpine
```

```
docker run -d -p 5555:5432 --name db 
    -e POSTGRES_USER=admin 
    -e POSTGRES_PASSWORD=password 
    -e POSTGRES_DB=demo 
    postgres:12-alpine
```