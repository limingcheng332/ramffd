package com.mitch.Util;

import com.mitch.utils.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by limc on 2017/8/16.
 */
public class ClassUtil {
    private static final Logger logger = Logger.getLogger(ClassUtil.class);

    /**
     * 获取类加载器
     * @return
     */
    public static ClassLoader getClassloader(){
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 加载类
     *
     * @param className
     * @param isInitialized
     * @return
     */
    public static Class<?> loadClass(String className,boolean isInitialized){
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className,isInitialized,getClassloader());
        } catch (ClassNotFoundException e) {
            logger.error("加载类发生错误",e);
            throw new RuntimeException(e);
        }
        return clazz;
    }

    /**
     * 获取指定包下的类集合
     * @param packageName
     * @return
     */
    public static Set<Class<?>> getClassSet(String packageName){
        logger.info(String.format("基础包:[%s]",packageName));

        Set<Class<?>> classSet = new HashSet<Class<?>>();

        try {
            Enumeration<URL> urls = getClassloader().getResources(packageName.replace(".","/"));
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                logger.info(String.format("物理路径:[%s]",url));

                Assert.notNull(url,"url is null!");
                String protocol = url.getProtocol();
                if("file".equals(protocol)){
                    String path = url.getPath().replaceAll("%20"," ");
                    addClass(classSet,path,packageName);
                }else if("jar".equals(protocol)){
                    JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                    Assert.notNull(jarURLConnection,"jar url is null!");

                    JarFile jarFile = jarURLConnection.getJarFile();
                    Assert.notNull(jarFile,"jarfile is null!");

                    Enumeration<JarEntry> jarEntries = jarFile.entries();
                    while (jarEntries.hasMoreElements()){
                        JarEntry jarEntry = jarEntries.nextElement();
                        String jarEntryName = jarEntry.getName();
                        if(jarEntryName.endsWith(".class")){
                            String className = jarEntryName.substring(0,jarEntryName.lastIndexOf(".")).replaceAll("/",".");
                            doAddClass(classSet,className);
                        }
                    }
                }
            }
        } catch (IOException e) {
            logger.error("获取类集合失败...");
            throw new RuntimeException(e);
        }
        return classSet;
    }

    /**
     * 解析基础包下的class
     *
     * @param classSet
     * @param path
     * @param packageName
     */
    public static void addClass(Set<Class<?>> classSet,String path,String packageName){
        File[] files = new File(path).listFiles(new FileFilter(){
            @Override
            public boolean accept(File file) {
                return (file.isFile()&& file.getName().endsWith(".class")) || file.isDirectory();
            }
        });
        for (File file : files){
            String fileName = file.getName();
            if(file.isFile()){
                String className = fileName.substring(0,fileName.lastIndexOf("."));
                if(StringUtil.isNotEmpty(packageName)){
                    className = packageName + "." +className;
                }
                doAddClass(classSet,className);
            }else {
                String subPackagePath = fileName;
                if(StringUtil.isNotEmpty(path)){
                    subPackagePath = path + "/" +subPackagePath;
                }
                String subPackageName = fileName;
                if(StringUtil.isNotEmpty(packageName)){
                    subPackageName = packageName + "." +subPackageName;
                }
                addClass(classSet,subPackagePath,subPackageName);
            }
        }
    }

    private static void doAddClass(Set<Class<?>> classSet, String className) {
        Class<?> clas = loadClass(className,false);
        classSet.add(clas);
    }

    public static void main(String[] args) {
//        System.out.println(getClassSet("com.mitch"));

    }

}
