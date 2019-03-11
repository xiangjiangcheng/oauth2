package com.xiang.oauth2.server.domain;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

/**
 * @author Lang Yu
 */
public class GuidGenerator {

    private static final TimeBasedGenerator timeBasedGenerator = Generators.timeBasedGenerator(EthernetAddress.constructMulticastAddress());

    public static String createGuid() {
        return timeBasedGenerator.generate().toString();
    }
}
