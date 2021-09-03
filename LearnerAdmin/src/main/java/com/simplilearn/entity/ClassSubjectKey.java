package com.simplilearn.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClassSubjectKey implements Serializable {

    @Column(name = "class_id")
    int classId;

    @Column(name = "subject_id")
    int subjectId;

    public ClassSubjectKey() {
    	
    }

    public ClassSubjectKey(int classId, int subjectId ) {
    	this.classId= classId;
    	this.subjectId= subjectId;
    }

    
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

    
}