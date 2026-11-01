public class Student {
    private final String studentId;
    private String name, course, department;
    private int year;
    private boolean active = true;

    public Student(String studentId, String name, String course, String department, int year) {
        this.studentId = requireId(studentId, "Student ID");
        this.name = requireText(name, "Name");
        this.course = requireText(course, "Course");
        this.department = requireText(department, "Department");
        setYear(year);
    }
    private static String requireId(String v, String field) {
        if (v == null || v.trim().isEmpty()) throw new IllegalArgumentException(field + " cannot be empty.");
        return v.trim();
    }
    private static String requireText(String v, String field) {
        if (v == null || v.trim().isEmpty()) throw new IllegalArgumentException(field + " cannot be empty.");
        return v.trim();
    }
    public String getStudentId(){ return studentId; }
    public String getName(){ return name; }
    public String getCourse(){ return course; }
    public String getDepartment(){ return department; }
    public int getYear(){ return year; }
    public boolean isActive(){ return active; }
    public void setName(String v){ name=requireText(v,"Name"); }
    public void setCourse(String v){ course=requireText(v,"Course"); }
    public void setDepartment(String v){ department=requireText(v,"Department"); }
    public void setYear(int v){ if(v<1) throw new IllegalArgumentException("Year must be 1 or greater."); year=v; }
    public void setActive(boolean v){ active=v; }
    @Override public String toString(){
        return "Student ID: "+studentId+" | Name: "+name+" | Course: "+course+
               " | Department: "+department+" | Year: "+year+" | Active: "+active;
    }
}