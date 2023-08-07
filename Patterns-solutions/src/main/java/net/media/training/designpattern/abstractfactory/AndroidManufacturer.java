package net.media.training.designpattern.abstractfactory;

public class AndroidManufacturer extends PhoneFactory {
    Case phoneCase;

    public MotherBoard buildMotherBoard() {
        MotherBoard motherBoard = new AndroidMotherBoard();
        motherBoard.attachBattery(new Battery());
        motherBoard.attachProcessor(new AndroidProcessor());
        return motherBoard;
    }

    public Screen buildScreen() {
        return new AndroidScreen();
    }

    public Battery somBattery() {
        return new Battery();
    }

    public Case buildCase() {

        phoneCase = new AndroidCase();
        phoneCase.attachMotherBoard(buildMotherBoard());
        phoneCase.attachScreen(buildScreen());
        return phoneCase;
    }
}
