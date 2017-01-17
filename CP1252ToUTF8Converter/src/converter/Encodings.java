package converter;

public enum Encodings {

	CP1252("windows-1252", "cp1252"), UTF8("UTF-8", "8-bit Unicode Transformation Format");	
	
	private String code;
	private String description;
	
	
	private Encodings(String code, String description) {
		this.code = code;
		this.description = description;
	}
	

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}
