package net.javaguides.studentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.studentmanagementsystem.entity.Student;
import net.javaguides.studentmanagementsystem.service.StudentService;

@Controller
//Added @ to make this class a spring MVC class to handle requests 
public class StudentController {
    private StudentService studentService; //private instance of a studentService class is induced 
    //Because the above is induced, a parametrized constructor is used to access the same
    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }
    //handler method to handle list students and return mode and view 
   //Acts as a shortcut for RequestMapping and this handles
    //the HTTP GET requests matched with given URI expression in the ()
    @GetMapping("/students") 
    public String listStudents(Model model){ //Model is used as a holder for attributes and is used for adding attributes 

        //handler for showcasing the values in the list of students
        model.addAttribute("students",studentService.getAllStudents()); 
        //Adding data to the model with key value pair
        //Value i.e list of students from the Db 

        return "students"; //returning a view named students (i.e students.html)
    }

    //Handler method for handlind ADD STUDENT Query
    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        //Create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students"; // After execution, redirect to the above listStudents method / webpages

    }

    //handle method for handling the instance editing the student form 
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }
    //handler method to handle the UPDATE form request
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
       //path variables helps in simple mapping as it is an endpoint that identifies an entity with a primary key 
        //Getting a student from DB by id 
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName()); 
        existingStudent.setEmail(student.getEmail());
        // we need to save the updated student object and
        studentService.updateStudent(existingStudent);
        //redirect to students package
        return "redirect:/students";
    }

    //handler to handle the delete statement
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    
}
