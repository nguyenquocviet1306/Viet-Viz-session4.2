package controllers.gift;

import controllers.Colliable;
import controllers.PlaneController;
import controllers.SingleController;
import controllers.enemies.EnemyController;
import controllers.enemies.EnemyControllerManager;
import models.Fire;
import models.GameObject;
import models.GameObjectWithHP;
import views.AnimationDrawer;
import views.GameDrawer;

import java.awt.*;
import java.util.Iterator;

/**
 * Created by Viet on 8/20/2016.
 */
public class FireController extends SingleController implements Colliable {
    private double R = 200;

    public FireController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    @Override
    public void run() {
        super.run();
        int nX = PlaneController.instance.getGameObject().getX();
        int nY = PlaneController.instance.getGameObject().getY();
        this.getGameObject().moveTo(nX - 57, nY - 57);

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


    @Override
    public void onCollide(Colliable colliable) {

    }
}
