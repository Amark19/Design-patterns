package net.media.training.designpattern.observer;

public interface CharacterObserver {
    
    // void update(boolean isSunRisen);
    void notifySunRose();
    void notifySunSet();
    boolean isOutdoors();


}
