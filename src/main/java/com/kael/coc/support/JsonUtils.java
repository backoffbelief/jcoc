package com.kael.coc.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	private static final ObjectMapper defaultMapper = new ObjectMapper();
	
	public static <T> String toJSON(T object) {
		
		ObjectMapper mapper = getObjectMapper();
		try {
			String jsonStr = mapper.writeValueAsString(object);
			return jsonStr;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			throw new RuntimeException("JsonGenerationException",e);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			throw new RuntimeException("JsonMappingException",e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("IOException",e);
		}
		
	}
	
	private static ObjectMapper getObjectMapper() {
		return defaultMapper;
	}

	public static <T> T fromJSON(String jsonString, Class<T> clazz) {

		ObjectMapper mapper = getObjectMapper();
		T object = null;
		try {
			object = mapper.readValue(jsonString, clazz);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			throw new RuntimeException("JsonGenerationException", e);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			throw new RuntimeException("JsonMappingException", e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("IOException", e);
		}
		return object;
	}
	
	public static <T> List<T> fromJSONToList(String jsonString, Class<T> clazz) {
		
		ObjectMapper mapper = getObjectMapper();
		try {
			 JsonNode  rootNode = mapper.readTree(jsonString);
			 Iterator<JsonNode> it=  rootNode.elements();
			 List<T> list =  new ArrayList<T>();
			 while(it.hasNext()){
				 T t = fromJSON(it.next().toString(),clazz);  
				 list.add(t);
			 }
			 return list;
		}catch (JsonGenerationException e) {
			throw new RuntimeException("JsonGenerationException",e);
		} catch (JsonMappingException e) {
			throw new RuntimeException("JsonMappingException",e);
		} catch (IOException e) {
			throw new RuntimeException("IOException",e);
		}
	}
}
