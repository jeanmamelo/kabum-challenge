# KaBuM! Back-end Challenge
 
 A REST API designed to retrieve the available shipping options according to the input sent inside the request body. Built using [Java 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html) with [Spring Boot Framework](https://spring.io/) using an Object Oriented approach and unit tests implemented using [JUnit 5.4.2](https://junit.org/junit5/).

## Getting Started

### Follow the instructions to get a copy of the project up and running using [IntelliJ IDE](https://www.jetbrains.com/pt-br/idea/).

- Clone or download the repo.
- Open the project in IntelliJ IDE.
- Go to src/main/java/com/jeanmamelo/kabumchallenge.
- Then run the KabumChallengeApplication method inside KabumChallengeApplication.java.

### Sendind the requests using [Postman](https://www.postman.com/)

- With the project running, open Postman and send an POST request to `http://127.0.0.1:8080/shippings`.
- Use the body of the HTTP request to inform the input data in JSON format.

### Test cases

#### input

```json
{
    "dimensao": {
        "altura":102,
        "largura":40
    },
    "peso":400
}
```

#### output

```json
[
    {
        "nome":"Entrega Ninja",
        "valor_frete": 12.00,
        "prazo_dias": 6
    },
    {
        "nome":"Entrega KaBuM",
        "valor_frete": 8.00,
        "prazo_dias": 4
	}
]
```

---

#### input

```json
{
    "dimensao": {
        "altura":152,
        "largura":50
    },
    "peso":850
}
```

#### output

```json
[
    {
        "nome":"Entrega Ninja",
        "valor_frete": 25.50,
        "prazo_dias": 6
    }
]
```

---

#### input

```json
{
    "dimensao": {
        "altura":230,
        "largura":162
    },
    "peso":5600
}
```

#### output

```json
[]
```

### If you want to run the unit tests
- Add JUnit 5.4.2 to your classpath.
- Go to src/test/java/com/jeanmamelo/kabumchallenge/controller.
- Run the ShippingControllerTest class inside ShippingControllerTest.java.
- Go to src/test/java/com/jeanmamelo/kabumchallenge/controller.
- Run the ShippingServiceTest class inside ShippingServiceTest.java.