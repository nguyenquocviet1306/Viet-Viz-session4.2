package controllers.bombs;

import controllers.*;
import controllers.enemies.EnemyController;
import controllers.enemies.EnemyControllerManager;
import controllers.gift.FireController;
import models.Fire;
import models.GameObject;
import models.Gift;
import utils.Utils;
import views.AnimationDrawer;
import views.GameDrawer;
import views.ImageDrawer;

import java.util.Iterator;

/**
 * Created by Viet on 8/20/2016.
 */
public class GiftController extends SingleController implements Colliable {
    public static final int SPEED = 3;
    private double R = 200;

    public GiftController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }

    public static GiftController create(int x, int y) {
        return new GiftController(
                new Gift(x,y),
                new ImageDrawer("resources/giftbox.png")
        );
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {
            GameObject target = PlaneController.instance.getGameObject();
            NotificationCenter.instance.onGift(gameObject.getX(),gameObject.getY());
            gameObject.destroy();

            FireController fireController = new FireController(
                    new Fire(target.getX() - 57 ,target.getY() - 57 ),
                    new AnimationDrawer(
                            Utils.loadImages(
                                    "resources/fire_5.png",
                                    "resources/fire_6.png",
                                    "resources/fire_7.png",
                                    "resources/fire_8.png",
                                    "resources/fire_5.png",
                                    "resources/fire_6.png",
                                    "resources/fire_7.png",
                                    "resources/fire_8.png",
                                    "resources/fire_5.png",
                                    "resources/fire_6.png",
                                    "resources/fire_7.png",
                                    "resources/fire_8.png",
                                    "resources/fire_5.png",
                                    "resources/fire_6.png",
                                    "resources/fire_7.png",
                                    "resources/fire_8.png",
                                    "resources/fire_7.png",
                                    "resources/fire_8.png")
                    )
            );
            GiftControllerManager.instance.add(fireController);
        }
        if (colliable instanceof PlaneController) {
            Iterator<SingleController> singleControllerIterator =
                    EnemyControllerManager.instance.getSingleControllerVector().iterator();
            while (singleControllerIterator.hasNext()) {
                System.out.println("aaaaaaaaa");
                SingleController enemyController = singleControllerIterator.next();
                int dx = this.gameObject.getX() - enemyController.getGameObject().getX();
                int dy = this.gameObject.getY() - enemyController.getGameObject().getY();
                double R1 = Math.sqrt(dx * dx + dy * dy);
                if (R1 < R) {
                    enemyController.getGameObject().destroy();
                    System.out.println("âsvsf");

                }

            }
        }

    }
}
