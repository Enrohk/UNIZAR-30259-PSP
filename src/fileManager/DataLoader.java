package fileManager;

import data.LinkedNode;
import data.MyLinkedList;
import exception.LinkedListException;
import stadisticsManager.StatsCalculator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class DataLoader {

    public static MyLinkedList<Double> getMyLinkedListFromData (String path)
    {
        MyLinkedList<Double> myLinkedList = new MyLinkedList<>();
        Scanner sc = null;
        try
        {
           sc = new Scanner(new File(path));
           LinkedNode<Double> next;
           while (sc.hasNextLine())
           {
               next = new LinkedNode<>(sc.nextDouble());
               myLinkedList.add(next);
               sc.nextLine();
           }
        }
        catch (Exception e)
        {

        }
        finally {
            if (sc!=null)
                sc.close();
            return myLinkedList;
        }
    }

    public static void writeData (MyLinkedList<Double> myLinkedList, String path) throws LinkedListException {
        double mean = StatsCalculator.getMean(myLinkedList),
                strDev = StatsCalculator.getStrDev(myLinkedList);

        try {
            FileWriter fw = new FileWriter(new File(path));
            fw.append(FileStrings.WRITE_MEAN + mean);
            fw.append("\n");
            fw.append(FileStrings.WRITE_STRDEV + strDev);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
