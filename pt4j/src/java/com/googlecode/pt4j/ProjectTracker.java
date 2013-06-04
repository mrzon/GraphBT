package com.googlecode.pt4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;

import com.googlecode.pt4j.data.ProjectData;
import com.googlecode.pt4j.data.ProjectsData;
import com.googlecode.pt4j.data.StoryData;
import com.googlecode.pt4j.data.TokenData;
import com.googlecode.pt4j.util.HTTPUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.MapperWrapper;

/**
 * This class implements the api method calls to send
 * and retrieve the data objects.
 *
 * @author Jon Stevens
 */
public class ProjectTracker
{
	private static final String GET_USER_TOKEN = "https://www.pivotaltracker.com/services/tokens/active";
	private static final String GET_PROJECT = "http://www.pivotaltracker.com/services/v3/projects";

	/** */
	private String token = "05e0e092039b0fe164c7ae8be93d6984";

	/** */
	public ProjectTracker()
	{
	}

	/** */
	public ProjectTracker(String token)
	{
		this.token = token;
	}

	/**
	 * Get a user token. Also assigns the token
	 * to the inner member (token) of this class.
	 *
	 * @param username the users username
	 * @param password the users password
	 * @return a populated TokenData object or null
	 * @throws Exception when there is http problems
	 */
	public TokenData getUserToken(String username, String password) throws Exception
	{
		DefaultHttpClient client = new DefaultHttpClient();
		TokenData token = null;
		try
		{
			// Use basicAuth to make the request to the server
			HttpResponse response = HTTPUtils.basicAuthRequest(GET_USER_TOKEN, username, password, client);
			HttpEntity entity = response.getEntity();

			if ((response.getStatusLine().getStatusCode() != 200) || (entity.getContentLength() == 1))
				return null;

			// Convert the xml response into an object
			XStream xstream = new XStream();
			xstream.processAnnotations(TokenData.class);
			token = (TokenData) xstream.fromXML(entity.getContent());
			this.token = token.getGuid();
		}
		finally
		{
			client.getConnectionManager().shutdown();
		}

		return token;
	}

	/** */
	public ProjectData getSingleProject(Long projectId) throws Exception
	{
		if (this.token == null)
			throw new RuntimeException("Token cannot be null. Please set it first.");

		DefaultHttpClient client = new DefaultHttpClient();
		ProjectData result = null;
		try
		{
			HttpResponse response = HTTPUtils.makeRequest(GET_PROJECT + "/" + projectId, this.token, client);
			HttpEntity entity = response.getEntity();

			XStream xstream = new XStream() {
				  @Override
				  protected MapperWrapper wrapMapper(MapperWrapper next) {
				    return new MapperWrapper(next) {
				      @Override
				      public boolean shouldSerializeMember(Class definedIn,
				              String fieldName) {
				        if (definedIn == Object.class) {
				          return false;
				        }
				        return super.shouldSerializeMember(definedIn, fieldName);
				      }
				    };
				  }
			};
			xstream.processAnnotations(ProjectData.class);
//			BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
//			String str;
//			while((str = in.readLine())!=null) {
//				System.out.println(str);
//			}
			// Convert the xml response into an object
			result = (ProjectData) xstream.fromXML(entity.getContent());
		}
		finally
		{
			client.getConnectionManager().shutdown();
		}
		return result;
	}

	/** */
	public ArrayList<StoryData> getStories(ProjectData project) throws Exception
	{
		long projectId = project.getId();
		if (this.token == null)
			throw new RuntimeException("Token cannot be null. Please set it first.");

		DefaultHttpClient client = new DefaultHttpClient();
		ArrayList<StoryData> result = null;
		try
		{
			HttpResponse response = HTTPUtils.makeRequest(GET_PROJECT + "/" + projectId + "/stories", this.token, client);
			HttpEntity entity = response.getEntity();

			XStream xstream = new XStream() {
				  @Override
				  protected MapperWrapper wrapMapper(MapperWrapper next) {
				    return new MapperWrapper(next) {
				      @Override
				      public boolean shouldSerializeMember(Class definedIn,
				              String fieldName) {
				        if (definedIn == Object.class) {
				          return false;
				        }
				        return super.shouldSerializeMember(definedIn, fieldName);
				      }
				    };
				  }
			};
			xstream.alias("stories", ArrayList.class);
			xstream.processAnnotations(StoryData.class);
//			BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
//			String str;
//			while((str = in.readLine())!=null) {
//				System.out.println(str);
//			}
			// Convert the xml response into an object
			result = (ArrayList<StoryData>) xstream.fromXML(entity.getContent());
		}
		finally
		{
			client.getConnectionManager().shutdown();
		}
		return result;
	}
	
	/** */
	public ProjectsData getAllProjects() throws Exception
	{
		if (this.token == null)
			throw new RuntimeException("Token cannot be null. Please set it first.");

		DefaultHttpClient client = new DefaultHttpClient();
		ProjectsData result = null;
		try
		{
			HttpResponse response = HTTPUtils.makeRequest(GET_PROJECT, this.token, client);
			HttpEntity entity = response.getEntity();

			XStream xstream = new XStream() {
				  @Override
				  protected MapperWrapper wrapMapper(MapperWrapper next) {
				    return new MapperWrapper(next) {
				      @Override
				      public boolean shouldSerializeMember(Class definedIn,
				              String fieldName) {
				        if (definedIn == Object.class) {
				          return false;
				        }
				        return super.shouldSerializeMember(definedIn, fieldName);
				      }
				    };
				  }
				};
			xstream.alias("projects", ArrayList.class);
			xstream.processAnnotations(ProjectData.class);
			File f = new File("test.xml");
			ArrayList<ProjectData> pr= (ArrayList<ProjectData>) xstream.fromXML(new FileReader(f));
			result = new ProjectsData (pr);
		}
		finally
		{
			client.getConnectionManager().shutdown();
		}
		return result;
	}

	/** */
	public String getToken()
	{
		return this.token;
	}


	public void setToken(String token2) {
		// TODO Auto-generated method stub
		this.token = token2;
	}

}
