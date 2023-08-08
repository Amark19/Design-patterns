package net.media.training.designpattern.decorator;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 11:51:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class GRETOEFL extends GPAEval {

    @Override
    public boolean evaluate(Application theApp) {
        return super.evaluate(theApp)
                && theApp.getGre() > 1450
                && theApp.getToefl() > 100;
                new TOFLDecorator(new GREDecorator(new GPAEval())).evaluate(theApp);
    }
}

//  new Registerar(new Application(8,3,7),new GRE(new TOFL()),)
