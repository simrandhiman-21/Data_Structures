import com.opencsv.CSVWriter;

import java.io.*;
import java.io.FileWriter;
import java.security.spec.ECField;
import java.util.List;
import java.util.concurrent.ExecutionException;

//public class WriteFile {
//    public static void main(String[] args) throws Exception {
//        String path="C:\\bridgelabz-workspace\\IOProgramming\\CVShandling\\problems\\employe.csv";
//        try{
//            CSVWriter cw=new CSVWriter(new FileWriter(path));
//            cw.writeNext(new String[]{"1","java","IT","20000"});
//            cw.writeNext(new String[]{"1","java","IT","20000"});
//            cw.writeNext(new String[]{"1","java","IT","20000"});
//            cw.writeNext(new String[]{"1","java","IT","20000"});
//            System.out.println("CSV file written successfully.");
//
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//
//    }
//}
public class WriteFile {
    public static void main(String[] args) {
        String filePath = "employe.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("104,Alice Williams,Finance,62000\n");
            writer.write("105,Bob Johnson,Sales,58000\n");
            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

