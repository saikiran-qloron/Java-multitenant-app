package com.project.multitenant.service;

import com.project.multitenant.Enities.SchemaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchemaService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String createSchema(SchemaDTO schemaDTO) throws IOException{

        String schemaName = schemaDTO.getName();
        System.out.println("schema service 31: " + schemaName);

        try {
//            // Load SQL script file from resources
            Resource resource = new PathMatchingResourcePatternResolver().getResource("classpath:create_schema.sql");

            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            List<String> sqlStatements = new ArrayList<>();
            StringBuilder statement = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty() && !line.trim().startsWith("--")) {
                    statement.append(line);
                    if (line.trim().endsWith(";")) {
                        sqlStatements.add(statement.toString());
                        statement.setLength(0);
                    }
                }
            }

            for (String sql : sqlStatements) {
                String replaceString = sql.replace("$schemaName", schemaName);
                jdbcTemplate.execute(replaceString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Schema" + schemaName + "created successfully.";
    }
}
