
import com.bae.student_management.exceptions.StudentNotFoundException;
import com.bae.student_management.repos.StudentRepo;
import com.bae.student_management.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo repo;

    public StudentService(StudentRepo repo) {
        super();
        this.repo = repo;
    }

    // Post requests (CREATE)
    public Student create(Student input) {
        return repo.saveAndFlush(input);
    }

    // Get requests (READ)
    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(long id) {
        return repo.findById(id).orElseThrow(StudentNotFoundException::new);
    }


}
