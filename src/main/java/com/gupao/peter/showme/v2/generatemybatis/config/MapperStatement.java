package com.gupao.peter.showme.v2.generatemybatis.config;

import com.gupao.peter.showme.v2.generatemybatis.annotations.Select;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class MapperStatement {

    private String scanPath;

    private Map<String, MapperMethod> mapperMethodMap = new HashMap<>();

    public MapperStatement(String scanPath) {
        this.scanPath = scanPath;
        buildMapper(scanPath);
    }

    private void buildMapper(String scanPath) {
        try {
            List<Class> classList = getClassByPackageName(scanPath);
//            Class clazz = Class.forName(scanPath);
            for (Class clazz : classList) {
                Method[] methods = clazz.getMethods();
                if (methods != null) {
                    for (Method method : methods) {
                        Annotation[] annotations = method.getAnnotations();
                        if (annotations != null) {
                            Select select = null;
                            for (Annotation annotation : annotations) {
                                if (annotation instanceof Select) {
                                    select = (Select) annotation;
                                    mapperMethodMap.put(method.getDeclaringClass().getName() + "." + method.getName(), new MapperMethod(method.getReturnType(), select.value()));
                                }
                            }
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Class> getClassByPackageName(String path) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String packagePath = path.replace(".", "/");
        Enumeration<URL> urls = classLoader.getResources(packagePath);
        List<File> files = new ArrayList<>();
        while (urls.hasMoreElements()) {
            URL resource = urls.nextElement();
            files.add(new File(resource.getFile()));
        }
        List<Class> classes = new ArrayList<>();
        for (File directory : files) {
            classes.addAll(findClasss(directory, path));
        }
        return classes;
    }

    private Collection<? extends Class> findClasss(File directory, String path) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        final String classSuffix = ".class";
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasss(file, path + "." + file.getName()));
            } else if (file.getName().endsWith(classSuffix)) {
                classes.add(Class.forName(path + "." + file.getName().substring(0, file.getName().length() - classSuffix.length())));
            }
        }
        return classes;
    }

    public MapperMethod getMapperMethod(String id) {
        return mapperMethodMap.get(id);
    }

}
