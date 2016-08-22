package controllers;

import models.GameObject;
import views.GameDrawer;

/**
 * Created by Viet on 8/20/2016.
 */
public class FollowPlaneController extends SingleController implements Colliable {
    public FollowPlaneController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
