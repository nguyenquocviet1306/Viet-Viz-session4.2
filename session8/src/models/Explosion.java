package models;

/**
 * Created by Viet on 8/20/2016.
 */
public class Explosion extends GameObject {
    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;

    public Explosion(int x, int y ) {
        super(x, y, WIDTH, HEIGHT);
    }
}
