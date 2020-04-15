package com.lnavm.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

	public static final DateFormat DF_LONG = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public static final DateFormat DF_SHORT = new SimpleDateFormat("yyyy-MM-dd");
	public static final DateFormat DF_YEAR = new SimpleDateFormat("yyyy");
	public static final DateFormat DF_MONTH = new SimpleDateFormat("yyyy-MM");

	public static final int SHORT_DATE = 10;

	public static final int YEAR_DATE = 4;

	public static final int MONTH_DATE = 7;

	@Override
	public Date convert(String text) {
		text = text.trim();
		if (!StringUtils.hasText(text)) {
			return null;
		}

		try {
			if(text.contains("月")) {
				text = text.replaceAll("月", "");
				Calendar calendar = Calendar.getInstance();
				String[] times = text.trim().split("-");
				calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(times[0].trim()));
				calendar.set(Calendar.MONTH, Integer.parseInt(times[1].trim())-1);
				calendar.set(Calendar.YEAR, Integer.parseInt("20" + times[2].trim()));
				return calendar.getTime();
			}
			else if (text.length() <= YEAR_DATE) {
				return DF_YEAR.parse(text);
			} else if (text.length() <= MONTH_DATE) {
				return DF_MONTH.parse(text);
			} else if (text.length() <= SHORT_DATE) {
				return DF_SHORT.parse(text);
			} else {
				return DF_LONG.parse(text);
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到当前时间的字符串表示
	 * @return   当前时间的字符串表示
	 */
	public static String getCurrentFormatDate() {
		Date date = new Date(System.currentTimeMillis());
		return DF_LONG.format(date);
	}
}