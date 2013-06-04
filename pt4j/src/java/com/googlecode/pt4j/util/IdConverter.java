package com.googlecode.pt4j.util;

import com.googlecode.pt4j.data.IdData;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;


/**
 * Converts 2008/02/28 23:30:11 GMT to/from a Joda DateTime
 *
 * @author Jon Stevens
 */
public class IdConverter implements Converter
{
	/** */
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context)
	{
		IdData data = (IdData) source;
		writer.addAttribute("type", data.getType());
		writer.setValue(data.getId().toString());
	}

	/** */
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context)
	{
		String data = reader.getValue();
		IdData result = new IdData(new Long(data));
		return result;
	}

	/** */
	@SuppressWarnings("unchecked")
	public boolean canConvert(Class clazz)
	{
		return true;
	}
}
