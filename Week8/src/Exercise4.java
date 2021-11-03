import java.util.*;

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;
    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student s) {
        /*if (Double.compare(this.getCgpa(),s.getCgpa()) == 0) {
            if (this.getName().compareTo(s.getName()) == 0) {
                return Integer.compare(this.getId(), s.getId());
            } else {
                return this.getName().compareTo(s.getName());
            }
        } else {
            return Double.compare(this.getCgpa(), s.getCgpa());
        }*/
        if (this.cgpa == s.cgpa) {
            if (this.name.equals(s.name)) {
                return (this.id - s.id);
            } else {
                return this.name.compareTo(s.name);
            }
        } else {
            return Double.compare(s.cgpa, this.cgpa);
        }
    }
}

/*class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (Double.compare(s1.getCgpa(),s2.getCgpa()) == 0) {
            if (s1.getName().compareTo(s2.getName()) == 0) {
                return Integer.compare(s1.getId(), s2.getId());
            } else {
                return s1.getName().compareTo(s2.getName());
            }
        } else {
            return Double.compare(s1.getCgpa(), s2.getCgpa());
        }
    }
}*/


class Priorities {
    //private final Comparator<Student> comparator = new StudentComparator();
    public static PriorityQueue<Student> studentQueue = new PriorityQueue<> ();

    public List<Student> getStudents(List<String> events) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).equals("SERVED")) {
                studentQueue.poll();
            } else {
                String str = events.get(i).substring(6);
                String name = str.substring(0, str.indexOf(" "));
                str = str.substring(str.indexOf(" ") + 1);
                double cgpa = Double.parseDouble(str.substring(0, str.indexOf(" ")));
                int id = Integer.parseInt(str.substring(str.indexOf(" ") + 1));
                Student student = new Student(id, name, cgpa);
                studentQueue.add(student);
            }
        }

        List<Student> students = new ArrayList<>();
        while (!studentQueue.isEmpty()) {
            students.add(studentQueue.poll());
        }
        return students;
    }
}

public class Exercise4 {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
