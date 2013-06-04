package com.googlecode.pt4j.data;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Describes a single Id with a default attribute type of "integer"
 *
 * @author jon stevens
 */
@XStreamAlias("point_scale")
public class PointScaleData
{
	private List<Integer> scale;

	/** */
	public PointScaleData() {}

	/** */
	public PointScaleData(List<Integer> scale)
	{
		this.scale = scale;
	}

	/** */
	public List<Integer> getScale()
	{
		return this.scale;
	}

	/** */
	public String getScaleAsString()
	{
		return null;
	}
}
