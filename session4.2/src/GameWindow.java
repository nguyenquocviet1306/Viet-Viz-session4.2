import controllers.Colliable;
import controllers.CollsionPool;
import controllers.EnemyManager;
import controllers.PlaneController;

import utils.Utils;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


/**
 * Created by Viet on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;

    BufferedImage bufferedImage;
    Graphics bufferImageGraphic;
    Thread thread;

//    PlaneController planeController1;

    public GameWindow() {
        System.out.println("Game window constructor");
        this.setVisible(true);
        this.setSize(600, 800);
        this.setLocation(0, 0);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        background =  Utils.loadImage("resources/background.png");


        this.addKeyListener(PlaneController.planeController);

//        this.addMouseMotionListener(new MouseMotionListener() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                plane1.moveTo(e.getX() - plane2Width / 2,
//                        e.getY() - plane2Height / 2);
//
//            }
//
//        });

        this.bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        this.bufferImageGraphic = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void update(Graphics g) {
        bufferImageGraphic.drawImage(background, 0, 0, null);

        PlaneController.planeController.draw(bufferImageGraphic);
        EnemyManager.instance.draw(bufferImageGraphic);

        g.drawImage(bufferedImage, 0, 0, null);

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(17);
                PlaneController.planeController.run();
                EnemyManager.instance.run();
                CollsionPool.instance.run();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
