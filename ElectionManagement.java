import java.util.*;
public class ElectionManagement {
    private final Map<String,Election> elections=new LinkedHashMap<>();
    public boolean create(String id,String name,String date,String position){
        if(elections.containsKey(id.trim()))return false;
        elections.put(id.trim(),new Election(id,name,date,position));return true;
    }
    public Election find(String id){return elections.get(id==null?"":id.trim());}
    public boolean start(String id){Election e=find(id);return e!=null&&e.start();}
    public boolean end(String id){Election e=find(id);return e!=null&&e.end();}
    public Collection<Election> all(){return Collections.unmodifiableCollection(elections.values());}
}