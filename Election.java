public class Election {
    private final String electionId;
    private String name, date, position;
    private String status="CREATED";
    public Election(String id,String name,String date,String position){
        if(id==null||id.trim().isEmpty()) throw new IllegalArgumentException("Election ID cannot be empty.");
        if(name==null||name.trim().isEmpty()) throw new IllegalArgumentException("Election name cannot be empty.");
        if(date==null||date.trim().isEmpty()) throw new IllegalArgumentException("Election date cannot be empty.");
        if(position==null||position.trim().isEmpty()) throw new IllegalArgumentException("Position cannot be empty.");
        electionId=id.trim(); this.name=name.trim(); this.date=date.trim(); this.position=position.trim();
    }
    public String getElectionId(){return electionId;}
    public String getName(){return name;}
    public String getDate(){return date;}
    public String getPosition(){return position;}
    public String getStatus(){return status;}
    public boolean start(){if(!"CREATED".equals(status))return false; status="OPEN"; return true;}
    public boolean end(){if(!"OPEN".equals(status))return false; status="CLOSED"; return true;}
    @Override public String toString(){return "Election ID: "+electionId+" | "+name+" | "+date+" | "+position+" | "+status;}
}