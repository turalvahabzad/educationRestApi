package com.example.education3.student;

import com.example.education3.student.entity.Teacher;
import com.example.education3.student.entity.University;
import com.example.education3.student.repo.CustomTeacherRepo;
import com.example.education3.student.repo.TeacherRepoData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherRepoData dataRepot;

    private final CustomTeacherRepo teacherRepo;

    public TeacherController(final TeacherRepoData dataRepot,
                             final CustomTeacherRepo teacherRepo) {
        this.dataRepot = dataRepot;
        this.teacherRepo = teacherRepo;
    }

    //?name

    @GetMapping
    public List<Teacher> getList(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String email,
            @RequestParam(required = false, name = "university_id") Integer universityId,
            @RequestParam(required = false) Integer age){
        return teacherRepo.getList(name, surname, email, universityId, age);
    }

    @PostMapping
    public void insert(@RequestBody Teacher teacher) {
        dataRepot.save(teacher);
    }

    @PutMapping
    public void update(@RequestBody Teacher teacher) {
        dataRepot.save(teacher);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        dataRepot.deleteById(id);
    }

    @GetMapping("{id}")
    public Teacher findById(@PathVariable("id") Integer id) {
        return dataRepot.findById(id).get();
    }

    //students/1/universities/1
    @GetMapping("{id}/universities/{universityId}")
    public University findByIdUniversity(
            @PathVariable("id") Integer id,
            @PathVariable("universityId") Integer universityId
    ) {
        return dataRepot.findById(id).get().getUniversity();
    }


}
