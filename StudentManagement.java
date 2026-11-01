import java.util.*;
public class StudentManagement {
    private final Map<String,Student> students=new LinkedHashMap<>();
    public boolean addStudent(String id,String name,String course,String dept,int year){
        if(students.containsKey(id.trim())) return false;
        students.put(id.trim(),new Student(id,name,course,dept,year)); return true;
    }
    public Student find(String id){return students.get(id==null?"":id.trim());}
    public boolean update(String id,String n,String c,String d,int y){
        Student s=find(id); if(s==null)return false;
        s.setName(n);s.setCourse(c);s.setDepartment(d);s.setYear(y);return true;
    }
    public boolean delete(String id){return students.remove(id.trim())!=null;}
    public Collection<Student> all(){return Collections.unmodifiableCollection(students.values());}
}