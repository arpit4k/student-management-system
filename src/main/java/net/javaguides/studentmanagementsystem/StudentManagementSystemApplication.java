package net.javaguides.studentmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.studentmanagementsystem.entity.Student;
import net.javaguides.studentmanagementsystem.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {
	//Implements CLR - makes sure that the bean runs autmocatically and dynamically 
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	@Autowired //The right depedency is injected with the help of this @ 
	private StudentRepository studentRepository; //Instance of Student Repositpry is declared

	@Override
	public void run(String... args) throws Exception {
		// Student student1 = new Student("Tony", "Stark", "arp@xyz.com");
		// studentRepository.save(student1);

		// Student student2 = new Student("Steven", "Rogers", "shid@ays.com");
		// studentRepository.save(student2);
		
		// Student student3 = new Student("Bruce", "Banner", "frd@xys.com");
		// studentRepository.save(student3);

	}

}
