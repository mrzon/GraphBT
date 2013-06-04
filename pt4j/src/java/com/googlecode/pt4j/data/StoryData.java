package com.googlecode.pt4j.data;

import java.net.URL;
import java.util.List;

import org.joda.time.DateTime;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * Describes a Story.
 *
 * @author Jon Stevens
 */
@XStreamAlias("story")
public class StoryData
{
  	@XStreamAlias("id")
	private Long id;
  	@XStreamAlias("story_type")
  	private String storyType;
  	@XStreamAlias("url")
  	private String url;
  	@XStreamAlias("estimate")
	private Integer estimate;
  	@XStreamAlias("current_state")
	private String currentState;
  	@XStreamAlias("description")
  	private String description;
  	@XStreamAlias("name")
  	private String name;
  	@XStreamAlias("requested_by")
	private String requestedBy;
  	@XStreamAlias("owned_by")
	private String ownedBy;
  	@XStreamAlias("created_at")
  	private DateTime createdAt;
  	@XStreamAlias("accepted_at")
	private DateTime acceptedAt;
  	@XStreamAlias("labels")
	private List<String> labels;
  	@XStreamAlias("notes")
  	private List<NoteData> notes;
	@XStreamAlias("iteration")
	private IterationData iteration;

	/** */
	public StoryData() {}

	/** */
	public Long getId()
	{
		return this.id;
	}

	/** */
	public String getStoryType()
	{
		return this.storyType;
	}

	/** */
	public String getUrl()
	{
		return this.url;
	}

	/** */
	public Integer getEstimate()
	{
		return this.estimate;
	}

	/** */
	public String getCurrentState()
	{
		return this.currentState;
	}

	/** */
	public String getDescription()
	{
		return this.description;
	}

	/** */
	public String getName()
	{
		return this.name;
	}

	/** */
	public String getRequestedBy()
	{
		return this.requestedBy;
	}

	/** */
	public String getOwnedBy()
	{
		return this.ownedBy;
	}

	/** */
//	public DateTime getCreatedAt()
//	{
//		return this.createdAt;
//	}

	/** */
//	public DateTime getAcceptedAt()
//	{
//		return this.acceptedAt;
//	}

	/** */
	public IterationData getIteration()
	{
		return this.iteration;
	}

	/** */
	public List<String> getLabels()
	{
		return this.labels;
	}
//
//	/** */
//	public List<NoteData> getNotes()
//	{
//		return this.notes;
//	}
	@Override
	public String toString()
	{
        XStream xstream = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
		xstream.processAnnotations(ProjectData.class);
		return xstream.toXML(this);
	}
}
