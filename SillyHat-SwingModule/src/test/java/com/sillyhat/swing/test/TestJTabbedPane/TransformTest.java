package com.sillyhat.swing.test.TestJTabbedPane;

/**
 * Created by ${XUSHIKUAN} on 2017-03-23.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransformTest extends JFrame {
    private static final long serialVersionUID = 1L;

    public TransformTest() {
        super();
        initData();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initData() {
        PaintPanel pp = new PaintPanel();
        pp.addLineString(new LineString(new Point(610, 210),
                new Point(30, 235), "First line"));
        pp.addLineString(new LineString(new Point(30, 235),
                new Point(190, 455), "Second line"));
        pp.addLineString(new LineString(new Point(190, 455),
                new Point(150, 20), "Third line"));
        setContentPane(pp);
    }

    private class PaintPanel extends JPanel {
        private List<LineString> list;

        public PaintPanel() {
            super();
            list = new ArrayList<LineString>();
        }

        public void addLineString(LineString ls) {
            if (ls != null) {
                list.add(ls);
            }
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            for (Iterator<LineString> it = list.iterator(); it.hasNext();) {
                LineString ls = it.next();
                g2d.drawLine(ls.getStartPoint().x, ls.getStartPoint().y, ls
                        .getEndPoint().x, ls.getEndPoint().y);

                AffineTransform defaultTransform = g2d.getTransform();
                int strWidth = SwingUtilities.computeStringWidth(g
                        .getFontMetrics(), ls.getLabel());
                double arc = ls.getArc();

                double midX = (ls.getEndPoint().getX() + ls.getStartPoint()
                        .getX()) / 2;
                double midY = (ls.getEndPoint().getY() + ls.getStartPoint()
                        .getY()) / 2;

                // choose either 1 or 2 below, very simple, you can also do many
                // things here
                /************** 1 ***************/
                // AffineTransform at = new AffineTransform();
                // at.rotate(arc, midX, midY);
                // g2d.transform(at);
                /*****************************/
                /************** 2 ***************/
                g2d.rotate(arc, midX, midY);
                /*****************************/
                g2d.drawString(ls.getLabel(), (int) (midX - strWidth / 2),
                        (int) midY - 5);
                g2d.setTransform(defaultTransform);
            }
        }
    }

    private class LineString {
        private Point startPoint;
        private Point endPoint;
        private String label = "";

        public double getArc() {
            return arc;
        }

        private double arc = 0.0;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Point getStartPoint() {
            return startPoint;
        }

        public void setStartPoint(Point startPoint) {
            this.startPoint = startPoint;
        }

        public Point getEndPoint() {
            return endPoint;
        }

        public void setEndPoint(Point endPoint) {
            this.endPoint = endPoint;
        }

        public LineString(Point startPoint, Point endPoint, String label) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
            this.label = label;

            this.arc = Math.atan((double) (endPoint.y - startPoint.y)
                    / (endPoint.x - startPoint.x));
        }
    }

    public static void main(String[] args) {
        new TransformTest();
    }
}