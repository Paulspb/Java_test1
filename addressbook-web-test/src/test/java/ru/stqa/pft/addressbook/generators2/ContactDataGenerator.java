package ru.stqa.pft.addressbook.generators2;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.NameFirstMiddle;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by khomep on 10-Jul-16.
 */
public class ContactDataGenerator {

    //private static Properties properties;
    @Parameter(names = "-c", description =  "Contact = count")
    public int count;

    @Parameter(names = "-f", description =  "target file")
    public String file;

    @Parameter(names = "-d", description =  "Data format")
    public String format;


    public static void main(String[] args) throws IOException {

        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            //output of
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<NameFirstMiddle> contacts = generateContacts(count);

        if (format.equals("csv")) {
            saveAsCsv(contacts,new File(file));
        } else  if (format.equals("xml")) {
                //keep data on file
                saveAsXml(contacts, new File(file));
            } else {
                System.out.println("Unrecognized format  :" + format);
            }

    }

    private void saveAsXml(List<NameFirstMiddle> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(NameFirstMiddle.class);
        String xml = xstream.toXML(contacts);
        try (Writer writer = new FileWriter(file)){
            writer.write(xml);
        }         //-no needs with Try- writer.close();
    }

    private static void saveAsCsv(List<NameFirstMiddle> contacts, File file) throws IOException {
        System.out.println("    working directory: " +new File(".").getAbsolutePath());
        try (Writer writer = new FileWriter(file)){
            for (NameFirstMiddle contact :contacts) {
                writer.write(String.format("%s;%s;%s\n",
                        contact.getFirstname(),contact.getLastName(),contact.getGroup()));
            }         //-no needs with
        }
    }

    private static List<NameFirstMiddle> generateContacts(int count) {
        //properties    = new Properties();
        List<NameFirstMiddle> contacts = new ArrayList<NameFirstMiddle>();
        //String name1 = properties.getProperty("web.contactFirstName");
        for (int i = 0; i < count; i++) {

            contacts.add(new NameFirstMiddle().withFirstname(
                     String.format("Alex-generator%s",i)).
                    withLastname(String.format("lastName %s",i)).
                    withGroup("test134"));

            //contacts.add(new NameFirstMiddle().withFirstname(String.format("Alex-generator%s",i)).
            //        withLastname(String.format("lastName %s",i)).
            //        withGroup("test134"));
                    //withGroup(String.format("test134 %s",i)));
        }

        return contacts;
    }
}
