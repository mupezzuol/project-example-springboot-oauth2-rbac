package com.oauth2.entities.embedded;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Embeddable
public class Contact implements Serializable{
	
	private static final long serialVersionUID = 4699181669223464082L;
	private String email;
	private String cellPhoneNumber;
	private String phoneNumber;
	
}
