package ru.mirea.task8.template_method;

import java.util.Arrays;
import java.util.List;

public class PFDDataProcessor extends DataProcessor {
    @Override
    public String getFileFormatByPath(String path) {
        String format = "unknown";
        if (path.endsWith(".pdf")) {
            format = "pdf";
        }
            return format;
    }

    @Override
    public String getHeaders(String fileFormat) {
        if (fileFormat.equals("pdf")) {
            return "Chapter_1 Chapter_2 Chapter_3";
        }
        return "";
    }

    @Override
    public List<String> excludeContent(String headers) {
        return Arrays.asList(headers.split(" "));
    }
}
