import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.cert.CRLReason;
import java.util.Scanner;

import Rep.CrossSection;
import Rep.Figure;
import Rep.IProfile;
import Rep.LProfile;
import Rep.Rectangle;
import Rep.Triangle;
import Rep.UProfile;
import Rep.ZProfile;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Prvim ulaskom u program novi poprecni presek je automatski napravljen");
        CrossSection cs = new CrossSection();
        while(isRunning)
        {
            int choice1;
            System.out.println("Izabrite opciju:");
            System.out.println("1 - Dodajte Figuru");
            System.out.println("2 - Resi zadatak");
            System.out.println("3 - Napravi novi poprecni presek");
            System.out.println("4 - Lista figura u poprecno preseku");
            System.out.println("0 - Izadji iz programa");
            choice1 = sc.nextInt();
        
            switch(choice1)
            {
                case 1 :
                    int choice2 = 0;
                    System.out.println("Izabreite opciju: ");
                    System.out.println("1 - Oblik");
                    System.out.println("2 - Profil");
                    System.out.println("0 - nazad");
                    choice2 = sc.nextInt();
                    switch(choice2)
                    {
                        case 1:
                            int choice3 = 0;
                            System.out.println("1 - Trougao");
                            System.out.println("2 - Kvadrat");
                            System.out.println("0 - nazad");
                            choice3 = sc.nextInt();
                            
                            switch(choice3)
                            {
                                case 1:
                                {    double b = 0;
                                    double h = 0;
                                    double x = 0;
                                    double y = 0;
                                    int sign = 0;

                                    System.out.print("Unesite duzinu baze: ");
                                    b = sc.nextDouble();
                                    System.out.print("Unesite duzinu visine: ");
                                    h = sc.nextDouble();
                                    System.out.print("Unesite ksi koordinatu tezista trougla: ");
                                    x = sc.nextDouble();
                                    System.out.print("Unesite eta koordinatu tezista trougla: ");
                                    y = sc.nextDouble();
                                    System.out.print("Unesite znak sopstvenog centrifugalnog momenta trougla(-1 ako je negativan 1 ako je pozitivan):");
                                    sign = sc.nextInt();

                                    if(sign != -1 && sign != 1)
                                    {
                                        System.out.println("Greska!");
                                        System.exit(1);
                                    }

                                    cs.addFigure(new Triangle(x, y, b, h, 0, sign));
                                }
                                break;
                                case 2:
                                {
                                    double b1 = 0;
                                    double h1 = 0;
                                    double x1 = 0;
                                    double y1 = 0;

                                    System.out.print("Unesite duzinu baze: ");
                                    b1 = sc.nextDouble();
                                    System.out.print("Unesite duzinu visine: ");
                                    h1 = sc.nextDouble();
                                    System.out.print("Unesite ksi koordinatu tezista kvadrata: ");
                                    x1 = sc.nextDouble();
                                    System.out.print("Unesite eta koordinatu tezista kvadrata: ");
                                    y1 = sc.nextDouble();

                                    cs.addFigure(new Rectangle(x1, y1, b1, h1, 0));
                                }
                                break;
                                case 0:
                                break;
                                default: System.out.println("Pogresna komanda!");
                                break;
                            }
                            break;
                        case 2:
                            int choice4 = 0;
                            System.out.println("Izaberite opciju: ");
                            System.out.println("1 - U profil");
                            System.out.println("2 - Z profil");
                            System.out.println("3 - I profil");
                            System.out.println("4 - L profil");
                            System.out.println("0 - nazad");
                            choice4 = sc.nextInt();

                            switch(choice4)
                            {
                                case 1:
                                {
                                    String name = null;
                                    double x = 0;
                                    double y = 0;
                                    int pos;
                                    
                                    System.out.print("Unesite ime U profila(primer: U12): ");
                                    name = sc.next();
                                    System.out.print("Unesite ksi koordinau tezista U profila: ");
                                    x = sc.nextDouble();
                                    System.out.print("Unesite eta koordinau tezista U profila: ");
                                    y = sc.nextDouble();
                                    System.out.println("Unesite 0 ako je U profil horizontalno postavljen, a 1 ako je vertikalno postavljen: ");
                                    pos = sc.nextInt();

                                    cs.addFigure(new UProfile(x, y, name, 0, pos));
                                    break;
                                }
                                case 2:
                                {
                                    String name = null;
                                    double x = 0;
                                    double y = 0;
                                    int pos;
                                    int sign;
                                    
                                    System.out.print("Unesite ime Z profila(primer: Z120): ");
                                    name = sc.next();
                                    System.out.print("Unesite ksi koordinau tezista Z profila: ");
                                    x = sc.nextDouble();
                                    System.out.print("Unesite eta koordinau tezista Z profila: ");
                                    y = sc.nextDouble();
                                    System.out.println("Unesite 0 ako je Z profil horizontalno postavljen, a 1 ako je vertikalno postavljen: ");
                                    pos = sc.nextInt();
                                    System.out.println("Unesite -1 ako je znak sopstvenog centrifugalnog momenta negativan, 1 ako je pozitivan: ");
                                    sign = sc.nextInt();

                                    cs.addFigure(new ZProfile(x, y, name, 0, pos, sign));
                                    break;
                                }
                                case 3:
                                {
                                    String name = null;
                                    double x = 0;
                                    double y = 0;
                                    int pos;
                                    
                                    System.out.print("Unesite ime I profila(primer: I20): ");
                                    name = sc.next();
                                    System.out.print("Unesite ksi koordinau tezista I profila: ");
                                    x = sc.nextDouble();
                                    System.out.print("Unesite eta koordinau tezista I profila: ");
                                    y = sc.nextDouble();
                                    System.out.println("Unesite 0 ako je I profil horizontalno postavljen, a 1 ako je vertikalno postavljen: ");
                                    pos = sc.nextInt();

                                    cs.addFigure(new IProfile(x, y, name, 0, pos));
                                    break;
                                }
                                case 4:
                                {
                                    String name = null;
                                    double x = 0;
                                    double y = 0;
                                    int pos;
                                    int sign;
                                    
                                    System.out.print("Unesite ime L profila(primer: Lx100x50x10): ");
                                    name = sc.next();
                                    System.out.print("Unesite ksi koordinau tezista L profila: ");
                                    x = sc.nextDouble();
                                    System.out.print("Unesite eta koordinau tezista L profila: ");
                                    y = sc.nextDouble();
                                    System.out.println("Unesite 0 ako je L profil horizontalno postavljen, a 1 ako je vertikalno postavljen: ");
                                    pos = sc.nextInt();
                                    System.out.println("Unesite -1 ako je znak sopstvenog centrifugalnog momenta negativan, 1 ako je pozitivan: ");
                                    sign = sc.nextInt();

                                    cs.addFigure(new LProfile(x, y, name, 0, pos, sign));
                                }
                                case 0: break;
                                default: System.out.println("Pogresna komanda!");
                            }

                        break;
                        case 0:
                        break;
                        default : System.out.println("Pogresna komanda!");
                    }

                break;
                case 2:
                    cs.solve();
                    cs.displayResults();
                    break;
                case 3: cs.clear();
                break;
                case 4:
                    if(cs.getFigures().isEmpty()) System.out.println("Lista je prazna!");
            
                    int i = 0;
                    for(Figure f : cs.getFigures())
                    {
                        System.out.println((i+1) + ". " + f.getName());
                        i++;
                    }
                break;
                case 0: System.exit(0);
                break;
                default : System.out.println("Pogresna komanda!");
            }


        }
    }


}