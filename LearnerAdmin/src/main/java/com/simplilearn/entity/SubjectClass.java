package com.simplilearn.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
public class SubjectClass {

    @EmbeddedId
    ClassSubjectKey id;

    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name = "subject_id")
    Subject subject;

    @ManyToOne
    @MapsId("classId")
    @JoinColumn(name = "class_id")
    ClassRoom classRoom;

	public ClassSubjectKey getId() {
		return id;
	}

	public void setId(ClassSubjectKey id) {
		this.id = id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
    
    
}