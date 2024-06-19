package com.example.a2024_06_ib;

import com.example.a2024_06_ib.model.StudentBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {

   private int toto = 0;

    //http://localhost:8080/receiveStudent
//Json Attendu : {"name": "toto", "note": 12}
    @PostMapping("/receiveStudent")
    public void receiveStudent(@RequestBody StudentBean student) {
        System.out.println("/receiveStudent : " + student.getName() + " : " + student.getNote());


    }

    //http://localhost:8080/increment
//Json Attendu : {"name": "toto", "note": 12}
    @PostMapping("/increment")
    public StudentBean increment(@RequestBody StudentBean student) {
        System.out.println("/increment : " + student.getName() + " : " + student.getNote());

        student.setNote(student.getNote() + 1);

        return student;
    }

    //http://localhost:8080/test
    @GetMapping("/test")
    public String testMethode() {
        System.out.println("/test" + toto++);

        return "helloWorld";
    }

    //http://localhost:8080/max?p2=12
    @GetMapping("/max")
    public Integer max(String p1, String p2) {
        //name contiendra bob
        //note contiendra 12
        System.out.println("/max : p1=" + p1 + " p2=" + p2);

        Integer p1Int = null;
        Integer p2Int = null;
        try {
            p1Int = Integer.parseInt(p1);

        }catch(Exception e) {

        }
        try {
            p2Int = Integer.parseInt(p2);

        }catch(Exception ignored) {

        }

        if(p1Int == null) {
            return p2Int ;
        }
        if(p2Int == null){
            return p1Int;
        }

        return Math.max(p1Int, p2Int);
    }

    //http://localhost:8080/getStudent
    @GetMapping("/getStudent")
    public StudentBean getStudent() {
        System.out.println("/getStudent");

        return new StudentBean("toto", 12);
    }

    //http://localhost:8080/createStudent?name=bob&notation=12
    @GetMapping("/createStudent")
    public StudentBean createStudent(String name,
                                     @RequestParam(value = "notation", defaultValue = "0") int note) {
        //name contiendra bob
        //note contiendra 12
        System.out.println("/createStudent : name=" + name + " note=" + note);

        return new StudentBean(name, note);
    }
}