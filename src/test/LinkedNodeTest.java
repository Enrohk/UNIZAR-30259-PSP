package test;

import data.LinkedNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedNodeTest {

    @Test
    public void testNodeLinkWorks ()
    {
        double node1Data = 1.0, nextNodeData = 2.0;

        LinkedNode<Double> node1 = new LinkedNode<>(node1Data);

        LinkedNode<Double> nextNode = new LinkedNode<>(nextNodeData);

        node1.setNextNode(nextNode);
        assertTrue(node1.getData() == node1Data);
        assertTrue(nextNode.getData() == nextNodeData);
        assertTrue(nextNode.equals(node1.getNextNode()));


    }


}