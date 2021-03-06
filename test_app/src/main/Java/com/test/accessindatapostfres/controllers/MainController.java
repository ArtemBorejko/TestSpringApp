package com.test.accessindatapostfres.controllers;
import com.test.accessindatapostfres.entities.Group;
import com.test.accessindatapostfres.entities.Student;
import com.test.accessindatapostfres.repositories.GroupRepository;
import com.test.accessindatapostfres.repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/test", method = RequestMethod.GET)
public class MainController {

    private GroupRepository groupRepository;
    private StudentRepository studentRepository;

    public MainController(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    @PostMapping(path = "/addS")
    public @ResponseBody String addNewStudent(@RequestParam String name, @RequestParam String nameOfGroup){
        Student s = new Student();
        if(groupRepository.findByName(nameOfGroup) != null){
            Group g = groupRepository.findByName(nameOfGroup);
            s.setGroup_id(g);
            s.setName(name);
            studentRepository.save(s);
        }
        else{
            Group g = new Group();
            g.setName(nameOfGroup);
            s.setName(name);
            s.setGroup_id(g);
            groupRepository.save(g);
            studentRepository.save(s);
        }
        return "Student saved";
    }

    @PostMapping(path = "/updS")
    public @ResponseBody String updateStudent(@RequestParam int id, @RequestParam String name, @RequestParam String nameOfGroup){
        Student s = studentRepository.findById(id).get();
        if(groupRepository.findByName(nameOfGroup) != null){
            Group g = groupRepository.findByName(nameOfGroup);
            s.setGroup_id(g);
            s.setName(name);
            studentRepository.save(s);
        }
        else{
            Group g = new Group();
            g.setName(nameOfGroup);
            s.setName(name);
            s.setGroup_id(g);
            groupRepository.save(g);
            studentRepository.save(s);
        }
        return "Student updated!";
    }

    @PostMapping(path = "/delS")
    public @ResponseBody String deleteStudent(@RequestParam int id){
        studentRepository.deleteById(id);
        return "Student deleted!";
    }

    @PostMapping(path = "/addG")
    public @ResponseBody String addNewGroup(@RequestParam String name){
        Group g = new Group();
        g.setName(name);
        groupRepository.save(g);
        return "Group saved";
    }

    @PostMapping(path = "/updG")
    public @ResponseBody String updateGroup(@RequestParam int id, @RequestParam String name) {
        Group g = groupRepository.findById(id).get();
        g.setName(name);
        groupRepository.save(g);
        return "Group updated!";
    }

    @PostMapping(path = "/delG")
    public @ResponseBody String deleteGroup(@RequestParam int id){
        groupRepository.deleteById(id);
        return "Group deleted!";
    }

    @GetMapping(path = "/allS")
    public @ResponseBody Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(path = "/allG")
    public @ResponseBody Iterable<Group> getAllGroups(){
        return groupRepository.findAll();
    }

}
