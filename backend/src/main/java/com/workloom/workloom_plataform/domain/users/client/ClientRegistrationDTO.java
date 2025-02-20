package com.workloom.workloom_plataform.domain.users.client;

public class ClientRegistrationDTO {
	private String name;
	private String email;
    private String password;

	public ClientRegistrationDTO() {}

	public ClientRegistrationDTO(String name, String email, String password) {
		setName(name);
		setEmail(email);
        setPassword(password);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

		public String getPassword() {
			return password;
		}
	
		public void setPassword(String password) {
			this.password = password;
		}
	}