package controllers;

import models.Bullet;
import models.BulletEnemy;
import models.Enemy;
import views.ImageDrawer;

import java.util.Random;

/**
 * Created by Viet on 7/31/2016.
 */
public class EnemyManager extends ControllerManager {

    private Random rand = new Random();

    private EnemyManager() {
        super();
    }
    int t = 0;

    @Override
    public void run() {

        super.run();
        t++;
        if( t % 3 == 0 ) {
            int enY = rand.nextInt(500);
            int enX = rand.nextInt(200 ) ;
//            EnemyController enemyController = new EnemyController(
//                    new Enemy(enX, enY),
//                    new ImageDrawer("resources/enemy_plane_white_1.png")
//            );

            BulletEnemyController bulletEnemyController = new BulletEnemyController(
                    new BulletEnemy(enX,enY),
                    new ImageDrawer("resources/enemy_bullet.png")
            );
//            this.add(enemyController);
            this.add(bulletEnemyController);
        } else if (t % 2 == 0){
            int enX = rand.nextInt(500);
//            int enY = 50;
            int enY = rand.nextInt(200);
                 EnemyController enemyController = new EnemyController(
                    new Enemy(enX,enY),
                    new ImageDrawer("resources/enemy_plane_yellow_3.png")
           );
            BulletEnemyController bulletEnemyController = new BulletEnemyController(
                    new BulletEnemy(enX,enY),
                    new ImageDrawer("resources/enemy_bullet.png")
            );
            this.add(enemyController);
            this.add(bulletEnemyController);

        }
    }
    public final static EnemyManager instance = new EnemyManager();
}
