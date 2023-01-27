package Rep;

import Utils.Point;

public class Rectangle extends Figure
{
    double b;
    double h;

    public Rectangle(double x, double y, double b, double h, int figureId) 
    {
        super(x, y, "Kvadrat",figureId);
        this.b = b;
        this.h = h;

        calculateArea();
        calculateIx();
        calculateIy();
        calculateIxy();
    }

    private void calculateArea()
    {
        this.area = (b*h);
    }

    private void calculateIx()
    {
        this.Ix = (b*Math.pow(h, 3))/12;
    }

    private void calculateIy()
    {
        this.Iy = (h*Math.pow(b, 3))/12;
    }

    private void calculateIxy()
    {
        this.Ixy = 0;
    }




}
