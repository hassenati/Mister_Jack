package fr.hassenati;

public enum Detective {
    HOLMES(11),
    WATSON(3),
    TOBY(7);

    Detective(int position){
        this.position = position;
    }

    private int position;

    public int getPosition() {
        return position;
    }

    public void movePosition(int distance) {
        this.position = (position + distance) % 12;
    }

    @Override
    public String toString() {
        return this.name()+"("+position+")";
    }
}
