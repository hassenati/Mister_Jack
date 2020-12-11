package fr.hassenati;

public class District {
    /*
    orientation 0 :
     ===
      |
     */

    private final Card card;
    private boolean isSuspect;
    private Direction orientation;

    public District(Card card) {
        this.card = card;
        this.orientation = Direction.NORTH;
    }

    public District(Card card, Direction orientation) {
        this.card = card;
        this.orientation = orientation;
    }


    public void rotate() {
        this.rotate(1);
    }

    public void rotate(int times) {
        this.orientation = Direction.values()[(this.orientation.ordinal() + times) % 4];
    }

    public void setOrientation(Direction orientation) {
        this.orientation = orientation;
    }


    public Card getCard() {
        return card;
    }

    public boolean isSuspect() {
        return isSuspect;
    }

    public Direction getOrientation() {
        return orientation;
    }

    private void setInnocent(){
        this.isSuspect = false;
    }

    @Override
    public String toString() {
        switch (this.orientation.ordinal()){
            case 0:
                return "╦";
            case 1:
                return "╣";
            case 2:
                return "╩";
            default:
                return "╠";

        }
    }
}
