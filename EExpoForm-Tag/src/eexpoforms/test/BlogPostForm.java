package eexpoforms.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



public class BlogPostForm extends BlogPostEntity {
	
	public Map<Integer,String> catListAll(){
		LinkedHashMap<Integer, String> value_labelMap = new LinkedHashMap<>();
		for(int i=0; i<15; i++){
			value_labelMap.put(i, "Label "+i);
		}		
		return value_labelMap;
	}
	public List<String> tagListAll(){
		
		List<String>  result = new ArrayList<>();
		for(int i=1; i<5; i++){
			result.add("tag-"+i);
		}		
		return result;
	}
	
	public Map<Integer,String> authorIdAll(){
		LinkedHashMap<Integer, String> value_labelMap = new LinkedHashMap<>();
		for(int i=0; i<15; i++){
			value_labelMap.put(i, "Author "+i);
		}		
		return value_labelMap;

		
	}
}
