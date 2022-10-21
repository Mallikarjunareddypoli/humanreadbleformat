package com.lloyds.humanreadableformat.controller;

import com.lloyds.humanreadableformat.HumanReadable;
import com.lloyds.humanreadableformat.constants.HumanReadableConstants;
import com.lloyds.humanreadableformat.services.HumanReadableService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HumanReadableFormatController.class)
public class HumanReadableControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HumanReadableService humanReadableService;

    @Test
    public void shouldReturnTimeInWordsMock1() throws Exception {
       when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable("half past four"));
        this.mockMvc.perform(get("time(hh:ss)/16:30"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value("half past four"));
    }
    @Test
    public void shouldReturnTimeInWordsMock2() throws Exception {
        when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable("one o'clock"));
        this.mockMvc.perform(get("/01:00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value("one o'clock"));
    }
    @Test
    public void shouldReturnTimeInWordsMock3() throws Exception {
        when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable("two o'clock"));
        this.mockMvc.perform(get("/02:30"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value("two o'clock"));
    }
    @Test
    public void shouldReturnTimeInWordsMock4() throws Exception {
        when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable("one o'clock"));
        this.mockMvc.perform(get("/13:00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value("one o'clock"));
    }
    @Test
    public void shouldReturnTimeInWordsMock5() throws Exception {
        when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable("five past three"));
        this.mockMvc.perform(get("/03:05"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value("five past three"));
    }
    @Test
    public void shouldReturnTimeInWordsMock6() throws Exception {
        when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable("ten past one"));
        this.mockMvc.perform(get("/13:10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value("ten past one"));
    }

    @Test
    public void shouldReturnTimeInWordsMock7() throws Exception {
        when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable("twenty-five past one"));
        this.mockMvc.perform(get("/13:25"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value("twenty-five past one"));
    }

    @Test
    public void shouldReturnTimeInWordsMock8() throws Exception {
        when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable("half past one"));
        this.mockMvc.perform(get("/13:30"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value("half past one"));
    }
    @Test
    public void shouldReturnTimeInWordsMock9() throws Exception {
        when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable("half past one"));
        this.mockMvc.perform(get("/13:30"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value("half past one"));
    }
    @Test
    public void shouldReturnTimeInWordsMock10() throws Exception {
        when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable("twenty-five to two"));
        this.mockMvc.perform(get("/13:35"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value("twenty-five to two"));
    }
    @Test
    public void shouldReturnTimeInWordsMock11() throws Exception {
        when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable("five to two"));
        this.mockMvc.perform(get("/13:55"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value("five to two"));
    }
    @Test
    public void shouldReturnTimeInWordsNegativePath() throws Exception {
        when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable(HumanReadableConstants.TIME_FORMAT_ERROR));
        this.mockMvc.perform(get("/13:70"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value(HumanReadableConstants.TIME_FORMAT_ERROR));
    }
    @Test
    public void shouldReturnTimeInWordsNegativePath_1() throws Exception {
        when(humanReadableService.timeHumanReadableFormat(any())).thenReturn(new HumanReadable(HumanReadableConstants.TIME_FORMAT_ERROR));
        this.mockMvc.perform(get("/sdafsafd"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("value").exists())
                .andExpect(jsonPath("value").value(HumanReadableConstants.TIME_FORMAT_ERROR));
    }
}
