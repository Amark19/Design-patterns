package net.media.training.designpattern.observer;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 9:12:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sun {
    private boolean isUp;
    // private final Robot robot;
    // private final Person person;
    // private final Dog dog;
    // private final Cat cat;
    private List<CharacterObserver> observers;

    // public Sun(Robot robot, Person person, Dog dog, Cat cat) {
    // this.robot = robot;
    // this.person = person;
    // this.dog = dog;s
    // this.cat = cat;
    // }

    public void addObserver(CharacterObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CharacterObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(boolean isSunRisen) {
        for (CharacterObserver observer : observers) {
            if (observer.isOutdoors()) {
                if (isSunRisen)
                    observer.notifySunRose();
                else
                    observer.notifySunSet();
            }
        }
    }

    public boolean isUp() {
        return isUp;
    }

    public void set() {
        isUp = false;
        notifyObservers(false);
    }

    public void rise() {
        isUp = true;
        notifyObservers(true);
    }
}