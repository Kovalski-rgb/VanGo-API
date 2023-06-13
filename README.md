# VanGo-API
Api do VanGo

## Dependencias:
    - [Maven](https://maven.apache.org/install.html)

## Como rodar?
1 - Rode os seguintes comandos no seu terminal:

```
git clone https://github.com/Kovalski-rgb/VanGo-API.git
cd VanGo-API
```

2 - Crie uma database nomeada `VanGoApi` no `MySQL`

3 - Configure seu usuário no arquivo de propriedades, localizado aqui:
    `src/main/resources/application.properties`
    Mude os colchetes nas linhas dentro do arquivo para as informações de acesso da sua base de dados:
```
spring.datasource.username=[username]
spring.datasource.password=[password]
```

4 - Para inicializar o servidor, rode o seguinte comando dentro da pasta raiz:

    mvn spring-boot:run


Url para acessar a API: [http://localhost:8080/vango/api/swagger-ui/index.html](http://localhost:8080/vango/api/swagger-ui/index.html)
