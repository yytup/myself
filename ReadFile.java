package com.xn.xiaoneng.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class ReadFile {

    public ReadFile() {
    }

    /**
     * 从指定的文件中读取文件中的数据
     * @param fileStation 文件地址
     * @return
     * @throws Exception
     */
    public static JSONObject getInfoByReadFile(String fileStation) throws Exception {
//        InputStream inputStream=null;
        try {
            ClassPathResource resource=new ClassPathResource(fileStation);
            String s = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONObject.parseObject(s);
            return jsonObject;
        } finally {
//            inputStream.close();
        }
    }


    /**
     * 从指定的文件中读取文件中的数据
     * @param fileStation 文件地址
     * @return
     * @throws Exception
     */
    public static JSONArray getJSONArrayInfoByReadFile(String fileStation) throws Exception {
        ClassPathResource resource = new ClassPathResource(fileStation);
        String s = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);
        JSONArray array = JSONArray.parseArray(s);
        return array;
    }

    /**
     * 从文件中按行读取数据
     *
     * @param path 文件路径
     * @return
     * @throws Exception
     */
    public static List<String> getFileData(String path) throws Exception {
        ClassPathResource resource = new ClassPathResource(path);
        List<String> fileData = IOUtils.readLines(resource.getInputStream(), StandardCharsets.UTF_8);
        return fileData;
    }
}
