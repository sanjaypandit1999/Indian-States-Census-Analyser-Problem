package com.bridgelabz;

import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StateCensusAnalyser {

    public static int CSVStateCensus(String csvFilepath) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get(csvFilepath));
        CSVReader csvReader = new CSVReader(reader);
        String[] line;
        int skipHeader = 0;
        int numOfRecords = 0;
        while ((line = csvReader.readNext()) != null) {
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
        return numOfRecords;
    }
}
