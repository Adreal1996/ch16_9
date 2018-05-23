package ch16;

/*
Write a method called stutter that doubles the size of a list by replacing every integer in the
list with two of that integer. For example, suppose a variable list stores the values
[1, 8, 19, 4, 17], after a call of list.stutter(), it should store [1, 1, 8, 8, 19, 19, 4, 4, 17, 17].
 */

public class opg9
{
    public static void main(String[] args)
    {
        LinkedIntList minListe = new LinkedIntList();
        minListe.add(69);
        minListe.add(96);
        minListe.add(69);

        minListe.stutter();
        System.out.println(minListe);
    }
}
