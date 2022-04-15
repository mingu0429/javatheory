package oopCh11;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingBall extends Applet implements ActionListener {
    private Button start, stop;
    private Ball ball[];
    private int nBalls;

    public void init() {
        start = new Button("Start");  add(start);
        start.addActionListener(this);
        stop = new Button("Stop"); add(stop);
        stop.addActionListener(this);
        ball = new Ball[100]; // maximum one hundred balls
        nBalls = 0;
    }
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == start) {
            Graphics g = getGraphics();
            if (nBalls < 100) {
                ball[nBalls] = new Ball(g);
                ball[nBalls++].start();
            }
        } else
        if (e.getSource() == stop) {
            if (nBalls > 0)  ball[--nBalls].stopBouncing();
        }
    }
}

class Ball extends Thread {
    private boolean bBouncing;
    private Graphics g;
    private int diameter = 10;
    private int Rleft = 20, Rright = 140;
    private int Rtop = 35, Rbottom = 120;
    private int x = Rleft+10, dx = 5;
    private int y = Rtop +13, dy = 5;

    public Ball (Graphics g) {
        this.g = g;
        bBouncing = true;
    }
    public void stopBouncing() { bBouncing = false; }
    public void run() {
        g.drawRect(Rleft, Rtop, Rright-Rleft, Rbottom-Rtop);
        while (bBouncing) {
            g.setColor (Color.white);
            g.fillOval (x, y, diameter, diameter);
            if (x + dx <= Rleft)  dx = -dx;
            if (x + diameter + dx >= Rright)  dx = -dx;
            if (y + dy <= Rtop)   dy = -dy;
            if (y + diameter + dy >= Rbottom) dy = -dy;
            x += dx;
            y += dy;
            g.setColor (Color.red);
            g.fillOval (x, y, diameter, diameter);
            try { sleep(100); } catch (InterruptedException e) {
                System.out.println("sleep exception");
            }
        }
    }
}

