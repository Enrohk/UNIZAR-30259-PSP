package stadisticsManager;

import data.MyLinkedList;
import exception.LinkedListException;

public class StatsCalculator<Doubles> {

    public static double getMean (MyLinkedList<Double> myLinkedList) throws LinkedListException {
        double currentSum = 0;
        myLinkedList.initIterator();
        while (myLinkedList.hasNext())
        {
            currentSum += myLinkedList.next().getData();
        }
        return currentSum/myLinkedList.getSize();

    }

    public static double getStrDev (MyLinkedList<Double> myLinkedList) throws LinkedListException
    {
        double currentSum = 0, count;
        double mean = getMean(myLinkedList);
        myLinkedList.initIterator();
        while (myLinkedList.hasNext())
        {

            count = myLinkedList.next().getData() - mean;
            count = count * count;
            currentSum += count;
        }

        return Math.sqrt(currentSum/mean);
    }



}
