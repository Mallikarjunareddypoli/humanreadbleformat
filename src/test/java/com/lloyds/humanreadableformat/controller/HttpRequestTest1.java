package com.lloyds.humanreadableformat.controller;

import com.lloyds.humanreadableformat.constants.HumanReadableConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest1 {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnGivenTimeInWords() {
        TestCaseConstants.tstMap.entrySet().forEach(entry->
                assertThat(
                        this.restTemplate.getForObject(
                                "http://localhost:" + port + "/time(hh:ss)/"+entry.getKey(),
                                String.class
                        )
                ).contains(entry.getValue()));
    }
    @Test
    public void shouldReturnGivenExceptionForInvalidFormat() {
        assertThat(
                this.restTemplate.getForObject(
                        "http://localhost:" + port + "/time(hh:ss)/13",
                        String.class
                )
        ).contains(HumanReadableConstants.TIME_FORMAT_ERROR);
    }
}
