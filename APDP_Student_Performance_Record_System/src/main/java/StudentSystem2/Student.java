package StudentSystem2;

public class Student {
    private int id;
    private String name;
    private int age;
    private boolean gender;
    private double studytime;
    private int absences;
    private boolean tutoring;
    private boolean extracurrculum;
    private boolean sports;
    private boolean music;
    private boolean volunteering;
    private double GPA;

    public Student(int id, String name, int age, boolean gender, double studytime, int absences, boolean tutoring, boolean extracurrculum, boolean sports, boolean music, boolean volunteering, double GPA) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.studytime = studytime;
        this.absences = absences;
        this.tutoring = tutoring;
        this.extracurrculum = extracurrculum;
        this.sports = sports;
        this.music = music;
        this.volunteering = volunteering;
        this.GPA = GPA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getStudytime() {
        return studytime;
    }

    public void setStudytime(double studytime) {
        this.studytime = studytime;
    }

    public int getAbsences() {
        return absences;
    }

    public void setAbsences(int absences) {
        this.absences = absences;
    }

    public boolean isTutoring() {
        return tutoring;
    }

    public void setTutoring(boolean tutoring) {
        this.tutoring = tutoring;
    }

    public boolean isExtracurrculum() {
        return extracurrculum;
    }

    public void setExtracurrculum(boolean extracurrculum) {
        this.extracurrculum = extracurrculum;
    }

    public boolean isSports() {
        return sports;
    }

    public void setSports(boolean sports) {
        this.sports = sports;
    }

    public boolean isMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public boolean isVolunteering() {
        return volunteering;
    }

    public void setVolunteering(boolean volunteering) {
        this.volunteering = volunteering;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}
