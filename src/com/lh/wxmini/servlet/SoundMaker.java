//package com.lh.wxmini.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.iflytek.cloud.speech.SpeechSynthesizer;
//import com.lh.wxmini.synch.LSSynthListener;
//import com.lh.wxmini.synch.SynthesizerManager;
//
///**
// * Servlet implementation class SoundMaker
// */
//@WebServlet("/SoundMaker")
//public class SoundMaker extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public SoundMaker() {
//        super();
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doit(request);
//	}
//
//	private void doit(HttpServletRequest request)
//	{
//		System.out.println("invoke sound maker success~!");
//		String text = (String)request.getParameter("text");
//		System.out.println("Receive text = " + text);
//		String p1 = System.getProperty("user.dir");
//		String p2 = System.getProperty("java.library.path");
//		System.out.println("user.dir = " + p1 + " java.libray.path = " + p2);
//		SynthesizerManager manager = new SynthesizerManager();
//		LSSynthListener listener = new LSSynthListener();
//		SpeechSynthesizer synthesizer = manager.getSynthesizer();
//		synthesizer.startSpeaking(text, listener);
//		System.out.println("isSpeaking = " + synthesizer.isSpeaking());
//		HttpSession session = request.getSession();
//		session.setAttribute("flag", true);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doit(request);
//	}
//
//}
