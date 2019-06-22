package com.btvn02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Process {
	private Map<String, Integer> listMap;

	public Process() {
		listMap = new HashMap<>();
	}

	public void readFile(String pathFile) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(pathFile);
			br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				s = s.replaceAll(Constant.REGEX_REPLACE, " ");
				putMap(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(fr != null) {
					fr.close();
				}
				if(br != null) {
					br.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	private void putMap(String content) {
		String arr[] = content.split(Constant.REGEX_SPLIT);
		String key;
		int value;
		for (int i = 0; i < arr.length; i++) {
			key = arr[i];
			if (key.equals(""))
				continue;
			if (listMap.containsKey(key)) {
				value = listMap.get(key);
				listMap.remove(key);
				listMap.put(key, value + 1);
			} else {
				listMap.put(key, 1);
			}
		}
	}

	public void sort() {
		Map<String, Integer> sortMap = new LinkedHashMap<>();

		List<Map.Entry<String, Integer>> listSave = new ArrayList<>(listMap.entrySet());
		Comparator<Entry<String, Integer>> value = new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		};

		Collections.sort(listSave, value);
		for (Map.Entry<String, Integer> entry : listSave) {
			sortMap.put(entry.getKey(), entry.getValue());
		}
		printInfo(sortMap);
	}

	private void printInfo(Map<String, Integer> a) {
		System.out.println("Danh sach cac tu xuat hien va tan xuat hien: ");
		for (String key : a.keySet()) {
			System.out.println("Tu: " + key + " - Xuat hien: " + a.get(key));
		}
	}
}
