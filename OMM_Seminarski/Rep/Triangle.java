package Rep;

import Utils.Point;

public class Triangle extends Figure
{
    double b;
    double h;
    int IxySign;

    public Triangle(double x, double y, double b, double h, int figureId, int IxySign) {
        super(x, y, "Trougao", figureId);
        this.b = b;
        this.h = h;
        this.IxySign = IxySign;

        calculateArea();
        calculateIx();
        calculateIy();
        calculateIxy();
    }

    private void calculateArea()
    {
        this.area = (b*h)/2.0;
    }

    private void calculateIx()
    {
        this.Ix = (b*Math.pow(h, 3))/36;
    }

    private void calculateIy()
    {
        this.Iy = (h*Math.pow(b, 3))/36;
    }

    private void calculateIxy()
    {
        this.Ixy = IxySign*(Math.pow(b, 2)*Math.pow(h, 2)/72);
    }

    double getDiffx()
    {
        if(C.getX() < 0) return this.C.getX() - (b/3);
        return this.C.getX() - (b/3);
    }

    double getDiffy()
    {
        if(C.getY() < 0) return this.C.getY() - (h/3);
        return this.C.getY() - (h/3);
    }
}
