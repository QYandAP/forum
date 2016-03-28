package com.apefactory.forum.entity;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseEntity implements Serializable {
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
