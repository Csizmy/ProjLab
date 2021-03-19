package Objects;

public class Asteroid {
    private int layer;
    private int digged;
    private boolean perihelion;
    
    public Asteroid() {
        layer = (int) Math.random()%10;
        digged = 0;
        
    }
    
    public void RemoveMaterial() {
        digged++;
    }
}
