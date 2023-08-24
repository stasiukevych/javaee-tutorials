package javaeetutorials.cdi.qualifierMultiple;

import javaeetutorials.cdi.qualifierMember.Formatter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Custom
@Formatting
public class FormatService implements Formatter {

    @Override
    public String formatDate(Date date) {
        return new SimpleDateFormat("MM-dd-yyyy hh:mm:ss").format(date);
    }
}