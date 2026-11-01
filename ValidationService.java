public class ValidationService {
    public String validateVote(Student student,Candidate candidate,Election election,
                               boolean alreadyVoted){
        if(student==null)return "Student ID was not found.";
        if(!student.isActive())return "Student is inactive.";
        if(candidate==null)return "Candidate ID was not found.";
        if(!candidate.isActive())return "Candidate is inactive.";
        if(election==null)return "Election ID was not found.";
        if(!"OPEN".equals(election.getStatus()))return "This election is not open.";
        if(alreadyVoted)return "This student has already voted in this election.";
        if(!candidate.getPosition().equalsIgnoreCase(election.getPosition()))
            return "Candidate is not nominated for this election position.";
        return null;
    }
}