package net.media.training.designpattern.builder;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: path
 * Date: Jul 19, 2011
 * Time: 10:04:03 PM
 * To change this template use File | Settings | File Templates.
 */
// public class PeopleDataSource {
//     public static String getPeopleXml(List<Person> persons) {
//         String finalXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
//         finalXML += "<People number=\"" + persons.size() + "\">";
//         for (Person person : persons) {
//             finalXML += "<Person id=\"" + person.getId() + "\" name=\"" + person.getName() + "\">" +
//                     "<Address><City>" + person.getCity() + "</City><Country>" + person.getCountry() + "</Country></Address>" +
//                     "</Person>";
//         }
//         finalXML += "</People>";
//         return finalXML;
//     }
// }

public class PeopleDataSource {
    public static String getPeopleXml(List<Person> persons) {
        XmlBuilder xmlBuilder = new XmlBuilder();
        xmlBuilder.startElementWithoutClosingTag("People")
                .addAttribute("number", String.valueOf(persons.size()));

        for (Person person : persons) {
            xmlBuilder.startElementWithoutClosingTag("Person")
                    .addAttribute("id", String.valueOf(person.getId()))
                    .addAttribute("name", person.getName())
                    .startElement("Address")
                    .startElement("City")
                    .addText(person.getCity())
                    .endElement("City")
                    .startElement("Country")
                    .addText(person.getCountry())
                    .endElement("Country")
                    .endElement("Address")
                    .endElement("Person");
        }

        xmlBuilder.endElement("People");
        return xmlBuilder.getXmlString();
    }
}