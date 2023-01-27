package Rep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Utils.Point;

public class CrossSection
{
    List<Figure> figures;
    public List<Figure> getFigures() {
        return figures;
    }

    double area;
    Point  C;
    double Iksi;
    double Ieta;
    double IksiEta;
    double Ix;
    double Iy;
    double Ixy;
    double alpha;
    double I1,I2;
    double i1,i2;

    public CrossSection()
    {
        figures = new ArrayList<Figure>();
        this.C = new Point(0, 0);
    }

    public void solve()
    {
        if(this.figures.isEmpty())
        {
            System.out.println("Poprecni presek je prazan!");
            System.exit(1);
        }
        this.calculateArea();
        this.calculateCentre();
        this.caluclateIksi();
        this.calculateIeta();
        this.calculateIksiEta();
        this.calculateIx();
        this.calculateIy();
        this.calculateIxy();
        this.calculateAlpha();
        this.calculateI1I2();
        this.calculaeti1();
        this.calculatei2();
    }

    public void clear()
    {
        this.figures.clear();
    }

    public void addFigure(Figure figure)
    {
        this.figures.add(figure);
    }

    private void calculateArea()
    {
        double sum = 0;

        for (Figure figure : figures) {
            sum+=figure.getArea();
        }

        this.area = sum;
    }

    private void calculateCentre()
    {
        double sumPsi = 0;
        
        for (Figure figure : figures) 
        {
            sumPsi += figure.getArea()*figure.getC().getX();    
        }

        this.C.setX(sumPsi/this.area);

        double sumEta = 0;

        for (Figure figure : figures) {
            sumEta += figure.getArea()*figure.getC().getY();
        }

        this.C.setY(sumEta/this.area);
    }

    private void caluclateIksi()
    {
        double sum = 0;

        for (Figure figure : figures) {
            sum+=figure.getIx() + Math.pow(figure.getC().getY(), 2)*figure.getArea();; 
        }

        this.Iksi = sum;
    }

    private void calculateIeta()
    {
        double sum = 0;

        for (Figure figure : figures)
        {
            sum+=figure.getIy() + Math.pow(figure.getC().getX(), 2)*figure.getArea();    
        }

        this.Ieta = sum;
    }

    private void calculateIksiEta()
    {
        double sum = 0;

        for ( Figure figure : figures) {
            sum+= figure.getIxy() + figure.getArea()*figure.getC().getX()*figure.getC().getY();
        }

        this.IksiEta = sum;
    }

    private void calculateIx()
    {
        this.Ix = this.Iksi - this.area*Math.pow(this.C.getY(),2);
    }

    private void calculateIy()
    {
        this.Iy = this.Ieta - this.area*Math.pow(this.C.getX(), 2);
    }

    private void calculateIxy()
    {
        this.Ixy = this.IksiEta - this.area*this.C.getX()*this.C.getY();
    }

    private void calculateAlpha()
    {
        double alpha_2 = (-2 * this.Ixy)/(this.Ix - this.Iy);
        alpha_2 = Math.toDegrees(Math.atan(alpha_2));
        this.alpha = alpha_2/2;
    }

    private void calculateI1I2()
    {
        this.I1 = (this.Ix + this.Iy)/2 + 0.5f*Math.sqrt(Math.pow(this.Ix - this.Iy, 2) + 4*Math.pow(this.Ixy, 2));
        this.I2 = (this.Ix + this.Iy)/2 - 0.5f*Math.sqrt(Math.pow(this.Ix - this.Iy, 2) + 4*Math.pow(this.Ixy, 2));
    }

    private void calculaeti1()
    {
        this.i1 = Math.sqrt(this.I1/this.area);
    }

    private void calculatei2()
    {
        this.i2 = Math.sqrt(this.I2/this.area);
    }

    public void displayResults()
    {
        System.out.printf("A = %.3f\n" , this.area);
        System.out.printf("C(%.3f,%.3f)\n",this.C.getX(),this.C.getY());
        System.out.printf("Iksi = %.3f\n" , this.Iksi );
        System.out.printf("Ieta = %.3f\n", this.Ieta);
        System.out.printf("IksiEta = %.3f\n", this.IksiEta);
        System.out.printf("Ix = %.3f\n", this.Ix);
        System.out.printf("Iy =  %.3f\n", this.Iy);
        System.out.printf("Ixy = %.3f\n", this.Ixy);
        System.out.printf("alfa = %.3f°\n", this.alpha);
        System.out.printf("I1 = %.3f I2 = %.3f\n",this.I1,this.I2);
        System.out.printf("i1 = %.3f i2 = %.3f\n",this.i1,this.i2);
        System.out.printf("Tezisne ose poprecnog preseka treba zarotirati za  %.3f° i ", this.alpha);
        if(this.Ix > this.Iy)
        {
            System.out.println("x osa postaje osa 1, a y osa 2");
        }
        else System.out.println("y osa postaje osa 1, a x osa 2");
    }
}   