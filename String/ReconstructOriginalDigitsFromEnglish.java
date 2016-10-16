package ninthContest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructOriginalDigitsFromEnglish {
	public static void main(String args[]){
		String s = "owoztneoer";
		String res = originalDigits(s);
		System.out.println(res);
	}
	
	public static String originalDigits(String s){
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(m.containsKey(c)){
				int count = m.get(c);
				m.put(c, ++count);
			}else{
				m.put(c, 1);
			}
		}
		
		List<Integer> list = new ArrayList<Integer>(); 
		
		while(m.get('z') != null && m.get('z') != 0){
			list.add(0);
			int count = m.get('z');
			if(count == 1){
				m.remove('z');
			}else{
				m.put('z', --count);
			}
			m.put('e', m.get('e') - 1);
			m.put('r', m.get('r') - 1);
			m.put('o', m.get('o') - 1);
		}
		
		while(m.get('w') != null && m.get('w') != 0){
			list.add(2);
			int count = m.get('w');
			if(count == 1){
				m.remove('w');
			}else{
				m.put('w', --count);
			}
			m.put('t', m.get('t') - 1);
			m.put('o', m.get('o') - 1);
		}
		
		while(m.get('x') != null && m.get('x') != 0){
			list.add(6);
			int count = m.get('x');
			if(count == 1){
				m.remove('x');
			}else{
				m.put('x', --count);
			}
			m.put('s', m.get('s') - 1);
			m.put('i', m.get('i') - 1);
		}
		
		while(m.get('g') != null && m.get('g') != 0){
			list.add(8);
			int count = m.get('g');
			if(count == 1){
				m.remove('g');
			}else{
				m.put('g', --count);
			}
			m.put('e', m.get('e') - 1);
			m.put('i', m.get('i') - 1);
			m.put('h', m.get('h') - 1);
			m.put('t', m.get('t') - 1);
		}
		
		while(m.get('s') != null && m.get('s') != 0){
			list.add(7);
			int count = m.get('s');
			if(count == 1){
				m.remove('s');
			}else{
				m.put('s', --count);
			}
			m.put('e', m.get('e') - 2);
			m.put('v', m.get('v') - 1);
			m.put('n', m.get('n') - 1);
		}
	
		while(m.get('v') != null && m.get('v') != 0){
			list.add(5);
			int count = m.get('v');
			if(count == 1){
				m.remove('v');
			}else{
				m.put('v', --count);
			}
			m.put('f', m.get('f') - 1);
			m.put('i', m.get('i') - 1);
			m.put('e', m.get('e') - 1);
		}
		
		while(m.get('f') != null && m.get('f') != 0){
			list.add(4);
			int count = m.get('f');
			if(count == 1){
				m.remove('f');
			}else{
				m.put('f', --count);
			}
			m.put('o', m.get('o') - 1);
			m.put('u', m.get('u') - 1);
			m.put('r', m.get('r') - 1);
		}
		
		while(m.get('h') != null && m.get('h') != 0){
			list.add(3);
			int count = m.get('h');
			if(count == 1){
				m.remove('h');
			}else{
				m.put('h', --count);
			}
			m.put('t', m.get('t') - 1);
			m.put('r', m.get('r') - 1);
			m.put('e', m.get('e') - 2);
		}
		
		while(m.get('o') != null && m.get('o') != 0){
			list.add(1);
			int count = m.get('o');
			if(count == 1){
				m.remove('o');
			}else{
				m.put('o', --count);
			}
			m.put('n', m.get('n') - 1);
			m.put('e', m.get('e') - 1);
		}
		
		while(m.get('i') != null && m.get('i') != 0){
			list.add(9);
			int count = m.get('i');
			if(count == 1){
				m.remove('i');
			}else{
				m.put('i', --count);
			}
			m.put('e', m.get('e') - 1);
			m.put('n', m.get('n') - 2);
		}
		
		StringBuffer sb = new StringBuffer();
		
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++){
			sb.append(list.get(i));
		}
		
		return sb.toString();
	}
}
