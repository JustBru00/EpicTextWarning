// THE (“EpicTextWarning”) SOURCE IS PROVIDED AS IS AT NO MONETARY COST FOR PERSONAL USE ONLY. ANY COMMERCIAL DISTRIBUTION/USE OF THE (“EpicTextWarninfg”) SOURCE IS STRICTLY PROHIBITED.
package com.gmail.justbru00.epic.textwarning.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeGetter {

	public static String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
}
