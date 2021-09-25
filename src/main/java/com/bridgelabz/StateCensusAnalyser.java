package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StateCensusAnalyser {

    public  int CSVStateCensus(String csvFilepath) throws IOException, CsvValidationException {
        int numOfRecords = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilepath));
            CSVReader csvReader = new CSVReader(reader);
            String[] line;
            int skipHeader = 0;
            while (true) {
                if (!((line = csvReader.readNext()) != null)) break;
                if (skipHeader == 0) {
                    skipHeader++;
                    continue;
                }
                for (String token : line) {
                    System.out.print(token);
                }
                System.out.println();
                numOfRecords++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return numOfRecords;
    }
}
