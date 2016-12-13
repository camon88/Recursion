
public class CSHW
{
public int gretel (int num)
{
    int x;
    if (num < 12)
        x = 12;
    else
        x = num * gretel(num -5);
    return x;
}

public static void main(String args[])
{
    CSHW test = new CSHW();
    test.hansel(4);
    System.out.print(test.gretel(20));
    test.mouse(3);
    System.out.print(test.woods(3));
    
}


public void hansel (int num) {
    if (num > 0) {
        System.out.println("Line 5: " + num);
        hansel(num-1);
        System.out.println("Line 7: " + num);
    }
}

public void mouse(int num)
{
    if (num > 0) {
        System.out.println( "It is April.");
        mouse(num-1);
    }
    System.out.println("Almost over " + num + "!");

}


public int woods(int num) {
    int x;
    if (num <= 0)
       x = num; 
    else if (num % 2 == 0)
       x = woods(num-1) + 4;
    else
       x = woods(num-1) + woods(num-2);
    return x;
}



}

