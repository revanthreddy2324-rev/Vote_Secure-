public class Result {
    private final String electionId, candidateId, candidateName;
    private final int voteCount;
    public Result(String e,String c,String n,int v){electionId=e;candidateId=c;candidateName=n;voteCount=v;}
    public String getElectionId(){return electionId;}
    public String getCandidateId(){return candidateId;}
    public String getCandidateName(){return candidateName;}
    public int getVoteCount(){return voteCount;}
    @Override public String toString(){return "Election "+electionId+" | Candidate "+candidateId+
        " ("+candidateName+") | Votes: "+voteCount;}
}