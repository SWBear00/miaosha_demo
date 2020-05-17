package ioDemo;
import org.junit.Test;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class IoDemo {

    /**
     * 创建文件
     */
    @Test
    public void ioTest1(){
        String path="D:"+File.separator+"io.txt";
        System.out.println(path);

        //获取一个文件信息
        File file = new File(path);
        //判断文件是否存在
        if (file.exists()){
           file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件输入输出流：FileInputStream/FileOutputStream
     */

    @Test
    public void ioTest2(){
        //写入
        //创建文件对象
        String path="D:"+File.separator+"io.txt";
        File file = new File(path);
        //创建字节形文件输出流
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream = new FileOutputStream(file);
            String s="金佛阿胶覅偶尔佛诶哦非欧烦恼";
            byte[] by = s.getBytes();
            fileOutputStream.write(by);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //读取
        FileInputStream fileInputStream=null;
        try {
           fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len=fileInputStream.read(bytes);
            System.out.println("io.txt文件中信息为："+new String(bytes,0,len));
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流文件读取：FileReader、FileWriter
     */
    @Test
    public void ioTest(){
        //获取文件对象
        String path="D:"+File.separator+"io.txt";
        File file = new File(path);

        if (file.exists()){
            System.out.println("原文件名"+file.getName());
            System.out.println("原文件大小"+file.length());
            file.delete();
        }
        //写入文件
        //创建字符型文件输出流
        FileWriter fileWriter=null;
        try {
            fileWriter = new FileWriter(file);
            String count="你从哪里来，要到那里去.";
            fileWriter.write(count);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取文件
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            char[] chars = new char[1024];
            int len=fileReader.read(chars);
            System.out.println("io.txt文件内容为："+new String(chars,0,len));
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
         * 带缓存的输入输出流(字节流)：BufferedInputStream/BufferedOutputStream
         */
        @Test
        public void ioTest4(){
            //获取文件对象
            String path="D:"+File.separator+"io.txt";
            File file = new File(path);
            if (file.exists()){
                file.delete();
            }
            //缓存写入文件
            /**
             * 字符--BufferedOutputStream--outputStream--目标文件
             */
            FileOutputStream fileOutputStream=null;
            BufferedOutputStream bufferedOutputStream=null;
            try {
                fileOutputStream=new FileOutputStream(file);//获取文件流
                bufferedOutputStream=new BufferedOutputStream(fileOutputStream);//将文件流加入到缓存中
                String count="往事依旧不回头往事依旧不回头往事依旧不回头往事依旧不回头往事依旧不回头往事依旧不回头往事依旧不回头往事依旧不回头";
                bufferedOutputStream.write(count.getBytes());
                bufferedOutputStream.flush();//刷新缓存区
                fileOutputStream.close();
                bufferedOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        /**
         * 文件--InputStream--BufferedInputStream--目的地
         */
        //缓存读取文件
        FileInputStream fileInputStream=null;
        BufferedInputStream bufferedInputStream=null;
        try {
            fileInputStream=new FileInputStream(file);
            bufferedInputStream=new BufferedInputStream(fileInputStream);
            byte[] chars = new byte[1024];
            int len=bufferedInputStream.read(chars);
            System.out.println("io文件内容为："+new String(chars,0,len));
            fileInputStream.close();
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 带缓存的输入输出流(字符流)：BufferedWriter/BufferedRider
     */
    @Test
    public  void ioTest5(){
        String count[]={"方头落色扣01;","方头落色扣01;","方头落色扣01;"};
        String path="D:"+File.separator+"io.txt";
        File file = new File(path);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //写入文件
        /**
         * 字符--BufferWriter--OutputStreamWriter--OutputStream--文件
         */
        FileWriter fileWriter=null;
        BufferedWriter bufferedWriter=null;
        try {
            fileWriter=new FileWriter(file);
            bufferedWriter=new BufferedWriter(fileWriter);
            for (int i = 0; i <count.length ; i++) {
                bufferedWriter.write(count[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取文件信息
        FileReader fileReader=null;
        BufferedReader bufferedReader=null;
        try {
            fileReader = new FileReader(file);
            bufferedReader=new BufferedReader(fileReader);
            String s=null;
            int i=0;
            while((s=bufferedReader.readLine())!=null){
                i++;
                System.out.println("第"+i+"行数据"+s);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据输入输出流：DataInputStream/DataOutputStream
     */
    @Test
    public void ioTest6(){
        //创建文件对象
        String path="D:"+File.separator+"io.txt";
        File file = new File(path);

        if (file.exists()){
            file.delete();
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建文件输出流和数据输出流
        DataOutputStream dataOutputStream=null;
        FileOutputStream fileOutputStream=null;

        try {
            fileOutputStream = new FileOutputStream(file);
            dataOutputStream=new DataOutputStream(fileOutputStream);
            dataOutputStream.writeUTF("使用WriteUTF()方法写入数据;");
            dataOutputStream.writeBytes("使用WriteBytes()方法写入;");
            dataOutputStream.writeChars("使用writeChars()方法写入;");
            fileOutputStream.close();
            dataOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //数据读取
        FileInputStream fileInputStream=null;
        DataInputStream dataInputStream=null;

        try {
            fileInputStream=new FileInputStream(file);
            dataInputStream=new DataInputStream(fileInputStream);
            System.out.println(dataInputStream.readUTF());
            fileInputStream.close();
            dataInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * zip文件压缩
     * 步骤：1、创建压缩文件流对象
     *      2、循环遍历需要压缩的文件
     *
     *
     *
     * */
        @Test
    public void ioTest7(){

            IoDemo ioDemo = new IoDemo();
            try {
                ioDemo.zip("E:/hello.zip",new File("E:/hello"));
                System.out.println("压缩完成");
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


        private void zip(String zipFileName,File inputFile) throws Exception {
            //创建zipOutputStream类对象
            ZipOutputStream zipOutputStream=new ZipOutputStream(new FileOutputStream(zipFileName));
            //调用方法
            zip(zipOutputStream,inputFile,"");
            System.out.println("压缩中。。。");
            zipOutputStream.close();
        }

        //方法重载
    private void zip(ZipOutputStream zipOutputStream, File inputFile, String base) throws IOException {
    //测试抽象路径名表示的文件是否为一个目录
        if (inputFile.isDirectory()){
            File[] files = inputFile.listFiles();//获取文件路径数组
            if (base.length()!=0){
                zipOutputStream.putNextEntry(new ZipEntry(base+File.separator));//写入此目录的entry
            }
            //循环遍历数组中的文件
            for (int i = 0; i < files.length; i++) {
                zip(zipOutputStream,files[i],base+files[i]);
            }
        }else{
            zipOutputStream.putNextEntry(new ZipEntry(base));//创建新的进入点
            //创建FileInputStream对象
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            int b;
            System.out.println(base);
            while((b=fileInputStream.read())!=-1){
                zipOutputStream.write(b);//将字节写入当前Zip条目
            }
            fileInputStream.close();
        }
    }

    /**
     * zip解压压缩文件
     */
    @Test
    public void ioTest8(){
        //获取当前压缩文件
        File file = new File("E:"+File.separator+"AutoUpdate.zip");
        System.out.println(file.getPath());
        ZipInputStream zipInputStream;//创建zipInputStream对象

        try {
            //创建压缩文件对象
            ZipFile zipFile = new ZipFile(file);
            //实例化对象，指明要进行解压的文件
            zipInputStream=new ZipInputStream(new FileInputStream(file));
            //跳过根目录，获取下一个zipEntry
            ZipEntry entry = null;
            //如果entry不为空，并不在同一目录下
            while(((entry=zipInputStream.getNextEntry())!=null)&&(!entry.isDirectory())){
                //解压到的文件下
                File tmp = new File("D:"+File.separator+entry.getName());
                if (!tmp.exists()){//如果文件不存在
                    tmp.getParentFile().mkdirs();//创建文件夹父类文件的路径
                    OutputStream out = new FileOutputStream(tmp);//将文件目录中的文件放入输出流
                    //用输入流读取压缩文件中制定目录中的文件
                    InputStream inputStream = zipFile.getInputStream(entry);
                   //创建临时变量
                   int count=0;
                   while ((count=inputStream.read())!=-1){
                       out.write(count);//输入流写入
                   }
                   //关闭输入流
                    out.close();
                   inputStream.close();
                }
                //关闭当前entry
                zipInputStream.closeEntry();
                System.out.println(entry.getName()+"解压成功");
            }
            zipInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
