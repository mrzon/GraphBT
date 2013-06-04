package com.googlecode.pt4j.util;

import com.googlecode.pt4j.data.ProjectsData;
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
public class ProjectsDataConverter implements Converter
{
	/** */
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context)
	{
		ProjectsData data = (ProjectsData) source;
		writer.addAttribute("type", data.getType());
	}

	/** */
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context)
	{
		ProjectsData result = new ProjectsData();
		return result;
	}

	/** */
	@SuppressWarnings("unchecked")
	public boolean canConvert(Class clazz)
	{
		return clazz.equals(ProjectsData.class);
	}
}
