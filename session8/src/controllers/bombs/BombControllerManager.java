package controllers.bombs;

import controllers.ControllerManager;

import java.util.Random;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public class BombControllerManager extends ControllerManager {

    private int count;
    private static final int BOMB_PERIOD = 150;
    private static final int LOCK_PERIOD = 200;
    private static final int GIFT_PERIOD = 201;


    public static final BombControllerManager instance = new BombControllerManager();

    @Override
    public void run() {
        count++;

        Random r = new Random();
        int x = r.nextInt(600);
        int y = r.nextInt(800);

        if(count == LOCK_PERIOD) {
            count = 0;
            LockController lockController = LockController
                    .create(x, y);
            this.add(lockController);
        }
        else if(count == BOMB_PERIOD) {

            /*  Generate bomb */
            BombController bombController = BombController
                    .create(x, y);
            this.add(bombController);
        }
//         else if(count == GIFT_PERIOD) {
//
//            /*  Generate bomb */
//            GiftController giftController = GiftController
//                    .create(x, y);
//            this.add(giftController);
//            System.out.println("aaaa");
//        }


        super.run();
    }
}