package com.lloyds.humanreadableformat.referencedata;

import com.lloyds.humanreadableformat.exceptions.InputTimeFormatException;
import com.lloyds.humanreadableformat.services.HumanReadableService;
import com.lloyds.humanreadableformat.services.HumanReadableServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HumanReadableServiceTest {
    private HumanReadableService humanReadableService;

    @Before
    public void setUp(){
        humanReadableService = new HumanReadableServiceImpl();
    }
    @Test
    public void getTimeInWords() throws InputTimeFormatException {

        assertThat(humanReadableService.timeHumanReadableFormat("16:30").equals("half past four"));
        assertThat(humanReadableService.timeHumanReadableFormat("01:00").equals("one o'clock"));
        assertThat(humanReadableService.timeHumanReadableFormat("02:30").equals("two o'clock"));
        assertThat(humanReadableService.timeHumanReadableFormat("13:00").equals("one o'clock"));
        assertThat(humanReadableService.timeHumanReadableFormat("03:05").equals("five past three"));
        assertThat(humanReadableService.timeHumanReadableFormat("13:10").equals("ten past one"));
        assertThat(humanReadableService.timeHumanReadableFormat("13:25").equals("twenty-five past one"));
        assertThat(humanReadableService.timeHumanReadableFormat("13:30").equals("half past one"));
        assertThat(humanReadableService.timeHumanReadableFormat("13:35").equals("twenty-five to two"));
        assertThat(humanReadableService.timeHumanReadableFormat("13:55").equals("five to two"));

    }
}
