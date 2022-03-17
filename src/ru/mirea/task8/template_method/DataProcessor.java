package ru.mirea.task8.template_method;

import java.util.List;

public abstract class DataProcessor {


    public  Status process(String path) {
        String fileFormat = getFileFormatByPath(path);
        String headers = getHeaders(fileFormat);
        List<String> content = excludeContent(headers);
        Status statusContent = analyzeContent(content);
        return statusContent;
    }

    public abstract String getFileFormatByPath(String path);
    public abstract String getHeaders(String fileFormat);
    public abstract List<String> excludeContent(String headers);

     public Status analyzeContent(List<String> content) {
         if (content.size() != 0) {
             return Status.COMPLETED;
         }
         return Status.FAILED;
     }




}
