package net.javaguides.studentmanagementsystem.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import net.javaguides.studentmanagementsystem.service.StudentService;
import net.javaguides.studentmanagementsystem.entity.Student;
import net.javaguides.studentmanagementsystem.repository.StudentRepository;

@Service 
public class StudentServiceImpl implements StudentService {
    
    private StudentRepository studentRepository; 
    //A constructor based dependence injection is used to inject the dependencies here 

    //Whenever there is only one constructor then we can avoid using @atvoid annotation 
    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents(){
         return studentRepository.findAll(); 
         //studentRepository provides all crude methods and findall method will return a list of students 
    }
   @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);  //Saves the data object by calling instance of student repository & save 
    }

    @Override
    public Student getStudentById(Long id){
        return studentRepository.findById(id).get(); //Retrieves value of student object w the help of id 
        //and calls an instance of student repo to make the changes 
    }

    @Override
    public Student updateStudent(Student student){
        return studentRepository.save(student); //saves in the repo 
    }

    @Override
    public void deleteStudentById(Long id){
         studentRepository.deleteById(id); //Deletes in the repo
    }

}
