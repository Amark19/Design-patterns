package net.media.training.designpattern.builder;

public class XmlBuilder {
    private StringBuilder xml;

    public XmlBuilder() {
        xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    }

    public XmlBuilder startElement(String elementName) {
        xml.append("<").append(elementName).append(">");
        return this;
    }

    public XmlBuilder startElementWithoutClosingTag(String elementName) {
        xml.append("<").append(elementName);
        return this;
    }

    public XmlBuilder addAttribute(String attributeName, String attributeValue) {
        xml.append(" ").append(attributeName).append("=\"").append(attributeValue).append("\"");
        return this;
    }

    public XmlBuilder addText(String text) {
        xml.append(text);
        return this;
    }

    public XmlBuilder endElement(String elementName) {
        xml.append("</").append(elementName).append(">");
        return this;
    }

    public String getXmlString() {
        return xml.toString();
    }
}

