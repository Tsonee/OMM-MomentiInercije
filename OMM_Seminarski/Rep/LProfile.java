package Rep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LProfile extends Figure
{
    int position;
    int sign;


    public LProfile(double x, double y, String name, int figureId, int pos,int sign) throws FileNotFoundException {
        super(x, y, name, figureId);
        this.position = pos;
        this.sign = sign;
        load();
        this.Ixy *= sign;
    }

    public void load() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("Files/L.txt"));
        String profName;
    

        while(sc.hasNextLine())
        {
            profName = sc.next();
            double tempA = sc.nextDouble();
            double tempIx = sc.nextDouble();
            double tempIy = sc.nextDouble();
            double tempIu = sc.nextDouble();
            double tempIv = sc.nextDouble();

            if(profName.equals(name))
            {
                this.area = tempA;
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

                this.Ixy = Math.sqrt(this.Ix*this.Iy - tempIu*tempIv);

            }
        }
        
        sc.close();
    }
    



}
