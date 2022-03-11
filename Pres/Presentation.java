package Pres;
import Dao.IDao;
import Metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation {
public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException,
        IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    /*
    * on va instancier une class avec une instanciation dynamique
    *on va lire à partir d'un fichier les class qu'on créer
    * */
    Scanner s = new Scanner(new File("C:\\Users\\DELL\\IdeaProjects\\Couplage\\src\\config.txt"));
    /*
    * l'instanciation dynamique:
    * on va utiliser forName pour récuperer la classe et les charger dans la mémoire
    * puis on va instancier la classe sans utiliser "new" donc on va utiliser "newInstance" pour
    * l'instanciation dynamique
    * */
    String DaoClass = s.nextLine();
    Class cdao = Class.forName(DaoClass);
    IDao dao =(IDao) cdao.newInstance();

    /*
    on va utiliser le même traitement de Dao
    * */
    String metierClass =s.next();
    Class Cmetier = Class.forName(metierClass);
    IMetier metier = (IMetier) Cmetier.newInstance();
    /*
    * Si On veut utiliser la classe DaoImpl2 on va changer le fichier config.txt
    * */
    Method m = Cmetier.getMethod("setDao",IDao.class);
    m.invoke(metier,dao);//invoke pour executer la methode
    System.out.println(metier.calcul());





}

}
