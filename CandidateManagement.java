import java.util.*;
public class CandidateManagement {
    private final Map<String,Candidate> candidates=new LinkedHashMap<>();
    public boolean addCandidate(String id,String name,String course,String dept,String position,String manifesto){
        if(candidates.containsKey(id.trim()))return false;
        candidates.put(id.trim(),new Candidate(id,name,course,dept,position,manifesto));return true;
    }
    public Candidate find(String id){return candidates.get(id==null?"":id.trim());}
    public boolean update(String id,String n,String c,String d,String p,String m){
        Candidate x=find(id);if(x==null)return false;x.update(n,c,d,p,m);return true;
    }
    public boolean delete(String id){return candidates.remove(id.trim())!=null;}
    public Collection<Candidate> all(){return Collections.unmodifiableCollection(candidates.values());}
}