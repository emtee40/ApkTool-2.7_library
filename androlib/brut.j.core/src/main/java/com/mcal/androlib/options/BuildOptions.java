package com.mcal.androlib.options;

import java.util.Collection;

public class BuildOptions {
    public final boolean updateFiles = false;
    public boolean forceBuildAll = false;
    public boolean forceDeleteFramework = false;
    public boolean debugMode = false;
    public boolean netSecConf = false;
    public boolean verbose = false;
    public boolean copyOriginalFiles = false;
    public boolean isFramework = false;
    public boolean resourcesAreCompressed = false;
    public boolean useAapt2 = false;
    public boolean noCrunch = false;
    public int forceApi = 0;
    public Collection<String> doNotCompress;
    public String frameworkFolderLocation = null;
    public String frameworkTag = null;
    public int aaptVersion = 1; // default to v1
    public String aaptPath = "";
    public String aapt2Path = "";

    /**
     * Support:
     * 1. Decode mode
     * 2. Build mode (isJsonConfig == true)
     */
    public boolean ignoreMultiRes = true;
    /**
     * Use new rules
     */
    public boolean useNewBuildRules = true;
    /**
     * Check for the presence of all files on build
     */
    public boolean checkExistsFiles = false;

    public boolean isAapt2() {
        return this.useAapt2 || this.aaptVersion == 2;
    }
}