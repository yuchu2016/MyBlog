package com.yuchu.service.Impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SensitiveService implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(SensitiveService.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        try{
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("sensitiveWords.txt");
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            //System.out.println("1234");
            String line;
            while ((line = bufferedReader.readLine()) != null){
                addWords(line);
            }
        } catch (Exception e){
            logger.error("载入敏感词文件出错" + e.getMessage());
            //System.out.println("123");
        }
    }

    private boolean isSymbol(Character c){
        int ch = (int) c;
        return !CharUtils.isAsciiAlphanumeric(c) && (ch < 0x2e80 || ch > 0x9fff);
    }

    // 向字典树中插入敏感词
    private void addWords(String lineTxt){
        TrieNode tmp = rootNode;
        for (int i = 0; i < lineTxt.length(); i++){
            Character c = lineTxt.charAt(i);

            if (isSymbol(c))
                continue;

            TrieNode node = tmp.getSubNodes(c);
            if (node == null){
                node = new TrieNode();
                tmp.setSubNodes(c, node);
            }

            tmp = node;

            if (i == lineTxt.length() - 1)
                tmp.setKeyWordEnd(true);
        }
    }

    // filter
    public String filter(String line){
        if (StringUtils.isBlank(line))
            return line;

        String replacement = "***";
        StringBuilder sb = new StringBuilder();

        TrieNode tmp = rootNode;
        int begin = 0;
        int position = 0;

        while (position < line.length() || begin < line.length()){
            if (position >= line.length()){
                sb.append(line.charAt(begin));
                begin = begin + 1;
                position = begin;
                tmp = rootNode;
                continue;
            }

            Character c = line.charAt(position);
            if (isSymbol(c)){
                if (tmp == rootNode){
                    sb.append(c);
                    begin++;
                }

                position++;
                continue;
            }

            tmp = tmp.getSubNodes(c);
            if (tmp == null){
                sb.append(line.charAt(begin));
                position = begin + 1;
                begin = position;
                tmp = rootNode;
            } else if (tmp.isKeyWordEnd()){
                sb.append(replacement);
                position = position + 1;
                begin = position;
                tmp = rootNode;
            } else{
                position ++;
            }
        }

// sb.append(line.substring(begin));
        return sb.toString();
    }

    // 字典树
    private class TrieNode {
        private boolean end = false;
        private Map<Character, TrieNode> subNodes = new HashMap<>();

        public TrieNode getSubNodes(Character c){
            return subNodes.get(c);
        }

        public void setSubNodes(Character c, TrieNode node){
            subNodes.put(c, node);
        }

        public void setKeyWordEnd(boolean end){
            this.end = end;
        }

        public boolean isKeyWordEnd(){
            return end;
        }
    }

    private TrieNode rootNode = new TrieNode();

   /* public static void main(String [] argv) throws Exception{
        SensitiveService sensitiveService = new SensitiveService();
        sensitiveService.addWords("包小姐");
        sensitiveService.addWords("小三");
        sensitiveService.addWords("色情");
        sensitiveService.addWords("长风剑客");
// sensitiveService.addWords("剑三");
        sensitiveService.addWords("风剑");
    	SensitiveService sensitiveService = new SensitiveService();
    	sensitiveService.afterPropertiesSet();
        System.out.println(sensitiveService.filter("长风剑三"));
        System.out.println(sensitiveService.filter("长风剑"));
        System.out.println(sensitiveService.filter("居然包小三"));
        System.out.println(sensitiveService.filter("你好色情"));
        System.out.println(sensitiveService.filter("你好色情"));
    }*/
    @Test
    public void test() throws Exception{
    	SensitiveService sensitiveService = new SensitiveService();
    	sensitiveService.afterPropertiesSet();
        System.out.println(sensitiveService.filter("长风剑三"));
        System.out.println(sensitiveService.filter("长风剑"));
        System.out.println(sensitiveService.filter("居然包小三"));
        System.out.println(sensitiveService.filter("你好色情"));

        System.out.println(sensitiveService.filter("东楼123"));
    }

}
