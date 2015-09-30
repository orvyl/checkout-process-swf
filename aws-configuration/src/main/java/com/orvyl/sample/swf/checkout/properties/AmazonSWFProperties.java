package com.orvyl.sample.swf.checkout.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by vyl on 9/30/15.
 */
@ConfigurationProperties(prefix = "aws.swf")
public class AmazonSWFProperties {
    private String regionId;
    private String accessKeyId;
    private String secretAccessKey;
    private String domain;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
