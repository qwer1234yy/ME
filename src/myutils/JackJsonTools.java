package myutils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JackJsonTools {
	static ObjectMapper objectMapper;

	public static <T> T fromJson(String content, Class<T> valueType) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}

		try {
			return objectMapper.readValue(content, valueType);
		} catch (Exception arg2) {
			arg2.printStackTrace();
			return null;
		}
	}

	public static String toJson(Object object) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}

		try {
			return objectMapper.writeValueAsString(object);
		} catch (Exception arg1) {
			arg1.printStackTrace();
			return null;
		}
	}
}
