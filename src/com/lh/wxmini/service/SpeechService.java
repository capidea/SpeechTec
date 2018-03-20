package com.lh.wxmini.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.lh.wxmini.entity.Speech;

@Service
public class SpeechService
{

	private static List<Speech> alist = new ArrayList<>();

	static {
		for (int i = 1; i < 10; i++) {
			Speech sp = new Speech();
			sp.setId(String.valueOf(i));
			sp.setName(String.valueOf(i) +"_Speech");
			alist.add(sp);
			System.out.println(sp);
		}
	}
	public Speech synthetise(String content, HttpSession session) 
	{
		Speech sp = new Speech();
		String id = session.getId();
		sp.make(content,id);
//		sp.setId(id);
//		sp.setName(name);
		return sp;
	}
	
	public List<Speech> getAlist()
	{
		return alist;
	}
	
	
}
