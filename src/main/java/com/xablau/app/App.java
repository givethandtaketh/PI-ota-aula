package com.xablau.app;

// import java.lang.Object;
import java.io.Reader;
import java.util.TreeMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.*;

import java.io.FileReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        TreeMap<Double, String> expetancy = new TreeMap<Double, String>(Collections.reverseOrder());

        String file = args[0];
        // System.out.println(file);
        Reader in = new FileReader(file);
        
        CSVParser CsvParser = new CSVParser(in, CSVFormat.EXCEL);
        List<CSVRecord> CsvRecords = CsvParser.getRecords();
 
        for (int i=1;i<CsvRecords.size();i++){
            CSVRecord csvRecord = CsvRecords.get(i);
            // System.out.println(csvRecord.get(2));
            Integer year = Integer.parseInt(csvRecord.get(2));
            if (year == 2020) {
                Double femaleExpectancy = Double.parseDouble(csvRecord.get(4));
                String country = csvRecord.get(0);
                // System.out.println(country + "->" + femaleExpectancy + "@ year " + year);
                expetancy.put(femaleExpectancy, country);
            }
        }

        for (Map.Entry<Double, String> entry: expetancy.entrySet()) {
            System.out.println("Country: " + entry.getValue() + ". Expectancy: " + entry.getKey());
        }
        CsvParser.close();
    }
}
