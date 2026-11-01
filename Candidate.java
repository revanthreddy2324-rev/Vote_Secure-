public class Candidate {
    private final String candidateId;
    private String name, course, department, position, manifesto;
    private boolean active = true;

    public Candidate(String candidateId, String name, String course,
                     String department, String position, String manifesto) {
        this.candidateId=required(candidateId,"Candidate ID");
        this.name=required(name,"Name");
        this.course=required(course,"Course");
        this.department=required(department,"Department");
        this.position=required(position,"Position");
        this.manifesto=manifesto==null?"":manifesto.trim();
    }
    private static String required(String v,String f){
        if(v==null||v.trim().isEmpty()) throw new IllegalArgumentException(f+" cannot be empty.");
        return v.trim();
    }
    public String getCandidateId(){return candidateId;}
    public String getName(){return name;}
    public String getCourse(){return course;}
    public String getDepartment(){return department;}
    public String getPosition(){return position;}
    public String getManifesto(){return manifesto;}
    public boolean isActive(){return active;}
    public void update(String n,String c,String d,String p,String m){
        name=required(n,"Name"); course=required(c,"Course"); department=required(d,"Department");
        position=required(p,"Position"); manifesto=m==null?"":m.trim();
    }
    public void setActive(boolean v){active=v;}
    @Override public String toString(){
        return "Candidate ID: "+candidateId+" | Name: "+name+" | Course: "+course+
               " | Department: "+department+" | Position: "+position+" | Active: "+active;
    }
}