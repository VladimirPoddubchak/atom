package ru.atom.geometry;

public class Bar implements Collider {
    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;
    private final Point forthPoint;

    public Bar(Point firstPoint, Point secondPoint) {
        if (firstPoint.getX()==secondPoint.getX()||firstPoint.getY()==secondPoint.getY()){
            throw new IllegalArgumentException("This isn't Bar. Check coordinates!");
        }
        this.firstPoint = new Point(Integer.min(firstPoint.getX(),secondPoint.getX()),Integer.min(firstPoint.getY(),secondPoint.getY()));
        this.secondPoint = new Point(Integer.max(firstPoint.getX(),secondPoint.getX()),Integer.max(firstPoint.getY(),secondPoint.getY()));
        this.thirdPoint = new Point(firstPoint.getX(),secondPoint.getY());
        this.forthPoint = new Point(secondPoint.getX(),firstPoint.getY());
    }

    public boolean inRangeX(int x){
        return x>=firstPoint.getX()&&x<=secondPoint.getX();
    }
    public boolean inRangeY(int y){
        return y>=firstPoint.getY()&&y<=secondPoint.getY();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bar bar = (Bar) o;

        return (this.firstPoint.equals(bar.firstPoint)&&this.secondPoint.equals(bar.secondPoint));
    }

    @Override
    public boolean isColliding(Collider other) {
        if (other.getClass()==Bar.class){
            Bar bar = (Bar) other;
            return (this.firstPoint.isColliding(other)
                    ||this.secondPoint.isColliding(other)
                    ||this.thirdPoint.isColliding(other)
                    ||this.forthPoint.isColliding(other)
                    ||bar.firstPoint.isColliding(this)
                    ||bar.secondPoint.isColliding(this)
                    ||bar.thirdPoint.isColliding(this)
                    ||bar.forthPoint.isColliding(this)
                    ||(this.inRangeX(bar.firstPoint.getX())&this.inRangeX(bar.secondPoint.getX())
                        &bar.inRangeY(this.firstPoint.getY())&bar.inRangeY(this.secondPoint.getY()))
                    ||(this.inRangeY(bar.firstPoint.getY())&this.inRangeY(bar.secondPoint.getY())
                        &bar.inRangeX(this.firstPoint.getX())&bar.inRangeX(this.secondPoint.getX()))
            );

        }
        else if (other.getClass()==Point.class){
            Point point = (Point) other;
            return (this.inRangeX(point.getX())&&this.inRangeY(point.getY()));
        }
        else throw new IllegalArgumentException("Argument isn't Bar or Point class");
    }

}
