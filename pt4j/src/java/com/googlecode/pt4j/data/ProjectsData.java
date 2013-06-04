package com.googlecode.pt4j.data;

import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * Describes a list of projectdata with a type of array.
 *
 * @author jon stevens
 */
@XStreamAlias("projects")
public class ProjectsData
{
	@XStreamAlias("project")
	@XStreamConverter(CollectionConverter.class)
	private List<ProjectData> projectData;

	@XStreamAsAttribute
	private String type = "array";

	/** */
	public ProjectsData() {}

	/** */
	public ProjectsData(List<ProjectData> projectData)
	{
		this.projectData = projectData;
	}

	/** */
	public ProjectsData(List<ProjectData> projectData, String type)
	{
		this.projectData = projectData;
		this.type = type;
	}

	/** */
	public List<ProjectData> getProjectData()
	{
		return this.projectData;
	}

	/** */
	public String getType()
	{
		return this.type;
	}

	/** */
	@Override
	public String toString()
	{
        XStream xstream = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
		xstream.processAnnotations(ProjectsData.class);
		return xstream.toXML(this);
	}
}
