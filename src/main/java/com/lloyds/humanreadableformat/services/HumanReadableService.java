package com.lloyds.humanreadableformat.services;

import com.lloyds.humanreadableformat.HumanReadable;
import com.lloyds.humanreadableformat.exceptions.InputTimeFormatException;

public interface HumanReadableService {
public HumanReadable timeHumanReadableFormat();
public HumanReadable timeHumanReadableFormat(String time) throws InputTimeFormatException;
}
