package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StateCensusAnalyser {

    public  int CSVStateCensus(String csvFilepath) throws CensusAnalyserException {
        int numOfRecords = 0;
        try {
            FileReader reader = new FileReader(csvFilepath);
            CSVReader csvReader = new CSVReader(reader);
            String[] line;
            int skipHeader = 0;
            do {
                if (!((line = csvReader.readNext()) != null))
                    break;
                if (skipHeader == 0) {
                    skipHeader++;
                    continue;
                }
                for (String token : line) {
                    System.out.print(token);
                }
                System.out.println();
                numOfRecords++;
            } while (true);
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),CensusAnalyserException.ExceptionType.STATE_CENSUS_FILE_PATH_PROBLEM);
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        return numOfRecords;
    }
}
