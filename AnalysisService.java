import java.util.*;
public class AnalysisService {
    public void display(String electionId,int registeredStudents,List<Vote> votes,Map<String,Integer> tally){
        int total=0;for(int count:tally.values())total+=count;
        System.out.println("Election ID: "+electionId);
        System.out.println("Registered students: "+registeredStudents);
        System.out.println("Votes cast: "+total);
        double pct=registeredStudents==0?0.0:(total*100.0/registeredStudents);
        System.out.printf("Participation (against all registered students): %.2f%%%n",pct);
        for(Map.Entry<String,Integer> e:tally.entrySet())
            System.out.println("Candidate "+e.getKey()+": "+e.getValue()+" vote(s)");
    }
}