package com.example.rectangleapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rectangle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.width=width;
        this.height=height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "id=" + id +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
