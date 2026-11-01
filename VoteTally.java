import java.util.*;
public class VoteTally {
    public Map<String,Integer> count(String electionId,List<Vote> votes){
        Map<String,Integer> counts=new LinkedHashMap<>();
        for(Vote v:votes)if(v.getElectionId().equals(electionId))
            counts.put(v.getCandidateId(),counts.getOrDefault(v.getCandidateId(),0)+1);
        return counts;
    }
}