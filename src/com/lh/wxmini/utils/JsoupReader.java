package com.lh.wxmini.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class JsoupReader {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient=HttpClients.createDefault(); //1、创建实例
        HttpGet httpGet=new HttpGet("https://mp.weixin.qq.com/s/J_zhAqVMKYMw4V0nQ_ItzA"); //2、创建实例
     
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 Safari/537.36 SE 2.X MetaSr 1.0");
         
        CloseableHttpResponse httpResponse=httpClient.execute(httpGet); //3、执行
        HttpEntity entity=httpResponse.getEntity(); //4、获取实体
        
        String content=EntityUtils.toString(entity, "utf-8"); //5、获取网页内容
        httpResponse.close();
        
        httpClient.close();
         
        Document doc=Jsoup.parse(content); // 解析网页 得到文档对象
//        System.out.println("纯文本内容：" + doc.text());  //可以获取全部文本
        Elements elements=doc.getElementsByTag("title"); // 获取tag是title的所有DOM元素
        Element element=elements.get(0); // 获取第1个元素
        String title=element.text(); // 返回元素的文本
        System.out.println("标题："+title);
        
        //======================
        Elements es = doc.getElementsByClass("rich_media_content ");  //rich_media_content 这个字段是固定的
        String m = es.text();
        System.out.println("这里才是真正的正文：" + m); //可以微信公众号正文文本
        //======================
        
    }
}