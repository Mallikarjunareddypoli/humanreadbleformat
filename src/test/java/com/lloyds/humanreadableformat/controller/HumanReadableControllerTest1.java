package com.lloyds.humanreadableformat.controller;

import com.lloyds.humanreadableformat.HumanReadable;
import com.lloyds.humanreadableformat.constants.HumanReadableConstants;
import com.lloyds.humanreadableformat.exceptions.InputTimeFormatException;
import com.lloyds.humanreadableformat.services.HumanReadableService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HumanReadableFormatController.class)
public class HumanReadableControllerTest1 {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HumanReadableService humanReadableService;
    @Test
    public void shouldReturnTimeInWordsMock1() throws Exception {
        for (Map.Entry<String, String> entry : TestCaseConstants.tstMap.entrySet()) {
            when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable(entry.getValue()));

            this.mockMvc.perform(get("/time(hh:ss)/" + entry.getKey()))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("value").exists())
                    .andExpect(jsonPath("value").value(entry.getValue()));
        }
    }
    @Test
    public void shouldReturnTimeInWordsNegativePath() throws Exception {
        when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable(HumanReadableConstants.TIME_FORMAT_ERROR));
        this.mockMvc.perform(get("/time(hh:ss)/13:70"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value(HumanReadableConstants.TIME_FORMAT_ERROR));
    }
    @Test
    public void shouldReturnTimeInWordsNegativePath_1() throws Exception {
        when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable(HumanReadableConstants.TIME_FORMAT_ERROR));
        this.mockMvc.perform(get("/time(hh:ss)/sdafsafd"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value(HumanReadableConstants.TIME_FORMAT_ERROR));
    }
}
