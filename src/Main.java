import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Util util = new Util();
        String leftTablePath= args[0];
        String rightTablePath= args[1];
        BufferedReader br1 = new BufferedReader(new FileReader(leftTablePath));
        BufferedReader br2 = new BufferedReader(new FileReader(rightTablePath));
        String lineFile1 = br1.readLine();
        String lineFile2 = br2.readLine();
        String inputAttributeStr = args[2];
        String outputPath ="/Users/dipeshasd/Desktop/Database_Join/src/Output.txt";

        int numberOfAttributes = inputAttributeStr.split(",").length;

        if (!util.valid(lineFile1, lineFile2, inputAttributeStr)) {
            System.out.println("The attributes are not present in  the file");
        } else {
            System.out.println("The attributes are present in the file");
            ArrayList<Integer> indexes = util.getIndexes(lineFile1, lineFile2, inputAttributeStr);
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));
            bw.write(util.generateRow(lineFile1,lineFile2,indexes)+"\n");


            while ((lineFile1 = br1.readLine()) != null) {
                br2 = new BufferedReader(new FileReader(rightTablePath));
                br2.readLine();
                while ((lineFile2 = br2.readLine()) != null) {
                    boolean shouldWrite = true;

                    for(int i=0;i<=numberOfAttributes/2;i++){
                        if(!lineFile1.split(",")[indexes.get(i)].equals(lineFile2.split(",")[indexes.get(numberOfAttributes+i)])){
                            shouldWrite = false;
                        }
                    }
                    if(shouldWrite){
                        bw.write(util.generateRow(lineFile1,lineFile2,indexes)+"\n");

                    }


                }

            }
            bw.close();

            //print the contents of the output file
            BufferedReader br = new BufferedReader(new FileReader(outputPath));
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }



        }


    }
}
