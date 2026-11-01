import java.util.*;
public class SearchService {
    public Student searchStudent(String id,StudentManagement m){return m.find(id);}
    public Candidate searchCandidate(String id,CandidateManagement m){return m.find(id);}
    public Election searchElection(String id,ElectionManagement m){return m.find(id);}
}