import java.util.*;
public class VotingManagement {
    private final List<Vote> votes=new ArrayList<>();
    public boolean hasVoted(String studentId,String electionId){
        for(Vote v:votes) if(v.getStudentId().equals(studentId)&&v.getElectionId().equals(electionId))return true;
        return false;
    }
    public String castVote(String studentId,String candidateId,String electionId,
            StudentManagement sm,CandidateManagement cm,ElectionManagement em,ValidationService validator){
        Student s=sm.find(studentId); Candidate c=cm.find(candidateId); Election e=em.find(electionId);
        String problem=validator.validateVote(s,c,e,hasVoted(studentId,electionId));
        if(problem!=null)return "Vote rejected: "+problem;
        votes.add(new Vote(studentId,candidateId,electionId));
        return "Vote recorded successfully.";
    }
    public List<Vote> all(){return Collections.unmodifiableList(votes);}
    public List<Vote> forElection(String electionId){
        List<Vote> out=new ArrayList<>();
        for(Vote v:votes)if(v.getElectionId().equals(electionId))out.add(v);
        return out;
    }
}