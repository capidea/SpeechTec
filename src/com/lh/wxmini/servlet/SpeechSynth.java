package com.lh.wxmini.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizeToUriListener;

@SuppressWarnings("serial")
public class SpeechSynth extends HttpServlet {
	private final static String DEFAULT_DECODE = "UTF-8";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
	{
		System.out.println("aaaaaaaaaaaaaaaa");
	}


	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		request.setCharacterEncoding(DEFAULT_DECODE);//解决乱码
        String content=getDecodeParameter(request, "content");
        System.out.println("request content = " + content);
        String id = request.getSession().toString();
        response.setHeader("Content-Type", "audio/mpeg");
        
        //换成你在讯飞申请的APPID
        SpeechUtility.createUtility("appid=5a5ef0f2");

        //合成监听器
        SynthesizeToUriListener listener = VoiceUtils.getSynthesize();
        String srcFile=VoiceUtils.getFileName(id + "_tts.pcm");
        VoiceUtils.delDone(srcFile);

        //1.创建SpeechSynthesizer对象
        SpeechSynthesizer mTts= SpeechSynthesizer.createSynthesizer( );
        //2.合成参数设置，详见《MSC Reference Manual》SpeechSynthesizer 类
        mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");//设置发音人
        mTts.setParameter(SpeechConstant.SPEED, "50");//设置语速，范围0~100
        mTts.setParameter(SpeechConstant.PITCH, "50");//设置语调，范围0~100
        mTts.setParameter(SpeechConstant.VOLUME, "50");//设置音量，范围0~100

        //3.开始合成
        //设置合成音频保存位置（可自定义保存位置），默认保存在“./tts_test.pcm”
        mTts.synthesizeToUri(content,srcFile ,listener);

        boolean isDone = isDone(srcFile);
        if(isDone)
        {
        	Long time = Calendar.getInstance().getTimeInMillis();
        	String dstName = id + time;
        	sayPlay(srcFile, dstName);
        }
    }


	private boolean isDone(String fileName)
	{
		//设置最长时间
        int timeOut=30;
        int star=0;
        boolean isDone = false;
        //校验文件是否生成
        while(!(isDone =VoiceUtils.checkDone(fileName))){
            try {           
                Thread.sleep(1000);
                star++;             
                if(star>timeOut){
                    throw new Exception("合成超过"+timeOut+"秒！");
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            } 
        }
        return isDone;
	}


	/**
	 * 获取编码后参数值
	 * @param request
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private String getDecodeParameter(HttpServletRequest request, String param)
			throws UnsupportedEncodingException
	{
		return URLDecoder.decode(request.getParameter(param),DEFAULT_DECODE);
	}
    /**
     * 将音频内容输出到请求中
     * 
     * @param inName
     * @param request
     * @param response
     */
    private  void sayPlay (String inName, String outName)
    {  //输出 wav IO流
         try{
            
             File file = new File(inName);
             int len_l = (int) file.length();
             byte[] buf = new byte[2048];
             FileInputStream fis = new FileInputStream(file);
//             OutputStream out = response.getOutputStream();
            File outFile = new File(VoiceUtils.getFileName(outName + "_voice.wav"));
            outFile.getName();
             OutputStream out = new FileOutputStream(outFile);
             //写入WAV文件头信息
             out.write(VoiceUtils.getWAVHeader(len_l,8000,2,16));
             len_l = fis.read(buf);
             while (len_l != -1) {
                 out.write(buf, 0, len_l);
                len_l = fis.read(buf);
             }
             out.flush();
             out.close();
             fis.close();
             //删除文件和清除队列信息
             VoiceUtils.delDone(inName);
             file.delete();
         }catch (Exception e){
             System.out.println(e);
         }     

    }

}
