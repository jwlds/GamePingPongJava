import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player implements Runnable {

     int xPlayer, yPlayer, yDirection, PlayerId;

    public Rectangle player;

    public Player(int xPlayer, int yPlayer, int PlayerId) {
        this.xPlayer = xPlayer;
        this.yPlayer = yPlayer;
        this.PlayerId = PlayerId;

        player = new Rectangle(xPlayer, yPlayer, 10, 50);
    }

    public int getyDirection() {
        return yDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    @Override
    public void run() {
        try {
            while (true) {
                move();
                Thread.sleep(7);
            }
        } catch (Exception e) {

        }

    }

    private void move() {
        player.y += getyDirection();
        if (player.y <= 30) {
            player.y = 30;
        }
        if (player.y >= 340) {
            player.y = 340;
        }
    }

    public void draw(Graphics g) {
        switch(PlayerId) {
            default:
                System.out.println("Não é um id valido");
                break;
            case 1:
                g.setColor(Color.RED);
                g.fillRect(player.x, player.y, player.width, player.height);
                break;
            case 2:
                g.setColor(Color.BLUE);
                g.fillRect(player.x, player.y, player.width, player.height);
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        switch(PlayerId) {
            default:
                System.out.println("Não é um id valido");
                break;
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W)
                    setyDirection(-1);
                if(e.getKeyCode() == KeyEvent.VK_S)
                    setyDirection(1);
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP)
                    setyDirection(-1);
                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    setyDirection(1);
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch(PlayerId) {
            default:
                System.out.println("Não é um id valido");
                break;
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W)
                    setyDirection(0);
                if(e.getKeyCode() == KeyEvent.VK_S)
                    setyDirection(0);
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP)
                    setyDirection(0);
                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    setyDirection(0);
                break;
        }
    }
}