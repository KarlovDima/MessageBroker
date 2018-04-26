package com.erouniversity;

import com.beust.jcommander.Parameter;

public class Parameters {
    @Parameter(names = {"--root", "-r"}, required = true, description = "Absolute or relative path to folder where folders will be created")
    private String rootDirectory;

    @Parameter(names = {"--directories", "-d"}, required = true, description = "Amount of directories to be created")
    private Integer generatedDirectoriesAmount;

    @Parameter(names = {"--files", "-f"}, required = true, description = "Amount of files to be created")
    private Integer generatedFilesAmount;

    @Parameter(names = {"--help", "-?"}, help = true, description = "Displays help information")
    private boolean help;

    public String getRootDirectory() {
        return rootDirectory;
    }

    public Integer getGeneratedDirectoriesAmount() {
        return generatedDirectoriesAmount;
    }

    public Integer getGeneratedFilesAmount() {
        return generatedFilesAmount;
    }

    public boolean isHelp() {
        return help;
    }
}
