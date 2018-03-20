package com.lh.wxmini.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lh.wxmini.entity.Speech;
import com.lh.wxmini.service.SpeechService;

@Controller
public class SynthetiseController
{
	@Autowired
	private SpeechService speechService;
	
	@ResponseBody
	@RequestMapping("/synthetise")
	public Map<String, Object> synthetise(String content, HttpSession seesion)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", false);
		Speech sp = speechService.synthetise(content, seesion);
		map.put("flag", true);
		map.put("rtnName", sp.getName());
		return map;
	}
	
}
