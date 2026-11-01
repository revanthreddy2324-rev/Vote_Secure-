import java.util.*;
public class ResultManagement {
    public List<Result> createResults(String electionId,Map<String,Integer> tally,CandidateManagement cm){
        List<Result> results=new ArrayList<>();
        for(Map.Entry<String,Integer> entry:tally.entrySet()){
            Candidate c=cm.find(entry.getKey());
            if(c!=null)results.add(new Result(electionId,c.getCandidateId(),c.getName(),entry.getValue()));
        }
        results.sort((a,b)->Integer.compare(b.getVoteCount(),a.getVoteCount()));
        return results;
    }
    public void display(List<Result> results){
        if(results.isEmpty()){System.out.println("No votes recorded for this election.");return;}
        for(Result r:results)System.out.println(r);
        int highest=results.get(0).getVoteCount();
        List<String> winners=new ArrayList<>();
        for(Result r:results)if(r.getVoteCount()==highest)winners.add(r.getCandidateName());
        if(winners.size()>1)System.out.println("Result: Tie between "+String.join(", ",winners));
        else System.out.println("Winner: "+winners.get(0));
    }
}