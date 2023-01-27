package Rep;

import Utils.Point;

public abstract class Figure 
{
    String name;
    public String getName() {
        return name;
    }

    int figureId;

    protected Point C;
    protected double area;
    protected double Ix;
    protected double Iy;
    protected double Ixy;

    public Figure(double x, double y, String name, int figureId)
    {
        C = new Point(x, y);
        this.name = name;
        this.figureId = figureId;
    }

    public void printName()
    {
        System.out.println("Name: " + this.name);
    }

    public void printArea()
    {
        System.out.println("Area: " + this.area);
    }

    public void printIx()
    {
        System.out.println("Ix: " + this.Ix);
    }

    
    public void printIy()
    {
        System.out.println("Iy: " + this.Iy);
    }

    public void printIxy()
    {
        System.out.println("Ixy: " + this.Ixy);
    }

    public Point getC() {
        return C;
    }

    public void setC(Point c) {
        C = c;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getIx() {
        return Ix;
    }

    public void setIx(double ix) {
        Ix = ix;
    }

    public double getIy() {
        return Iy;
    }

    public void setIy(double iy) {
        Iy = iy;
    }

    public double getIxy() {
        return Ixy;
    }

    public void setIxy(double ixy) {
        Ixy = ixy;
    }
}
