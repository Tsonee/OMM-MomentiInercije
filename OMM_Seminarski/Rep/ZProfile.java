package Rep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ZProfile extends Figure
{
    int position;
    int sign;


    public ZProfile(double x, double y, String name, int figureId, int pos, int sign) throws FileNotFoundException {
        super(x, y, name, figureId);
        this.position = pos;
        this.sign = sign;
        load();
        this.Ixy*=sign;
        System.out.println("Ixy:" + this.Ixy);
    }

    public void load() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("Files/Z.txt"));
        String profName;
    

        while(sc.hasNextLine())
        {
            profName = sc.next();
            double tempA = sc.nextDouble();
            double tempIx = sc.nextDouble();
            double tempIy = sc.nextDouble();
            double tempIxy = sc.nextDouble();

            if(profName.equals(name))
            {
                this.area = tempA;
                this.Ixy = tempIxy;
                if(position == 0) //0 - horizontalno 1 - vertikalno
                {
                    this.Iy = tempIx;
                    this.Ix = tempIy;
                }
                else
                {
                    this.Ix = tempIx;
                    this.Iy = tempIy;
                }
                System.out.println("Ix:" + this.Ix);
                System.out.println("Iy:" + this.Iy);

                return;
            }
        }

        System.out.println("Nema takvog profila!");
        System.exit(1);
        
        sc.close();
    }
    


}
