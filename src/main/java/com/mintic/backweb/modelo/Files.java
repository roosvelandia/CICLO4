package com.mintic.backweb.modelo;

public class Files {
	private String fileUpload;

	public String getFilepath() {
		return fileUpload;
	}

	public void setFilepath(String filepath) {
		this.fileUpload = filepath;
	}

	public Files(String filepath) {
		super();
		this.fileUpload = filepath;
	}

	public Files() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
