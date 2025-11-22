package StudentSystem2;

import java.util.LinkedList;

public class CheckData {
    public int searchId(LinkedList<Student> students, int id) {
        int index = 0;

        for (Student student : students) {
            if (student.getId() == id) {
                return index;
            }
            index++;
        }

        return -1;
    }
}


