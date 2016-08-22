package controllers.bombs;

import models.GameObject;

/**
 * Created by Viet on 8/20/2016.
 */
public interface GiftSubscriber {
    public void onGift(int x, int y);
    public GameObject getGameObject();
}
