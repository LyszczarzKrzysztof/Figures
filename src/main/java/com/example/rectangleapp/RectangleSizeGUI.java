package com.example.rectangleapp;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class RectangleSizeGUI extends VerticalLayout {


    private RectangleRepository rectangleRepository;

    private TextArea textAreaRectangles;

    private TextField size;

    private Button buttonBigger;

    private Button buttonSmaller;

    private int sizeToOperate;

    public int getSizeToOperate() {
        return sizeToOperate;
    }

    public void setSizeToOperate(int sizeToOperate) {
        this.sizeToOperate = sizeToOperate;
    }

    @Autowired
    public RectangleSizeGUI(RectangleRepository rectangleRepository) {
        this.rectangleRepository = rectangleRepository;
        size = new TextField("Podaj obwód graniczy: ");
        textAreaRectangles = new TextArea("Rezulat: ");
        buttonBigger = new Button("Pokaż wieksze niż: "+size.getValue());
        buttonSmaller = new Button("Pokaż mniejsze lub równe: "+size.getValue());

        buttonBigger.addClickListener(
                buttonClickEvent -> textAreaRectangles.setValue(
                        rectangleRepository.getBigRectangles(Integer.parseInt(size.getValue())).toString()));
        buttonSmaller.addClickListener(
                buttonClickEvent -> textAreaRectangles.setValue(
                        rectangleRepository.getSmallRectangles(Integer.parseInt(size.getValue())).toString()));

        add(size);

        add(buttonBigger);

        add(buttonSmaller);

        add(textAreaRectangles);

    }
}
