package de.jetrom.app.java17.textblocks;

import java.time.LocalDate;

/**
 * Examples of the new Java Text Block Strings
 * simplify embedding a snippet of HTML, XML, SQL, or JSON in a string literal
 * @since JDK 14
 */
public class ExampleNewTextBlockStrings {

    public static final String textLinesStringLiteral = "line1\n" +
            "line2\n" +
            "line3\n" +
            "line4\n";

    public static final String textLinesNewTextBlock = """
              line1
              line2
              line3
              line4
              """;

    public  static final String htmlStringLiteral = "<html>\n" +
            "    <body>\n" +
            "        <p>Hello, world</p>\n" +
            "    </body>\n" +
            "</html>\n";

    public static final String htmlNewTextBlock = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;

    public static final String jsonStringLiteral = "{\n" +
            "    \"name\" : \"Doe\",\n" +
            "    \"firstname\" : \"John\",\n" +
            "    \"comment\" : \"json string\"\n" +
            "}\n";

    public static final String jsonTextBlock = """
            {
                "name" : "Doe",
                "firstname" : "John",
                "comment" : "json string"
            }
             """;

    public static final String textLinesNewTextBlockWithPlaceHolders = """
              This is a block with placeholders
              hello %s
              at date: %tF
              """;

    public static String getTextLinesNewTextBlockWithPlaceHolders(String name, LocalDate date) {
        return textLinesNewTextBlockWithPlaceHolders.formatted(name, date);
    }



}
