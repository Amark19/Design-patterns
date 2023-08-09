package net.media.training.designpattern.decorator;

public abstract class CriteriaDecorator implements Criteria {
    public abstract boolean evaluate(Application app);
}