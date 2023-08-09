package net.media.training.designpattern.decorator;

public class TOEFL_Decorator extends CriteriaDecorator {
    Criteria criteria;
    TOEFL_Decorator(Criteria criteria){
        this.criteria = criteria;
        } 
    
    public boolean evaluate(Application app){
        if (criteria.evaluate(app)){
            System.out.println("TOEFL Called");
            return app.getGpa() > 100;
        }
        else{
            return false;
        }
    }
}