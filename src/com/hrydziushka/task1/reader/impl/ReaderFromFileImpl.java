package com.hrydziushka.task1.reader.impl;

import com.hrydziushka.task1.reader.ReaderFromFile;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFromFileImpl implements ReaderFromFile {
    static Logger logger = LogManager.getLogger();

    @Override
    public List<String> readLinesFromFile(String filePath) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String tmp;
            
            while ((tmp = reader.readLine()) != null) {
                stringList.add(tmp);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.ERROR, "File not Found", e);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Input or output error", e);
        }

        return stringList;
    }
}
