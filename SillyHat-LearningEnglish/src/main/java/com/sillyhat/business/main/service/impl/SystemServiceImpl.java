package com.sillyhat.business.main.service.impl;

import com.sillyhat.business.main.mapper.SystemMapper;
import com.sillyhat.business.main.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.Resource;

/**
 * SystemServiceImpl
 *
 * @author 徐士宽
 * @date 2017/3/13 17:00
 */
@Service
public class SystemServiceImpl implements SystemService {

    private final Logger logger = LoggerFactory.getLogger(SystemServiceImpl.class);

    @Value("${file.database.list}")
    private String fileNameDatabaseSrc;

    @Resource
    private SystemMapper systemMapper;


    private String readSqlFile(String fileName) {
        BufferedReader reader;
        StringBuffer resultSql = new StringBuffer();
        try {
            String line;
            reader = new BufferedReader(new InputStreamReader(SystemServiceImpl.class.getClassLoader().getResourceAsStream("sql/" + fileName), "UTF-8"));
            while ((line = reader.readLine()) != null) {
                logger.info(line);
                resultSql.append(line);
            }
            reader.close();
        } catch (IOException e) {
            logger.error("读取sql文件发生异常。",e);
        }
        return resultSql.toString();
    }

    public void initSystemTable() {
        String [] fileNameDatabaseArray = fileNameDatabaseSrc.split(",");
        for (String fileNameDatabase : fileNameDatabaseArray) {
            logger.info(fileNameDatabaseSrc);
            String sql = readSqlFile(fileNameDatabase + ".sql");
            logger.info("-------sql--------");
            logger.info(sql);
            systemMapper.createdTable(sql);
        }
    }
}
