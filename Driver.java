public class Driver{
  public static void main(String[] args){
    KnightBoard k; 
    System.out.println("-------------------------------------------------");
    //for (int i = 1; i <= 10; i++){
    //  for (int c = i; c <= 10; c++){
        //System.out.println("" + i + "x" + c);
        //System.out.println();
        k = new KnightBoard(7, 7);
        //System.out.print("Number of Solutions: ");
        //System.out.println(k.countSolutions(0, 0));
        //System.out.println();
        System.out.println(k.solve(0, 0));
        System.out.println();
        System.out.println(k);
        System.out.println("-------------------------------------------------");
    //  }
    //}
  }
}
