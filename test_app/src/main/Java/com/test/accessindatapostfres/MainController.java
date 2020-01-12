package com.test.accessindatapostfres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/test", method = RequestMethod.GET)
public class MainController {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private StudentRepository studentRepository;


    @PostMapping(path = "/addS")
    public @ResponseBody String addNewStudent(@RequestParam String name, @RequestParam int group_id){
        Student s = new Student();
        s.setName(name);
        s.setGroup_id(group_id);
        studentRepository.save(s);
        return "Student saved";
    }

    @PostMapping(path = "/updS")
    public @ResponseBody String updateStudent(@RequestParam int id, @RequestParam String name, @RequestParam int group_id){
        Student s = studentRepository.findById(id).get();
        s.setGroup_id(group_id);
        s.setName(name);
        studentRepository.save(s);
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
