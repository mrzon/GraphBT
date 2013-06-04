package com.googlecode.pt4j.data;

import org.joda.time.DateTime;

import com.googlecode.pt4j.util.IterationLengthConverter;
import com.googlecode.pt4j.util.PointScaleConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * Describes a PT Project
 *
 * @author jon stevens
 */
@XStreamAlias("project")
public class ProjectData
{
	@XStreamAlias("id")
	private long id;

	public void setName(String name) {
		this.name = name;
	}

	public void setIterationLength(IterationLengthData iterationLength) {
		this.iterationLength = iterationLength;
	}

	public void setWeekStartDay(String weekStartDay) {
		this.weekStartDay = weekStartDay;
	}

	public void setPointScale(PointScaleData pointScale) {
		this.pointScale = pointScale;
	}

	@XStreamAlias("name")
	private String name;
	@XStreamAlias("account")
	private String account;
	@XStreamAlias("iteration_length")
	@XStreamConverter(IterationLengthConverter.class)
	private IterationLengthData iterationLength;

	@XStreamAlias("week_start_day")
	private String weekStartDay;
//	private DateTime firstIteration = 
	@XStreamAlias("point_scale")
	@XStreamConverter(PointScaleConverter.class)
	private PointScaleData pointScale;

	/** */
	public ProjectData() {}

	/** */
	public long getId()
	{
		return this.id;
	}

	/** */
	public String getName()
	{
		return this.name;
	}

	/** */
	public IterationLengthData getIterationLength()
	{
		return this.iterationLength;
	}

	/** */
	public String getWeekStartDay()
	{
		return this.weekStartDay;
	}

	/** */
	public PointScaleData getPointScale()
	{
		return this.pointScale;
	}

	/** */
	@Override
	public String toString()
	{
        XStream xstream = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
		xstream.processAnnotations(ProjectData.class);
		return xstream.toXML(this);
	}
}
