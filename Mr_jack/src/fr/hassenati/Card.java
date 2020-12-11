package fr.hassenati;

public enum Card {
    PINK,
    BLACK,
    ORANGE,
    MAGENTA,
    GREEN,
    YELLOW,
    BLUE,
    WHITE,
    GREY;

    public int getHourglass(){
        int[] hourglass = {2,0,1,1,1,1,0,1,1};
        return hourglass[this.ordinal()];
    }
}