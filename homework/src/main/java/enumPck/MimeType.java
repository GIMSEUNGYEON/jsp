package enumPck;

import java.util.stream.Stream;

public enum MimeType {
	APPLICATION_JSON("application/json;charset=UTF-8"), 
	APPLICATION_XML("application/xml;charset=UTF-8"), 
	TEXT_HTML("text/html;charset=UTF-8"), 
	TEXT_PLAIN("text/plain;charset=UTF-8");

	private String mimeType;

	public String getMimeType() {
		return mimeType;
	}

	private MimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	
	public static MimeType findTypeName(String AType) {
		final String type = AType;
		return Stream.of(values())
				.filter(c->type.equals(c.name()))
				.findFirst()
				.orElse(TEXT_HTML);
	}
	
	public static String findMimeType(String AType) {
		return findTypeName(AType).getMimeType();
	}
	
}
