package com.ziziu.common;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by 小沙弥 on 2017/7/28.
 */
public class HttpUrlConnection {
    private static  String url_path=null;
    private static  HttpURLConnection httpURLConnection=null;
    private static  final String BOUNDARY=UUID.randomUUID().toString();
    private static  DataOutputStream os;


    private static void setUrl(String newUrl){
        url_path=newUrl;
    }

    /**
     * Get请求P，包含基本参数
     * @param url
     * @param param
     * @return
     * @throws IOException
     */
    public static String get(String url, Map<String,Object> param)throws IOException{
        setUrl(url+"?"+get_Param(param));   //设置url
        if (url_path==null||url_path==""){
            System.out.println("访问地址不能为空，请重新设置！");
            return null;
        }
        httpURLConnection=getHttpURLConnection();
        HttpURLConnectionConfig(false,true,false,"GET");
        httpURLConnection.connect();
        return respResult();

    }

    /**
     * ost请求包含基本的参数，不含文件参数
     * @param url
     * @param textParams
     * @return
     */
    public static String post(String url, Map<String,Object> textParams){
        String responseResult= null;
        BufferedReader bufferedReader=null;
        try {
            setUrl(url);   //设置url
            if (url_path==null||url_path==""){
                System.out.println("访问地址不能为空，请重新设置！");
                return null;
            }
            httpURLConnection=getHttpURLConnection();
            HttpURLConnectionConfig(true,true,false,"POST");
            post_Param(textParams);
            printResponseHeader(httpURLConnection);   //展示一下头信息
            responseResult=respResult();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpURLConnection.disconnect();
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseResult;
    }

    /**
     * Post请求，包含文件参数
     * @param url
     * @param textParams
     * @param fileparams
     * @return
     */
    public static String post(String url, Map<String,Object> textParams,Map<String, File> fileparams){
        String responseResult= null;
        BufferedReader bufferedReader=null;
        try {
            setUrl(url);   //设置url
            if (url_path==null||url_path==""){
                System.out.println("访问地址不能为空，请重新设置！");
                return null;
            }
            httpURLConnection=getHttpURLConnection();
            HttpURLConnectionConfig(true,true,false,"POST");
            post_Param(textParams,fileparams);
            printResponseHeader(httpURLConnection);   //展示一下头信息
            responseResult=respResult();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpURLConnection.disconnect();
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseResult;
    }

    private static HttpURLConnection getHttpURLConnection(){
        HttpURLConnection httpURLConnection = null;
        try {
            URL url=new URL(url_path);
            URLConnection urlConnection=url.openConnection();     // 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类的子类HttpURLConnection,故此处最好将其转化为HttpURLConnection类型的对象,以便用到HttpURLConnection更多的API.如下:
            httpURLConnection = (HttpURLConnection) urlConnection;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return httpURLConnection;
    }
    private static void HttpURLConnectionConfig(boolean doOutPut,boolean doInPut,boolean useCache,String method) throws ProtocolException{
        httpURLConnection.setDoOutput(doOutPut); //设置是否向httpUrlConnection输出，post请求，参数要放在http正文内，因此需要设为true, 默认情况下是false;
        httpURLConnection.setDoInput(doInPut);   // 设置是否从httpUrlConnection读入，默认情况下是true;
        httpURLConnection.setUseCaches(useCache);  // Post 请求不能使用缓存
        httpURLConnection.setRequestMethod(method);    //请求的方法：默认是GET请求
        //httpURLConnection.setRequestProperty("Accept-Charset",  "UTF-8");
        //httpURLConnection.setRequestProperty("Content-type","application/x-www-form-urlencoded;charset=UTF-8");  //解决乱码问题
        //httpURLConnection.setRequestProperty("Content-type", "application/x-java-serialized-object");   // 设定传送的内容类型是可序列化的java对象(如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛
        httpURLConnection.setRequestProperty("connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Charsert", "UTF-8");
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" +BOUNDARY); // 设置内容类型：表单提交
        httpURLConnection.setConnectTimeout(60000);    //连接 1 min  超时
        httpURLConnection.setReadTimeout(60000);     //读取 1 min  超时
    }
    private static String get_Param(Map<String , Object> map){
        StringBuffer param=new StringBuffer();
        boolean flag=false;
        for (Map.Entry<String,Object> entry:map.entrySet() ){
            if (flag){
                param.append("&");
            }else{
                flag=true;
            }
            param.append(entry.getKey()+"="+entry.getValue());
        }
        return param.toString();
    }
    private static void post_Param(Map<String , Object> textParams,Map<String, File> fileParams){
        try {
            os=new DataOutputStream(httpURLConnection.getOutputStream());
            writeFileParams(fileParams);
            writeStringParams(textParams);
            paramsEnd();
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void post_Param(Map<String , Object> textParams){
        try {
            os=new DataOutputStream(httpURLConnection.getOutputStream());
            writeStringParams(textParams);
            paramsEnd();
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //添加普通字符串数据
    private static void writeStringParams(Map<String,Object> textParams) throws Exception {
        Set<String> keySet = textParams.keySet();
        for (Iterator<String> it = keySet.iterator(); it.hasNext();) {
            String name = it.next();
            String value = textParams.get(name).toString();
            StringBuilder sb= new StringBuilder();
            sb.append("--" + BOUNDARY + "\r\n");
            sb.append("Content-Disposition: form-data; name=\""+name+"\"\r\n");
            sb.append("\r\n");
            sb.append(value);
            sb.append("\r\n");
            System.out.print(sb.toString());     //展示请求报文
            os.write(sb.toString().getBytes("UTF-8"));
        }
    }
    //添加文件数据
    private static void writeFileParams(Map<String, File> fileParams) throws Exception {
        Set<String> keySet = fileParams.keySet();
        for (Iterator<String> it = keySet.iterator(); it.hasNext();) {
            String name = it.next();
            File value = fileParams.get(name);
            StringBuilder sb=new StringBuilder();
            sb.append("--" + BOUNDARY + "\r\n");
            sb.append("Content-Disposition: form-data; name=\"" + name + "\"; filename=\"" + value.getName()+"\"");
            sb.append("\r\n");
            sb.append("Content-Type: " + getContentType(value) + "\r\n");
            sb.append("\r\n");
            os.write(sb.toString().getBytes("UTF-8"));
            get_Bytes(value);
            os.writeBytes("\r\n");
            System.out.print(sb.toString());     //展示请求报文

        }
    }
    //获取文件的上传类型，图片格式为image/png,image/jpg等。非图片为application/octet-stream
    private static String getContentType(File f) throws Exception {
        ImageInputStream imagein = ImageIO.createImageInputStream(f);
        if (imagein == null) {
            return "application/octet-stream";
        }
        Iterator<ImageReader> it = ImageIO.getImageReaders(imagein);
        if (!it.hasNext()) {
            imagein.close();
            return "application/octet-stream";
        }
        imagein.close();
        return "image/" + it.next().getFormatName().toLowerCase();//将FormatName返回的值转换成小写，默认为大写

    }
    //把文件转换成字节数组
    private static void get_Bytes(File f) throws Exception {
        FileInputStream in = new FileInputStream(f);
        byte[] b = new byte[1024];
        int size=0;
        while ((size=in.read(b))!= -1) {
            os.write(b, 0, size);
        }
        in.close();
    }
    //添加结尾数据  //getContentType()返回内容格式
    private static void paramsEnd() throws Exception {
        os.writeBytes("--" + BOUNDARY + "--" + "\r\n");
        os.writeBytes("\r\n");
    }
    //启动发送信息请求，判断请求是否成功，解析请求返回的数据
    private static String respResult()throws IOException{
        int responseCode=httpURLConnection.getResponseCode();
        if (responseCode != 200) {
            return "responseCode:"+responseCode;
        }

        // 定义BufferedReader输入流来读取URL的ResponseData
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"UTF-8"));
        String line;
        StringBuffer responseResult=new StringBuffer();
        while ((line = bufferedReader.readLine()) != null) {
            responseResult.append(line);
        }
        return responseResult.toString();
    }


    /**
     * 显示头信息---供我自己差错或者找问题
     * @param http
     * @throws UnsupportedEncodingException
     */
    private static void printResponseHeader(HttpURLConnection http) throws UnsupportedEncodingException {
        Map<String, String> header = getHttpResponseHeader(http);
        for (Map.Entry<String, String> entry : header.entrySet()) {
            String key = entry.getKey() != null ? entry.getKey() + ":" : "";
            System.out.println(key + entry.getValue());
        }
    }

    private static Map<String, String> getHttpResponseHeader(
            HttpURLConnection http) throws UnsupportedEncodingException {
        Map<String, String> header = new LinkedHashMap<String, String>();
        for (int i = 0;; i++) {
            String mine = http.getHeaderField(i);
            if (mine == null)
                break;
            header.put(http.getHeaderFieldKey(i), mine);
        }
        return header;
    }

    public static void main(String[] args) {
        Map<String,Object> user=new HashMap<String,Object>();
        user.put("username",(Object) "xyz");
        user.put("password",(Object) "123");
        String s = post("http://localhost:8080/loginProcess",user);
        System.out.println(s);
    }
}
