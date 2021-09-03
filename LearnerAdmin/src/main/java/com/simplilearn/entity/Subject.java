package com.simplilearn.entity;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	@Id
	@GeneratedValue
	@Column(name ="subject_id")
	private int id;
	
	@Column(name ="subject_name")
	private String name;

	@ManyToOne /* (fetch= FetchType.EAGER) */
    @JoinColumn(name = "fk_teacher")
    private Teacher teacher;
	
    @OneToMany(mappedBy = "subject", fetch=FetchType.EAGER)
    Set<SubjectClass> subjects;

	public Set<SubjectClass> getClassRooms() {
		return subjects;
	}

	public void setClassRooms(Set<SubjectClass> subjects) {
		this.subjects = subjects;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable( name = "subject_class", joinColumns = @JoinColumn(name =
	 * "subject_id"), inverseJoinColumns = @JoinColumn(name = "class_id")) private
	 * Set<ClassRoom> classRooms;
	 * 
	 * 
	 * public Set<ClassRoom> getClassRooms() { return classRooms; }
	 * 
	 * public void setClassRooms(Set<ClassRoom> classRooms) { this.classRooms =
	 * classRooms; }
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String subjectName) {
		this.name = subjectName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
}

