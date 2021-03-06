package com.googlecode.pt4j.data;

import com.googlecode.pt4j.util.IdConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;


/**
 * Describes a single Token
 *
 * @author jon stevens
 */
@XStreamAlias("token")
public class TokenData
{
	private String guid;

	@XStreamConverter(IdConverter.class)
	private IdData id;

	/** */
	public TokenData() {}

	/** */
	public TokenData(Long id)
	{
		this.id = new IdData(id);
	}

	/** */
	public IdData getId()
	{
		return this.id;
	}

	/** */
	public String getGuid()
	{
		return this.guid;
	}

	/** */
	@Override
	public String toString()
	{
		XStream xstream = new XStream();
		xstream.processAnnotations(TokenData.class);
		return xstream.toXML(this);
	}
}
