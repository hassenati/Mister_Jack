package fr.hassenati;

public enum Jeton {
    JETON1,
    JETON2,
    JETON3,
    JETON4;

    private boolean isHead = true;
    private boolean isHoldByHolmes;

    public boolean isHead() {
        return isHead;
    }

    public void setHead(boolean head) {
        isHead = head;
    }

    public boolean isHoldByHolmes() {
        return isHoldByHolmes;
    }

    public void setHoldByHolmes(boolean holdByHolmes) {
        isHoldByHolmes = holdByHolmes;
    }

    @Override
    public String toString() {
        return this.name()+"("+isHead+")";
    }
}
