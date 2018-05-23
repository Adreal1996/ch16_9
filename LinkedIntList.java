package ch16;

import java.util.NoSuchElementException;

public class LinkedIntList
{
    // for exercise 1 in chapter 16. Added int index as parameter.
    private int counter = 0;

    public void add(int value, int index)
    {
        ListNode current = front;
        while (true)
        {
            current = current.next;
            counter++;
            if (counter == index)
                break;
        }
        //    current.next = new ListNode(value);
        current.data = value;
    }

    // Simple first version of LinkedIntList with just a constructor
// and methods for add and toString.
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntList()
    {
        front = null;
    }

    // post: returns comma-separated, bracketed version of list
    public String toString()
    {
        if (front == null)
        {
            return "[]";
        } else
        {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null)
            {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post: appends the given value to the end of the list
    public void add(int value)
    {
        if (front == null)
        {
            front = new ListNode(value);
        } else
        {
            ListNode current = front;
            while (current.next != null)
            {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    public int size()
    {
        int count = 0;
        ListNode current = front;
        while (current != null)
        {
            current = current.next;
            count++;
        }
        return count;
    }

    public int getIt(int index)
    {
        return nodeAt(index).data;
    }

    public void remove(int index)
    {
        if (index == 0)
        {
            front = front.next;
        } else
        {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    private ListNode nodeAt(int index)
    {
        ListNode current = front;
        for (int i = 0; i < index; i++)
        {
            current = current.next;
        }
        return current;
    }

    // opgave 2
    public int biggest()
    {
        if (front == null)
        {
            throw new NoSuchElementException();
        } else
        {
            ListNode current = front;
            int min = front.data;
            while (current != null)
            {
                if (current.data > min)
                {
                    min = current.data;
                }
                current = current.next;
            }
            return min;
        }
    }

    // opgave 3
    public ListNode firstToLast()
    {
        ListNode current = front;
        if (front != null)
        {

            while (current.next != null)
            {
                current = current.next;
            }
            current.next = new ListNode(front.data);

            front = front.next;
        }
        return current;
    }

    // opgave 4
    public int lastIndexOf(int value)
    {
        ListNode current = front;

        int index = -1;
        int counter = 0;

        while (current != null)
        {
            if (current.data == value)
            {
                index = counter;
            }
            counter++;
            current = current.next;
        }
        return index;
    }

    // opgave 5

    public void countDuplicates()
    {
        int sum = 0;
        ListNode current = front;
        if (front == null)
        {
            System.out.println(sum);
        }

        while (current.next != null)
        {
            if (current.data == current.next.data)
            {
                sum++;
            }
            current = current.next;
        }
        System.out.println(sum);
    }

    // opgave 7

    public int deleteBack()
    {
        ListNode current = front;
        int deletedNodeData = 0;
        int lastIndex = 0;
        if (front == null)
        {
            throw new NoSuchElementException();
        }

        while (current.next != null)
        {
            current = current.next;
            lastIndex++;
        }
        deletedNodeData = current.data;

        remove(lastIndex);
        return deletedNodeData;
    }

    // opg 8

    public void switchPairs(LinkedIntList list)
    {
        LinkedIntList tempList = new LinkedIntList();

        for (int i = 0; i < list.size() - 1; i++)
        {
            if (i % 2 == 0)
            {
                tempList.add(list.getIt(i + 1));
                tempList.add(list.getIt(i));
            }
        }
        if (list.size() % 2 != 0)
        {
            tempList.add(list.getIt(list.size() - 1));
        }
        System.out.println(tempList);
    }

    // opg 9

    public void stutter()
    {
        if (front == null)
        {
            return;
        }
        ListNode current = front;

        while (current != null)
        {
            current.next = new ListNode(current.data, current.next);
            current = current.next.next;
        }
    }

    // opg 15

    public boolean notEquals(LinkedIntList liste2)
    {
        ListNode myFirstNode = front;
        ListNode mySecondNode = liste2.front;
        while (myFirstNode != null || mySecondNode != null)
        {

            if (size() != liste2.size())
            {
                return true;
            }

            if (myFirstNode.data != mySecondNode.data)
            {
                return true;
            }

            myFirstNode = myFirstNode.next;
            mySecondNode = mySecondNode.next;
        }
        return false;
    }

    // opg 17

    public void removeRange(int startIndex, int endIndex)
    {

        if (startIndex < 0 || endIndex < 0)
        {
            throw new IllegalArgumentException("Dit index er under 0. Det må det ikke være. Prøv igen!.");
        } else
        {

            int myIndexCounter = 0;
            ListNode current = front;
            ListNode start = front;
            ListNode end = front;

            while (current != null)
            {

                if (myIndexCounter + 1 == startIndex)
                {
                    start = current;
                }

                if (myIndexCounter - 1 == endIndex)
                {
                    end = current;
                }

                current = current.next;
                myIndexCounter++;
            }

            if (startIndex == 0)
            {
                front.next = end;
            } else
            {
                start.next = end;
            }

        }
    }
}







