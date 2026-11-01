import java.io.*;
public class ReportGenerationService {
    public void generate(String fileName,Iterable<?> records){
        try(PrintWriter out=new PrintWriter(new FileWriter(fileName))){
            for(Object record:records)out.println(record);
            System.out.println("Report saved to "+fileName);
        }catch(IOException e){System.out.println("Could not write report: "+e.getMessage());}
    }
}