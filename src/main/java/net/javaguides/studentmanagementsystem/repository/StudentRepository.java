package net.javaguides.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.studentmanagementsystem.entity.Student;

//we dont have to add @Repository and @Transactional annotations here because JpaRepository<> interface has a 
//default implementation class called Simplejparepository, which is annotated with @Repository and @Transactional annotations
// Therefore by default JpaRepository is also enablled with Transactions for all its methods
//so we dont have to add them to the service layer 

public interface StudentRepository extends JpaRepository<Student,Long> { //Long is used as Type of 'id' was LONG
// JPA  Repo has two parameters, 1. The type of JPA entity and 2. Type of primary key of the    
}
