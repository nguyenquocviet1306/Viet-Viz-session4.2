package controllers;

import models.GameObject;
import views.AnimationDrawer;
import views.GameDrawer;

import java.awt.*;

/**
 * Created by Viet on 8/20/2016.
 */
public class ExplosionController extends SingleController{

    public ExplosionController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (gameDrawer instanceof AnimationDrawer) {
            if (((AnimationDrawer) gameDrawer).animationReachEnd()) {
                gameObject.destroy();
            }

        }
    }
}
