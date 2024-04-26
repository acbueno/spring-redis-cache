# Spring Redis Cache
## Projeto exemplo de uso de cache com Redis.

Este é um projeto simples que demonstra como usar o Redis como um cache em uma aplicação Spring Boot.

## Tecnologias Utilizadas

- Spring Boot
- Spring Data Redis
- Redis
- Maven

## Pré-requisitos

Antes de começar, certifique-se de ter os seguintes itens instalados em sua máquina:

- Java 8 ou superior
- Redis

## Executando a Aplicação

1. Clone o repositório:

   ```bash
   git clone https://github.com/acbueno/spring-redis-cache.git
   
2. Navegue até o diretório do projeto:
   ```bash
   cd spring-redis-cache
3. Construa o projeto:
   ```bash
   mvn clean install
4. Execute a aplicação:
    ```bash
  mvn spring-boot:run 
  
5. A aplicação estará acessível em http://localhost:8080. 

## Uso
 - GET /car/{id}: Recupera um carro pelo seu ID. Se o carro for encontrado no cache, ele será retornado do cache. Caso contrário, será buscado no banco de dados e armazenado no cache.
 - POST /car: Cria um novo carro. O carro criado será armazenado tanto no banco de dados quanto no cache.
- POST /car/clear-cache: Limpa o cache.

## Configuração
As configurações de conexão do Redis da aplicação podem ser configuradas no arquivo application.properties.
  ```properite
   spring.redis.host=localhost
   spring.redis.port=6379
##Licença
Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE para mais detalhes.

