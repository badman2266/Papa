package com.cecj03.papago.misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;
import com.opensymphony.xwork2.conversion.TypeConversionException;

public class DateTypeConverter extends StrutsTypeConverter{

	private SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if(values!=null && values.length!=0){
			for(String value:values){
				try {
					return sdf.parse(value);
				} catch (ParseException e) {
					e.printStackTrace();
					throw new TypeConversionException(e);
				}
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map context, Object value) {
		if(value!= null && value instanceof java.util.Date){
			return sdf.format(value);
		}
		return null;
	}

}
