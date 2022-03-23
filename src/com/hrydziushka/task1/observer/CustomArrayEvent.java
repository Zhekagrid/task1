package com.hrydziushka.task1.observer;

import com.hrydziushka.task1.entity.AbstractCustomArray;

import java.util.EventObject;

public class CustomArrayEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CustomArrayEvent(AbstractCustomArray source) {
        super(source);
    }

    @Override
    public AbstractCustomArray getSource() {
        return (AbstractCustomArray) super.getSource();
    }
}
