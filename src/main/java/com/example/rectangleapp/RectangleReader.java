package com.example.rectangleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class RectangleReader {

    private RectangleRepository rectangleRepository;

    @Autowired
    public RectangleReader(RectangleRepository rectangleRepository) {
        this.rectangleRepository = rectangleRepository;
    }

    @Value("${height1}")
    private int height1;
    @Value("${width1}")
    private int width1;

    @Value("${width2}")
    private int height2;
    @Value("${width2}")
    private int width2;

    @Value("${width3}")
    private int height3;
    @Value("${width3}")
    private int width3;

    @Value("${width4}")
    private int height4;
    @Value("${width4}")
    private int width4;

    //@GetMapping("/add") - mozna tak ale to metoda chyba chałupnicza
    @EventListener(ApplicationReadyEvent.class)  // dodaje do bazy danych w momencie gdy aplikacja jest gotowa do startu
    public void addRectangles(){
        Rectangle rectangle1 = new Rectangle(height1,width1);
        Rectangle rectangle2 = new Rectangle(height2,width2);
        Rectangle rectangle3 = new Rectangle(height3,width3);
        Rectangle rectangle4 = new Rectangle(height4,width4);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        rectangleRepository.save(rectangle1);
        rectangleRepository.save(rectangle2);
        rectangleRepository.save(rectangle3);
        rectangleRepository.save(rectangle4);
    }

}
