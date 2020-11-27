package it.unibas.scacchi.modello;

public class Mossa {
    
    private int prevX;
    private int prevY;
    private int succX;
    private int succY;

    public Mossa(int prevX, int prevY, int succX, int succY) {
        this.prevX = prevX;
        this.prevY = prevY;
        this.succX = succX;
        this.succY = succY;
    }

    public int getPrevX() {
        return prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public int getSuccX() {
        return succX;
    }

    public int getSuccY() {
        return succY;
    }
    
    
    
}
