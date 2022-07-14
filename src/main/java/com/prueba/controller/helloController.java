package com.prueba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController  {

    @Value("app.message")
    String message;

    @GetMapping("/hola")
    public String holaMundo() {
        System.out.println(message);
        return "Hola mundo, que tal?";
    }

//    @GetMapping("/bootstrap")
//    public String bootstrap() {
//        return """
//                <!doctype html>
//                <html lang="en">
//                  <head>
//                    <meta charset="utf-8">
//                    <meta name="viewport" content="width=device-width, initial-scale=1">
//                    <title>Bootstrap demo</title>
//                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
//                  </head>
//                  <body>
//                    <h1>Hola mundo desde Spring Boot!</h1>
//                    <a class="btn btn-primary" href="https://www.google.es"> Google </a>
//                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
//                  </body>
//                </html>
//                """;
//    }
}
