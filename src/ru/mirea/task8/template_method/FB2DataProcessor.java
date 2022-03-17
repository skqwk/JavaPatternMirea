
package ru.mirea.task8.template_method;

import java.util.Arrays;
import java.util.List;

public class FB2DataProcessor extends DataProcessor {

    @Override
    public String getFileFormatByPath(String path) {
        String format = "unknown";
        if (path.endsWith(".fb2")) {
            format = "fb2";
        }
        return format;
    }

    @Override
    public String getHeaders(String fileFormat) {
        if (fileFormat.equals("pdf")) {
            return "Part_1 Part_2 Part_3";
        }
        return "";
    }

    @Override
    public List<String> excludeContent(String headers) {
        return Arrays.asList(headers.split(" "));
    }
}

