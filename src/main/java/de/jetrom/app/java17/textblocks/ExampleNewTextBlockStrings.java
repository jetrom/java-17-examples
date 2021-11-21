package de.jetrom.app.java17.textblocks;

import java.time.LocalDate;

/**
 * Examples of the new Java Text Block Strings
 * simplify embedding a snippet of HTML, XML, SQL, or JSON in a string literal
 * @since JDK 14
 */
public class ExampleNewTextBlockStrings {

    String textLinesStringLiteral = "line1\n" +
            "line2\n" +
            "line3\n" +
            "line4\n";

    String textLinesNewTextBlock = """
              line1
              line2
              line3
              line4
              """;

    String htmlStringLiteral = "<html>\n" +
            "    <body>\n" +
            "        <p>Hello, world</p>\n" +
            "    </body>\n" +
            "</html>\n";

    String htmlNewTextBlock = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;

    String jsonStringLiteral = "{\n"  +
            "    \"name\" : '\"Doe\",\n" +
            "    \"firstname\" : \"John\",\n" +
            "    \"comment\" : \"old style string literal\"\n" +
            "}\n";

    String jsonTextBlock = """
            {
                "name" : "Doe",
                "firstname" : "John",
                "comment" : "new style text block"
            }
             """;

    String textLinesNewTextBlockWithPlaceHolders = """
              This is a block with placeholders
              hello %s
              at date: %tF
              """.formatted("world", LocalDate.now());



}
