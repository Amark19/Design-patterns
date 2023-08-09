package net.media.training.designpattern.decorator;

public class GRE_Decorator extends CriteriaDecorator {

    Criteria criteria;
    GRE_Decorator(Criteria criteria){
        this.criteria = criteria;
    }
    public boolean evaluate(Application app){
        if (criteria.evaluate(app)){
            return app.getGre()>1450;
        }
        else{
            return false;
        }

    }
    
}