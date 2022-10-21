package com.lloyds.humanreadableformat.controller;

import com.lloyds.humanreadableformat.HumanReadable;
import com.lloyds.humanreadableformat.exceptions.InputTimeFormatException;
import com.lloyds.humanreadableformat.services.HumanReadableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanReadableFormatController {

    @Autowired
    HumanReadableService humanReadableService;

    @GetMapping("/currentTime")
    public HumanReadable getTimeInReadableFormat() {
        return humanReadableService.timeHumanReadableFormat();
    }

    @GetMapping("/time(hh:ss)/{time}")
    public HumanReadable getTimeInReadableFormat(@PathVariable String time) throws InputTimeFormatException {
        return humanReadableService.timeHumanReadableFormat(time);
    }
}
