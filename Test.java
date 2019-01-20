import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
      Scanner s = new Scanner(new File("C:/New folder/Test.csv"));
        s.nextLine();
        Hashtable<String, HashSet<Integer>> hasdocs = new Hashtable<String, HashSet<Integer>>();
        HashSet<Integer> Ids = new HashSet<Integer>();
        while (s.hasNext()) {
            HashSet<Integer> arr = new HashSet<Integer>();
            String newString = s.nextLine();
            String[] result = newString.split(",");
            Ids.add(Integer.parseInt(result[2]));
            if (hasdocs.containsKey(result[0])) {
                arr = hasdocs.get(result[0]);
                arr.add(Integer.parseInt(result[2]));
            } else {
                arr.add(Integer.parseInt(result[2]));
                hasdocs.put(result[0],arr);
            }
        }
        Set<String> docTypes = hasdocs.keySet();
        for (String s1 : docTypes) {
            Set<Integer> IdsWithDoc = hasdocs.get(s1);
            System.out.println("people who have " + s1);
            System.out.println(IdsWithDoc);
            System.out.println("people who  do not have " + s1);
            for(Integer i: Ids){
                if(!IdsWithDoc.contains(i)){
                    System.out.print(" "+i+",");
                }
            }
            System.out.print("\n");
        }
    }
}

/* Input

docType,owner,id
Bank Statement,John,1
Medical Report,John,1
Tax Return,Jack,2
Bank Statement,Jack,2
Medical Report,Mike,3
Tax Return,Mike,3
Medical Report,Tim,4
Tax Return,Tim,4

 */

/* Expected Output  Ids who dont have these documents
people who have Medical Report
[1, 3, 4]
people who  do not have Medical Report
 2,
people who have Tax Return
[2, 3, 4]
people who  do not have Tax Return
 1,
people who have Bank Statement
[1, 2]
people who  do not have Bank Statement
 3, 4,


*/
