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

    @PostMapping(path = "/addG")
    public @ResponseBody String addNewGroup(@RequestParam String name){
        Group g = new Group();
        g.setName(name);
        groupRepository.save(g);
        return "Group saved";
    }

    @GetMapping(path = "/allG")
    public @ResponseBody Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(path = "/allS")
    public @ResponseBody Iterable<Group> getAllGroups(){
        return groupRepository.findAll();
    }
}
