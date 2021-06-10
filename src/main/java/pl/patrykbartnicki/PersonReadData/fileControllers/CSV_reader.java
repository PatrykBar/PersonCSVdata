package pl.patrykbartnicki.PersonReadData.fileControllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.patrykbartnicki.PersonReadData.models.Person;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSV_reader {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSV_reader.class.getName());

    private String fileName = "persons.csv";

    private String line = "";
    private String splitBy = ";";

    private List<Person> peopleList = new ArrayList<>();

    public List<Person> getPeopleList(){
        LOGGER.info("CSV file read starting");
        readCSV_File();
        LOGGER.info("CSV file read ending");
        return peopleList;
    }

    private void readCSV_File(){
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while ((line = bufferedReader.readLine()) != null){
                String[] peopleData = line.split(splitBy);
                Person person = new Person();
                if (peopleData.length==3){
//                    System.out.println(new String((peopleData[0] + " " + peopleData[1] + " " + peopleData[2]).getBytes(), StandardCharsets.UTF_8));
                    person.setName(checkString(peopleData[0]));// add pattern for name and surname to estimate correct value
                    person.setSurname(checkString(peopleData[1]));
                    person.setDateOfBirth(peopleData[2]);
                    peopleList.add(person);
                }else if (peopleData.length==4){
//                    System.out.println(new String((peopleData[0] + " " + peopleData[1] + " " + peopleData[2] + " " + peopleData[3]).getBytes(), StandardCharsets.UTF_8));
                    person.setName(checkString(peopleData[0]));
                    person.setSurname(checkString(peopleData[1]));
                    person.setDateOfBirth(peopleData[2]);
                    person.setPhoneNumber(checkNumber(peopleData[3])); // add pattern for 9 numbers
                    peopleList.add(person);
                }
            }
            peopleList.remove(0);

//            peopleList.forEach(x-> System.out.println(new String(x.toString().getBytes(), StandardCharsets.UTF_8)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String checkString(String stringWithChar){
        String correctString = "";

        if (stringWithChar.substring(0,1).equals("\"") &&
                stringWithChar.substring(stringWithChar.length()-1).equals("\"")){
            correctString = stringWithChar.substring(1,stringWithChar.length()-2).trim();
            correctString = correctString.substring(0,1).toUpperCase() + correctString.substring(1);
        }else {
            correctString = stringWithChar.trim();
            correctString = correctString.substring(0,1).toUpperCase() + correctString.substring(1);
        }

        return correctString;
    }

    private int checkNumber(String number){
        int correctNumber = 0;

        Pattern p = Pattern.compile("\\d{9}");
        Matcher m = p.matcher(number.trim());
        boolean b = m.matches();

        if (b==true){
            correctNumber = Integer.parseInt(number.trim());
        }else {
            LOGGER.warn("Incorrect number: " + number);
            return 0;
        }

        for (int i=0; i<peopleList.size(); i++){
            if (peopleList.get(i).getPhoneNumber()==correctNumber){
                LOGGER.warn("Number already exist: " + peopleList.get(i).getPhoneNumber());
                correctNumber = 0;
                break;
            }
        }

        return correctNumber;
    }

}
