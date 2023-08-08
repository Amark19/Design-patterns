package net.media.training.designpattern.decorator;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 10:28:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class GREEval implements StdEvaluator {

    private Criteria criteria;

    public GREEval(Criteria criteria) {
        this.criteria = criteria;
    }

    public boolean evaluate(Application theApp) {
        if (super.evaluate(theApp)) {
            System.out.println("GREEval called");
            return theApp.getGre() > 1450 && criteria.evaluate(theApp);
        } else {
            return false;
        }
    }
}
