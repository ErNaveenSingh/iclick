package naveen.imageclickapp;

import android.graphics.Point;

/**
 * Created by naveen on 06/07/16.
 */
public class Polygon {

    int id;

    Point[] points;

    public Polygon(int id, Point[] points) {
        this.id = id;
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public int getId() {
        return id;
    }
}
