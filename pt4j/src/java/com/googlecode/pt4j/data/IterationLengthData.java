package com.googlecode.pt4j.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Describes a single iterationLength with a default attribute type of "integer"
 *
 * @author jon stevens
 */
@XStreamAlias("iteration_length")
public class IterationLengthData
{
	private Long iterationLength;

	@XStreamAsAttribute
	private String type = "integer";

	/** */
	public IterationLengthData() {}

	/** */
	public IterationLengthData(Long iterationLength)
	{
		this.iterationLength = iterationLength;
	}

	/** */
	public IterationLengthData(Long iterationLength, String type)
	{
		this.iterationLength = iterationLength;
		this.type = type;
	}

	/** */
	public Long getIterationLength()
	{
		return this.iterationLength;
	}

	/** */
	public String getType()
	{
		return this.type;
	}
}
