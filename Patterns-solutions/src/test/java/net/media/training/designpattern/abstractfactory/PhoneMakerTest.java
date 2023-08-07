package net.media.training.designpattern.abstractfactory;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: path
 * Date: Jul 19, 2011
 * Time: 9:13:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhoneMakerTest {

    @Test
    public void AndroidPhoneIsMadeCorrectly() {
        PhoneMaker phone = new PhoneMaker() ;
        phone.buildPhone("Android");
    }
    
    @Test
    public void IPhoneIsMadeCorrectly() {
        PhoneMaker phone = new PhoneMaker() ;
        phone.buildPhone("Iphone");
    }
}

