package it.unibas.scacchi.modello;

public class Mossa {
    
    private int prevX;
    private int prevY;
    private int succX;
    private int succY;

    //Costruttori
    
    public Mossa(int prevX, int prevY, int succX, int succY) {
        this.prevX = prevX;
        this.prevY = prevY;
        this.succX = succX;
        this.succY = succY;
    }

    //Metodi Classe

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mossa{prevX=").append(prevX);
        sb.append(", prevY=").append(prevY);
        sb.append(", succX=").append(succX);
        sb.append(", succY=").append(succY);
        sb.append('}');
        return sb.toString();
    }

    
    
    //Metodi Get e Set
    
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mossa other = (Mossa) obj;
        if (this.succX != other.succX) {
            return false;
        }
        if (this.succY != other.succY) {
            return false;
        }
        return true;
    }


    
    
    
    
}
