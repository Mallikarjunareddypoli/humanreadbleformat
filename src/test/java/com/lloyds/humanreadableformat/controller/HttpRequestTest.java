package com.lloyds.humanreadableformat.controller;

import com.lloyds.humanreadableformat.constants.HumanReadableConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;



    @Test
    public void shouldReturnGivenTimeInWords() {
        assertThat(
                this.restTemplate.getForObject(
                        "http://localhost:" + port + "/16:30",
                        String.class
                )
        ).contains("half past four");
    }
//01:00 one o'clock
    @Test
    public void shouldReturnGivenTimeInWordsTest1() {
        assertThat(
                this.restTemplate.getForObject(
                        "http://localhost:" + port + "/01:00",
                        String.class
                )
        ).contains("one o'clock");
    }
    //02:00 Two o'clock
    @Test
    public void shouldReturnGivenTimeInWordsTest2() {
        assertThat(
                this.restTemplate.getForObject(
                        "http://localhost:" + port + "/02:00",
                        String.class
                )
        ).contains("two o'clock");
    }
    //13:00 One o'clock
    @Test
    public void shouldReturnGivenTimeInWordsTest3() {
        assertThat(
                this.restTemplate.getForObject(
                        "http://localhost:" + port + "/13:00",
                        String.class
                )
        ).contains("one o'clock");
    }
    //3:05 Five past one
    @Test
    public void shouldReturnGivenTimeInWordsTest4() {
        assertThat(
                this.restTemplate.getForObject(
                        "http://localhost:" + port + "/03:05",
                        String.class
                )
        ).contains("five past three");
    }
    //13:10 Ten past one
    @Test
    public void shouldReturnGivenTimeInWordsTest5() {
        assertThat(
                this.restTemplate.getForObject(
                        "http://localhost:" + port + "/13:10",
                        String.class
                )
        ).contains("ten past one");
    }
    //13:25 Twenty five past one
    @Test
    public void shouldReturnGivenTimeInWordsTest6() {
        assertThat(
                this.restTemplate.getForObject(
                        "http://localhost:" + port + "/13:25",
                        String.class
                )
        ).contains("twenty-five past one");
    }
    //13:30 Half past one
    @Test
    public void shouldReturnGivenTimeInWordsTest7() {
        assertThat(
                this.restTemplate.getForObject(
                        "http://localhost:" + port + "/13:30",
                        String.class
                )
        ).contains("half past one");
    }
    //13:35 Twenty five to two
    @Test
    public void shouldReturnGivenTimeInWordsTest8() {
        assertThat(
                this.restTemplate.getForObject(
                        "http://localhost:" + port + "/13:35",
                        String.class
                )
        ).contains("twenty-five to two");
    }
    //13:55 Five to two
    @Test
    public void shouldReturnGivenTimeInWordsTest9() {
        assertThat(
                this.restTemplate.getForObject(
                        "http://localhost:" + port + "/13:55",
                        String.class
                )
        ).contains("five to two");
    }
    @Test
    public void shouldReturnGivenExceptionForInvalidFormat() {
        assertThat(
                this.restTemplate.getForObject(
                        "http://localhost:" + port + "/13",
                        String.class
                )
        ).contains(HumanReadableConstants.TIME_FORMAT_ERROR);
    }
}
