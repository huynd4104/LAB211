

public class WrapperClasses {

    public static void main(String[] args) {
        int n = 7;
        Integer intObj = new Integer(5);
        System.out.println(intObj);
        System.out.println(intObj.toString());
        intObj = n;
        System.out.println(intObj);
        int y = intObj * 2;
        int z = intObj.intValue();
        System.out.println("y= " + y + ", z= " + z);
        n = Integer.parseInt("1234");
        System.out.println("n= " + n);
        n = Integer.parseInt("1A", 16);
        System.out.println("n= " + n);
    }
}
