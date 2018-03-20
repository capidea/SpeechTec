//package com.lh.wxmini.synch;
//
//import java.util.ArrayList;
//
//import com.iflytek.cloud.speech.SpeechError;
//import com.iflytek.cloud.speech.SpeechEvent;
//import com.iflytek.cloud.speech.SynthesizerListener;
//import com.lh.wxmini.utils.DebugLog;
//
//public class LSSynthListener implements SynthesizerListener
//{
//
//
//	@Override
//	public void onSpeakBegin() {
//	}
//
//	@Override
//	public void onBufferProgress(int progress, int beginPos, int endPos,
//			String info) {
//		DebugLog.Log("--onBufferProgress--progress:" + progress
//				+ ",beginPos:" + beginPos + ",endPos:" + endPos);
//	}
//
//	@Override
//	public void onSpeakPaused() {
//
//	}
//
//	@Override
//	public void onSpeakResumed() {
//
//	}
//
//	@Override
//	public void onSpeakProgress(int progress, int beginPos, int endPos) {
//		DebugLog.Log("onSpeakProgress enter progress:" + progress
//				+ ",beginPos:" + beginPos + ",endPos:" + endPos);
//
////		updateText( mText.substring( beginPos, endPos+1 ) );
//		
//		DebugLog.Log( "onSpeakProgress leave" );
//	}
//
//	@Override
//	public void onCompleted(SpeechError error) {
//		DebugLog.Log( "onCompleted enter" );
//		
////		String text = mText;
//		if (null != error){
//			DebugLog.Log("onCompleted Code：" + error.getErrorCode());
//			String text = error.getErrorDescription(true);
//			System.out.println("error = " + text);
//		}
//		
////		updateText( text );
//		
//		DebugLog.Log( "onCompleted leave" );
//	}
//
//
//	@Override
//	public void onEvent(int eventType, int arg1, int arg2, int arg3, Object obj1, Object obj2) {
//		if( SpeechEvent.EVENT_TTS_BUFFER == eventType ){
//			DebugLog.Log( "onEvent: type="+eventType
//					+", arg1="+arg1
//					+", arg2="+arg2
//					+", arg3="+arg3
//					+", obj2="+(String)obj2 );
//			ArrayList<?> bufs = null;
//			if( obj1 instanceof ArrayList<?> ){
//				bufs = (ArrayList<?>) obj1;
//			}else{
//				DebugLog.Log( "onEvent error obj1 is not ArrayList !" );
//			}//end of if-else instance of ArrayList
//			
//			if( null != bufs ){
//				for( final Object obj : bufs ){
//					if( obj instanceof byte[] ){
//						final byte[] buf = (byte[]) obj;
//						DebugLog.Log( "onEvent buf length: "+buf.length );
//					}else{
//						DebugLog.Log( "onEvent error element is not byte[] !" );
//					}
//				}//end of for
//			}//end of if bufs not null
//		}//end of if tts buffer event
//	}
//
//}
