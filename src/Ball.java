import java.util.Random;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball implements Runnable {

    int xBall, yBall, xDirection, yDirection;

    Rectangle ball;

    int p1Point, p2Point;

    Player p1 = new Player(10, 25, 1);
    Player p2 = new Player(485, 25, 2);

    public Ball(int xBall, int yBall) {
        p1Point = p2Point = 0;
        this.xBall = xBall;
        this.yBall = yBall;

        Random r = new Random();
        moveBola(r);

        ball = new Rectangle(this.xBall, this.yBall, 30, 30);
    }

    private void moveBola(Random r) {
        int rXDir = 0;
        rXDir--;
        setxDirection(rXDir);
        int rYDir = 0;
        rYDir--;
        setyDirection(rYDir);
    }

    public void draw(Graphics gb) {
        gb.setColor(Color.WHITE);
        gb.fillOval(ball.x, ball.y, 15, 15);
    }

    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    @Override
    public void run() {
        try {
            while (Game.isGame()) {
                move();
                Thread.sleep(3);
            }
        } catch (Exception e) {
            Game.setGame(false);
        }

    }

    private void move() {
        collision();
        ball.x += xDirection;
        ball.y += yDirection;

        if (ball.x <= 0) {
            setxDirection(+1);
            p2Point++;
            ball.setLocation(xBall, yBall);
        }
        if (ball.x >= 485) {
            setxDirection(-1);
            p1Point++;
            ball.setLocation(xBall, yBall);
        }
        if (ball.y <= 15) {
            setyDirection(+1);
        }
        if (ball.y >= 385) {
            setyDirection(-1);
        }

    }

    private void collision() {
        if(ball.intersects(p1.player))
            setxDirection(+1);
        if(ball.intersects(p2.player))
            setxDirection(-1);

    }

}