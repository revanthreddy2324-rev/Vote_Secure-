import java.util.*;
public class Main {
    private static final Scanner in=new Scanner(System.in);
    private static final StudentManagement students=new StudentManagement();
    private static final CandidateManagement candidates=new CandidateManagement();
    private static final ElectionManagement elections=new ElectionManagement();
    private static final VotingManagement voting=new VotingManagement();
    private static final ValidationService validation=new ValidationService();
    private static final VoteTally tally=new VoteTally();
    private static final ResultManagement results=new ResultManagement();
    private static final SearchService search=new SearchService();
    private static final ReportGenerationService reports=new ReportGenerationService();
    private static final AnalysisService analysis=new AnalysisService();

    public static void main(String[] args){
        boolean running=true;
        while(running){
            System.out.println("\n===== VOTESECURE - STUDENT COUNCIL VOTING SYSTEM =====");
            System.out.println("1 Add Student\n2 Update Student\n3 Delete Student\n4 List Students");
            System.out.println("5 Add Candidate\n6 Update Candidate\n7 Delete Candidate\n8 List Candidates");
            System.out.println("9 Create Election\n10 Start Election\n11 End Election\n12 Cast Vote");
            System.out.println("13 Vote Tally\n14 Publish Results\n15 Search\n16 Generate Reports\n17 Analysis\n0 Exit");
            switch(readInt("Choose: ")){
                case 1:addStudent();break; case 2:updateStudent();break; case 3:deleteStudent();break; case 4:students.all().forEach(System.out::println);break;
                case 5:addCandidate();break;case 6:updateCandidate();break;case 7:deleteCandidate();break;case 8:candidates.all().forEach(System.out::println);break;
                case 9:createElection();break;case 10:System.out.println(elections.start(read("Election ID: "))?"Election opened.":"Could not open election. Check ID/status.");break;
                case 11:System.out.println(elections.end(read("Election ID: "))?"Election closed.":"Could not close election. Check ID/status.");break;
                case 12:castVote();break;case 13:showTally();break;case 14:publishResults();break;case 15:searchMenu();break;case 16:generateReports();break;case 17:analyse();break;
                case 0:running=false;System.out.println("Goodbye.");break;default:System.out.println("Invalid menu option.");
            }
        }
    }
    private static String read(String prompt){System.out.print(prompt);return in.nextLine().trim();}
    private static int readInt(String prompt){while(true){try{return Integer.parseInt(read(prompt));}catch(NumberFormatException e){System.out.println("Enter a valid whole number.");}}}
    private static void addStudent(){
        String id=read("Enter your Student ID (letters/numbers allowed): ");
        try{boolean ok=students.addStudent(id,read("Name: "),read("Course: "),read("Department: "),readInt("Year: "));
            System.out.println(ok?"Student added.":"That Student ID already exists.");}
        catch(IllegalArgumentException e){System.out.println("Invalid student: "+e.getMessage());}
    }
    private static void updateStudent(){
        String id=read("Student ID to update: ");
        if(students.find(id)==null){System.out.println("Student not found.");return;}
        try{System.out.println(students.update(id,read("New name: "),read("New course: "),read("New department: "),readInt("New year: "))?"Updated.":"Not updated.");}
        catch(IllegalArgumentException e){System.out.println(e.getMessage());}
    }
    private static void deleteStudent(){System.out.println(students.delete(read("Student ID: "))?"Student deleted.":"Student not found.");}
    private static void addCandidate(){
        String id=read("Enter your Candidate ID (letters/numbers allowed): ");
        try{boolean ok=candidates.addCandidate(id,read("Name: "),read("Course: "),read("Department: "),read("Election position: "),read("Manifesto: "));
            System.out.println(ok?"Candidate added.":"That Candidate ID already exists.");}
        catch(IllegalArgumentException e){System.out.println("Invalid candidate: "+e.getMessage());}
    }
    private static void updateCandidate(){
        String id=read("Candidate ID to update: ");if(candidates.find(id)==null){System.out.println("Candidate not found.");return;}
        try{System.out.println(candidates.update(id,read("New name: "),read("New course: "),read("New department: "),read("New position: "),read("New manifesto: "))?"Updated.":"Not updated.");}
        catch(IllegalArgumentException e){System.out.println(e.getMessage());}
    }
    private static void deleteCandidate(){System.out.println(candidates.delete(read("Candidate ID: "))?"Candidate deleted.":"Candidate not found.");}
    private static void createElection(){
        String id=read("Enter your Election ID (letters/numbers allowed): ");
        try{System.out.println(elections.create(id,read("Election name: "),read("Date: "),read("Position: "))?"Election created.":"That Election ID already exists.");}
        catch(IllegalArgumentException e){System.out.println(e.getMessage());}
    }
    private static void castVote(){
        String electionId=read("Election ID: "), studentId=read("Student ID: "), candidateId=read("Candidate ID: ");
        System.out.println(voting.castVote(studentId,candidateId,electionId,students,candidates,elections,validation));
    }
    private static Map<String,Integer> getTally(String id){return tally.count(id,voting.forElection(id));}
    private static void showTally(){String id=read("Election ID: ");Map<String,Integer> t=getTally(id);if(elections.find(id)==null)System.out.println("Election not found.");else if(t.isEmpty())System.out.println("No votes yet.");else t.forEach((k,v)->System.out.println(k+" : "+v));}
    private static void publishResults(){
        String id=read("Election ID: ");Election e=elections.find(id);
        if(e==null){System.out.println("Election not found.");return;}
        if(!"CLOSED".equals(e.getStatus())){System.out.println("Close the election before publishing results.");return;}
        results.display(results.createResults(id,getTally(id),candidates));
    }
    private static void searchMenu(){
        System.out.println("1 Student ID  2 Candidate ID  3 Election ID");
        switch(readInt("Search type: ")){
            case 1:System.out.println(search.searchStudent(read("Student ID: "),students));break;
            case 2:System.out.println(search.searchCandidate(read("Candidate ID: "),candidates));break;
            case 3:System.out.println(search.searchElection(read("Election ID: "),elections));break;
            default:System.out.println("Invalid search type.");
        }
    }
    private static void generateReports(){
        reports.generate("Students.txt",students.all());reports.generate("Candidates.txt",candidates.all());
        reports.generate("Elections.txt",elections.all());reports.generate("Votes.txt",voting.all());
    }
    private static void analyse(){
        String id=read("Election ID: ");if(elections.find(id)==null){System.out.println("Election not found.");return;}
        analysis.display(id,students.all().size(),voting.forElection(id),getTally(id));
    }
}