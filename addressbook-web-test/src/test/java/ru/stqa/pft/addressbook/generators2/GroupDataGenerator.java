package ru.stqa.pft.addressbook.generators2;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by khomep on 10-Jul-16.
 */
public class GroupDataGenerator {

    // this is jcommander
    @Parameter(names = "-c", description =  "Group = count")
    public int count;

    @Parameter(names = "-f", description =  "Target file")
    //jcommander not support of File-type
    public String file;

            //lesson 6.6
    @Parameter(names = "-d", description =  "Data format")
    //jcommander not support of File-type
    public String format;


    // zapuskaemui class so definition is:
    public static void main(String[] args) throws IOException {

        GroupDataGenerator generator = new GroupDataGenerator();
            // first data of generator, next input
        //new JCommander(generator,args);
        JCommander jCommander = new JCommander(generator);
            //for avoid exception, + try/catch
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
                //output of
            jCommander.usage();
            return;
        }
        generator.run();
            // input group number & path to file
                //int count = Integer.parseInt(args[0]);
                //File file = new File(args[1]);

    }

    private void run() throws IOException {
        List<GroupData> groups = generateGroups(count);
        // lesson 6.6
        if (format.equals("csv")) {
            saveAsScv(groups, new File(file));
        } else  if (format.equals("xml")) {
                //keep data on file
                saveAsXml(groups, new File(file));
            } else {
                System.out.println("Unrecognized format  :" + format);
            }
    }

    //private static void save(List<GroupData> groups, File file) throws IOException {

    private void saveAsXml(List<GroupData> groups, File file) throws IOException {
        XStream xstream = new XStream();
                //rename / cut long line <ru.stqa.pft.addressbook.model.GroupData>
            //xstream.alias("group", GroupData.class);
                // needs to read podskazki in GroupData as :@XStreamAlias("group")
        xstream.processAnnotations(GroupData.class);
        String xml = xstream.toXML(groups);
                // lesson 6.8
                // close the file
        try (Writer writer = new FileWriter(file)){
            writer.write(xml);
        }         //-no needs with Try- writer.close();
    }


    private void saveAsScv(List<GroupData> groups, File file) throws IOException {
        // file already exist
        //no directory
        //invalid file name
        System.out.println(new File(".").getAbsolutePath());
        try (Writer writer = new FileWriter(file)){
            for (GroupData group : groups) {
                writer.write(String.format("%s;%s;%s\n",
                        group.getName(),group.getHeader(),group.getFooter()));
            }
        }
        // data write on cache at first
        // if prog close, but data not write, then date could lost
    }

    //private static List<GroupData> generateGroups(int count) {
    private List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++) {
  /*          GroupData groupData = new GroupData();
            groupData.withName("test is " + i);
            groupData.withHeader("header " + i);
            groupData.withFooter("footer " + i);
            groups.add(groupData);
            */
            groups.add(new GroupData().withName(String.format("test %s",i)).
                    withHeader(String.format("header %s",i)).
                    withFooter(String.format("footer %s",i)));

        }
        return groups;
    }
}
