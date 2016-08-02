package controllers;

import models.BulletEnemy;
import views.GameDrawer;

/**
 * Created by Viet on 8/2/2016.
 */
public class BulletEnemyController extends SingleController implements Colliable {
    private final static int SPEED = 10;
    public BulletEnemyController(BulletEnemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        CollsionPool.instance.add(this);
    }
    public void run() {
        super.run();
        if (gameObject.getY() > 600) {
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            this.getGameObject().destroy();
//            this.getGameObject().destroy();
        }
    }
}
