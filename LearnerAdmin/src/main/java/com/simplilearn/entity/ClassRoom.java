package com.simplilearn.entity;

import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
@Table(name="classroom")
public class ClassRoom {
	@Id
	@GeneratedValue
	@Column(name ="class_id")
	private int id;
	
	@Column(name ="class_name")
	private String name;

	@OneToMany(mappedBy = "classRoom", fetch= FetchType.EAGER)
    private List<Student> students = new ArrayList<Student>();
	
    @OneToMany(mappedBy = "classRoom", fetch=FetchType.EAGER)
    Set<SubjectClass> classRooms;

	public Set<SubjectClass> getClassRooms() {
		return classRooms;
	}

	public void setClassRooms(Set<SubjectClass> classRooms) {
		this.classRooms = classRooms;
	}
	
    /*
	 * @ManyToMany (mappedBy = "classRooms") private Set<Subject> subjects;
	 */
	/*
	 * public Set<Subject> getSubjects() { return subjects; }
	 * 
	 * public void setSubjects(Set<Subject> subjects) { this.subjects = subjects; }
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public void addStudent(Student student) {
        this.students.add(student);
        student.setClassRoom(this);
    }

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClassRoom [id=" + id + ", className=" + name + "]";
	}
	public String getDisplayString() {
		return this.name;
	}
	
}
