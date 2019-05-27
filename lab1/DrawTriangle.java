public class DrawTriangle{
   public static void DrawTriangle(int N){
      int i = 0;
      while(i < N){
          int j = 0;
          while(j <= i) {
             System.out.print("*");
             j++;  
          }
          System.out.print("\n");
          i++;
      }
   
   }
   
   public static void main(String[] arg){
      DrawTriangle(7);
   } 
   
}
