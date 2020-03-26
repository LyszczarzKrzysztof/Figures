package com.example.rectangleapp;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RectangleRepository extends CrudRepository<Rectangle, Long> {

    @Query(value = "SELECT * FROM RECTANGLE rect where (2*rect.height+2*rect.width) > :size ",nativeQuery = true)
    List<Rectangle> getBigRectangles(@Param("size") int size);

    @Query(value = "SELECT * FROM RECTANGLE rect where (2*rect.height+2*rect.width) <= :size ",nativeQuery = true)
    List<Rectangle> getSmallRectangles(@Param("size") int size);
}
