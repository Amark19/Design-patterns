package net.media.training.designpattern.abstractfactory;

public class IphoneManufacturer extends PhoneFactory{
    Case phoneCase;
    public MotherBoard buildMotherBoard() {
        MotherBoard motherBoard = new IphoneMotherBoard();
        motherBoard.attachBattery(new Battery());
        motherBoard.attachProcessor(new IphoneProcessor());
        return motherBoard;
    }

    public Screen buildScreen() {
        return new IphoneScreen();
    }

    public Battery somBattery() {
        return new Battery();
    }

    public Case buildCase() {
        phoneCase = new IphoneCase();
        phoneCase.attachMotherBoard(buildMotherBoard());
        phoneCase.attachScreen(buildScreen());
        return phoneCase;
    }
}
