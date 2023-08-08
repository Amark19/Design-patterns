package net.media.training.designpattern.abstractfactory;

public abstract class PhoneFactory {
    
    public abstract MotherBoard buildMotherBoard();
    public abstract Screen buildScreen();
    public abstract Battery somBattery();
    public abstract Case buildCase();
}
