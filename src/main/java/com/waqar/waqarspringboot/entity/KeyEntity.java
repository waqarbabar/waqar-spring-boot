package com.waqar.waqarspringboot.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class KeyEntity {
	@Id
	@Column(name = "PK", unique = true)
	private String pk;

}
