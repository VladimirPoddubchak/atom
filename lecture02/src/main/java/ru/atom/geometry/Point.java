package ru.atom.geometry;

/**
 * Template class for
 */
public class Point implements Collider {
    private final int X;
    private final int Y;

    public Point(int x, int y){
        this.X =x;
        this.Y =y;
    }


    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        return (this.X==point.X&&this.Y==point.Y);
    }

    @Override
    public boolean isColliding(Collider other) {
        if (other.getClass()==Point.class){
            return (this.equals(other));
        }
        else if (other.getClass()==Bar.class){
            Bar bar = (Bar) other;
            return (bar.inRangeX(this.X)&&bar.inRangeY(this.Y));
        }
        else throw new IllegalArgumentException("Argument isn't Bar or Point class");
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
