public class Daochuoi{
   public static void main(String[] args){
      String string="abcdef";
      String reverse = new StringBuffer(string).
      reverse().toString();
      System.out.println("\nString before reverse: "+ string );
      System.out.println("String after reverse: "+ reverse);
      
      String st = "Nguyen Danh Huy";
      String [] a = st.split("[ ]+");
      int n= a.length;
      String s="";
      for(int i=n-1;i>=0;i--) {
        s += " " + a[i]; 
      }
      s = s.trim();
      System.out.println(s); 
   }
}

