package test;

import data.LinkedNode;
import data.MyLinkedList;
import exception.LinkedListException;
import fileManager.DataLoader;
import fileManager.FileStrings;
import org.junit.Before;
import org.junit.Test;
import stadisticsManager.StatsCalculator;


import java.util.LinkedList;

import static org.junit.Assert.*;

public class MyLinkedListAndStatsCalculatorAndDataLoaderTest
{

    private static MyLinkedList<Double> myLinkedList;
    private static double item1Data = 1.0, item2Data = 2.0;

    @Before
    public void init ()
    {
        myLinkedList = new MyLinkedList<>();
    }

    @Test(expected = LinkedListException.class)
    public void nextExceptionTest () throws LinkedListException {
        myLinkedList.next();
    }

    @Test
    public void newInstanceHasZeroItems ()
    {
        assertTrue(myLinkedList.getSize() == 0);
    }

    @Test
    public void addTwoItemsHasTwoItems () throws LinkedListException {
        addTwoItems();
        assertTrue(myLinkedList.getSize() == 2);
    }

    @Test
    public void iterateWithTwoItemsWorks () throws LinkedListException
    {
        addTwoItems();
        myLinkedList.initIterator();
        assertTrue(myLinkedList.hasNext());
        assertTrue(myLinkedList.next().getData() == item1Data);
        assertTrue(myLinkedList.next().getData() == item2Data);
        assertFalse(myLinkedList.hasNext());

    }

    @Test
    public void assertMeanWithTwoWorks () throws LinkedListException
    {
        addTwoItems();
        double expected = (item1Data + item2Data) / 2;
        assertTrue(expected == StatsCalculator.getMean(myLinkedList));
    }

    @Test
    public void assertStrDevWithTwoWorks () throws  LinkedListException
    {
        addTwoItems();
        double mean = (item1Data + item2Data) / 2;;
        double item, sum = 0, expected;
        item = (item1Data - mean);
        item = item * item;
        sum += item;
        item = (item2Data - mean);
        item = item * item;
        sum += item;
        expected = Math.sqrt(sum/mean);
        assertTrue(expected == StatsCalculator.getStrDev(myLinkedList));
    }



    private static void addTwoItems () throws LinkedListException {
        LinkedNode<Double> item1 = new LinkedNode<>(item1Data);
        LinkedNode<Double> item2 = new LinkedNode<>(item2Data);
        myLinkedList.add(item1);
        myLinkedList.add(item2);
    }

}