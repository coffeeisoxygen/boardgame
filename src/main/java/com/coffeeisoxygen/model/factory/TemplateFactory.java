package com.coffeeisoxygen.model.factory;

import java.util.List;

import com.coffeeisoxygen.model.interfaces.IBoardTemplate;
import com.coffeeisoxygen.model.templates.FirstTemplate;
import com.coffeeisoxygen.model.templates.SecondTemplate;
import com.coffeeisoxygen.model.templates.ThirdTemplate;

public class TemplateFactory {
    private TemplateFactory() {
        // private constructor to hide the implicit public one
    }
    public static List<IBoardTemplate> getAvailableTemplates() {
        return List.of(
            new FirstTemplate(),
            new SecondTemplate(),
            new ThirdTemplate()
        );
    }
}
