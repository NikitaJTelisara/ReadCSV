import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        // -define .csv file in app
        Scanner scanner = new Scanner(new File("C:/ReadCSV/src/Test.csv"));
        ArrayList<String> docType = new ArrayList<String>();
        ArrayList<String> ids = new ArrayList<String>();
        ArrayList<String[]> rows = new ArrayList<String[]>();
        scanner.nextLine();
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            String l = scanner.nextLine();
            String[] values = l.trim().split(",");
            String docName = values[0];
            if (!docType.contains(docName)) {
                docType.add(docName);
            }
            String id = values[2];
            if (!ids.contains(id)) {
                ids.add(id);
            }
            rows.add(values);
        }

        for (int j = 0; j < docType.size(); j++) {
            String doc = docType.get(j);
            System.out.println("Ids who have a " + doc);
            ArrayList<String> idList = new ArrayList<String>();
            for (int i = 0; i < rows.size(); i++) {
                String[] values = rows.get(i);
                if (values[0].equals(docType.get(j))) {
                    System.out.println(values[2]);
                }
            }
            System.out.println("\n");
        }

        for (int j = 0; j < docType.size(); j++) {
            String doc = docType.get(j);
            System.out.println("Ids who do not have a " + doc);
            ArrayList<String> idList = new ArrayList<String>();
            for (int i = 0; i < rows.size(); i++) {
                String[] values = rows.get(i);
                if (values[0].equals(docType.get(j))) {
                    idList.add(values[2]);
                }
            }
            for (int k = 0; k < ids.size(); k++) {
                if (!idList.contains(ids.get(k))) {
                    System.out.println(ids.get(k));
                }
            }
            System.out.println("\n");
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
Ids who have a Bank Statement
1
2


Ids who have a Medical Report
1
3
4


Ids who have a Tax Return
2
3
4


Ids who do not have a Bank Statement
3
4


Ids who do not have a Medical Report
2


Ids who do not have a Tax Return
1

*/