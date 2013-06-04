package com.googlecode.pt4j.util;

import java.util.Arrays;
import java.util.List;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;


/**
 * Converts a comma separated list of strings
 *
 * @author Jon Stevens
 */
public class CommaStringConverter implements Converter
{
	/** */
	@SuppressWarnings("unchecked")
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context)
	{
		List<String> data = (List<String>) source;
		StringBuilder sb = new StringBuilder();
		boolean firstTime = true;
		for (String tmp : data)
		{
			if (!firstTime)
				sb.append(",");
			sb.append(tmp);
			firstTime = false;
		}
		writer.setValue(sb.toString());
	}

	/** */
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context)
	{
		String data = reader.getValue();
		String[] parsed = data.split(",");
		List<String> result = Arrays.asList(parsed);
		return result;
	}

	/** */
	@SuppressWarnings("unchecked")
	public boolean canConvert(Class clazz)
	{
		return true;
	}
}
