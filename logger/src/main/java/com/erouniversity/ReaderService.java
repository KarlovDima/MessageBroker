package com.erouniversity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {
    @Value("${rootFolder:logger}")
    private String rootFolder;

    public String getRootFolder() {
        return getRootFolder(rootFolder);
    }

    public String getRootFolder(String rootFolder) {
        return rootFolder;
    }
}
