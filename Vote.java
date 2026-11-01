import java.time.LocalDateTime;
public class Vote {
    private final String studentId, candidateId, electionId;
    private final LocalDateTime timestamp;
    public Vote(String studentId,String candidateId,String electionId){
        this.studentId=studentId; this.candidateId=candidateId; this.electionId=electionId;
        this.timestamp=LocalDateTime.now();
    }
    public String getStudentId(){return studentId;}
    public String getCandidateId(){return candidateId;}
    public String getElectionId(){return electionId;}
    public LocalDateTime getTimestamp(){return timestamp;}
    @Override public String toString(){return "Election: "+electionId+" | Student: "+studentId+
        " | Candidate: "+candidateId+" | Time: "+timestamp;}
}