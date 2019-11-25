package com.oauth2.entities.embedded;

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
public class Contact {
	
	private String email;
	private String cellPhoneNumber;
	private String phoneNumber;
	
}
