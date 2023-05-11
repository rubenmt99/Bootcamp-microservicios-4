import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
    	
    	List<Integer> numbersIntegers = List.of(18,6,4,15,55,78,12,9,8);
    	
         
         long count = numbersIntegers.stream()
                 .filter(number -> number >10)
                 .count();
         
         
         int count2 = 0;
         for (int number : numbersIntegers) {
             if (number > 10) {
                 count2++;
             }
         }
    	
       
        System.out.println(count);
        System.out.println(count2);
    }
    
    
}