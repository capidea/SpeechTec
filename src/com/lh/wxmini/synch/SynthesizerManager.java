//package com.lh.wxmini.synch;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import com.iflytek.cloud.speech.ResourceUtil;
//import com.iflytek.cloud.speech.SpeechConstant;
//import com.iflytek.cloud.speech.SpeechSynthesizer;
//import com.iflytek.cloud.speech.SpeechUtility;
//import com.lh.wxmini.utils.DebugLog;
//
///**
// * 语音合成器的管理类
// * @author Nokia
// */
//public class SynthesizerManager
//{
//	private SpeechSynthesizer synthesizer;
//	private Map<String, String> mParamMap = new HashMap<String, String>();
//	
//	public SynthesizerManager()
//	{
//		synthesizer = SpeechSynthesizer.createSynthesizer();
//		initParamMap();
//		setting();
//	}
//
//	public SpeechSynthesizer getSynthesizer()
//	{
//		return synthesizer;
//	}
//
//	public void setSynthesizer(SpeechSynthesizer synthesizer)
//	{
//		this.synthesizer = synthesizer;
//	}
//	
//	private void initParamMap()
//	{
//		this.mParamMap.put( SpeechConstant.ENGINE_TYPE, DefaultValue.ENG_TYPE );
//		this.mParamMap.put( SpeechConstant.VOICE_NAME, DefaultValue.VOICE );
//		this.mParamMap.put( SpeechConstant.BACKGROUND_SOUND, DefaultValue.BG_SOUND );
//		this.mParamMap.put( SpeechConstant.SPEED, DefaultValue.SPEED );
//		this.mParamMap.put( SpeechConstant.PITCH, DefaultValue.PITCH );
//		this.mParamMap.put( SpeechConstant.VOLUME, DefaultValue.VOLUME );
//		this.mParamMap.put( SpeechConstant.TTS_AUDIO_PATH, "./tts_test.pcm");
//	}
//	
//	private void setting()
//	{
//		StringBuffer param = new StringBuffer();
//		param.append( "appid=5a5ef0f2");// + Version.getAppid() );
////		param.append( ","+SpeechConstant.LIB_NAME_32+"=myMscName" );
//		SpeechUtility.createUtility( param.toString() );
//		
//		final String engType = this.mParamMap.get(SpeechConstant.ENGINE_TYPE);
//		String voiceName = null;
//
//		for (Entry<String, String> entry : this.mParamMap.entrySet())
//		{
//			String value = entry.getValue();
//			if (SpeechConstant.VOICE_NAME.equals(entry.getKey()))
//			{
//				String[] names = {"xiaoyan","xiaoyu"}; //this.mVoiceMap.get(entry.getValue());
//				boolean equals = SpeechConstant.TYPE_CLOUD.equals(engType);
//				voiceName = value = equals ? names[0]: names[1];
//			}
//
//			synthesizer.setParameter(entry.getKey(), value);
//		}
//
//		// 本地合成时设置资源，并启动引擎
//		if (SpeechConstant.TYPE_LOCAL.equals(engType))
//		{
//			// 启动合成引擎
//			synthesizer.setParameter(ResourceUtil.ENGINE_START,
//					SpeechConstant.ENG_TTS);
//			// 设置资源路径
//			String curPath = System.getProperty("user.dir");
//			DebugLog.Log("Current path=" + curPath);
//			String resPath = ResourceUtil.generateResourcePath(curPath
//					+ "/tts/common.jet")
//					+ ";"
//					+ ResourceUtil.generateResourcePath(curPath + "/tts/"
//							+ voiceName + ".jet");
//			System.out.println("resPath=" + resPath);
//			synthesizer.setParameter(ResourceUtil.TTS_RES_PATH, resPath);
//		}// end of if is TYPE_LOCAL
//
//		// 启用合成音频流事件，不需要时，不用设置此参数
//		synthesizer.setParameter(SpeechConstant.TTS_BUFFER_EVENT, "1");
//	}// end of function setting
//	
//	
//	private static class DefaultValue{
//		public static final String ENG_TYPE = SpeechConstant.TYPE_CLOUD;
//		public static final String VOICE = "小燕";
//		public static final String BG_SOUND = "0";
//		public static final String SPEED = "50";
//		public static final String PITCH = "50";
//		public static final String VOLUME = "50";
////		public static final String SAVE = "0";
//	}
//}
