package Rep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UProfile extends Figure
{
    int position;


    public UProfile(double x, double y, String name, int figureId, int pos) throws FileNotFoundException {
        super(x, y, name, figureId);
        this.position = pos;
        initIxy();
        load();
    }

    void initIxy()
    {
        this.Ixy = 0;
    }

    public void load() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("Files/U.txt"));
        String profName;
    

        while(sc.hasNextLine())
        {
            profName = sc.next();
            double tempA = sc.nextDouble();
            double tempIx = sc.nextDouble();
            double tempIy = sc.nextDouble();

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
            }
        }
        
        sc.close();
    }
    



}
