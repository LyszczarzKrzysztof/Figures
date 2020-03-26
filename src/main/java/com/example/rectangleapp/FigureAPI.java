package com.example.rectangleapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FigureAPI {

    // przykładowy endpoint z parametrami do trojkąta http://localhost:8090/calculate?figure=TRIANGLE&height=10&width=20&thirdTriangleSide=30
    // przykładowy endpoint z parametrami do prostokąta  http://localhost:8090/calculate?figure=rectangle&height=10&width=20
    @GetMapping("calculate")
    public Integer calculateCicuit(@RequestParam String figure, Integer height, Integer width , @RequestParam(required = false) Integer thirdTriangleSide){

        if(figure.equalsIgnoreCase("rectangle"))
        {
            return 2*height+2*width;
        }
        else if(figure.equalsIgnoreCase("triangle"))
        {
            return height+width+thirdTriangleSide;
        }

        return null;
    }
}
