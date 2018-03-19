/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.cinq;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import br.com.cinq.processor.StreamProcessorImpl;

/**
 *
 * @author William
 */
public class CityResourceTest {

    private StreamProcessorImpl streamProcessor;

    @Before
    public void setUp() {
        streamProcessor = new StreamProcessorImpl();
    }

    @Test
    public void testReadLines() {

        String filePath = "cities.txt";

        List<String> lines = streamProcessor.readLines(filePath);

        assertNotNull(lines);
    }
}
