package com.orvyl.sample.swf.checkout.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by vyl on 9/30/15.
 */
@ConfigurationProperties(prefix = "aws.swf")
public class AmazonSWFProperties {
    private String regionId;
    private String configFile;
    private String domain;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getConfigFile() {
        return configFile;
    }

    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
