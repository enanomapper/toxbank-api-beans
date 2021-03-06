package net.toxbank.client.resource;

import java.net.URL;
import java.util.*;

public class Protocol extends AbstractToxBankResource {
	public enum STATUS {
		RESEARCH,SOP,
		REPORT {
			@Override
			public String getPrefix(String prefix) {
				return prefix + "-Report";
			}
		};
		public String getPrefix(String prefix) {
			return prefix + "-Protocol";
		}
		public String getIDPattern(String prefix) {
			return String.format("%s%s",getPrefix(prefix),"-%d-%d");
		}
	};
	private static final long serialVersionUID = -8372109619715612869L;

	protected int version;
	private STATUS status = STATUS.RESEARCH;
	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	private Document document;
	private Template dataTemplate;
	private ToxBankResourceSet<Project>  projects;
	private Organisation organisation;
	private User owner;
	private List<String> keywords;
	private ToxBankResourceSet<User> authors;
	private String identifier;
	private String abstrakt;
	private String info;
	private Long submissionDate;
	private Boolean isSearchable = false;
	private Boolean isPublished = null;
	
	private Set<String> investigationLabels = new HashSet<String>();
	
	public Boolean isPublished() {
		return isPublished;
	}

	public void setPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}

	private URL license;
	protected Long modified;

	public Long getTimeModified() {
		return modified;
	}

	public void setTimeModified(Long timeUpdated) {
		this.modified = timeUpdated;
	}

	public Protocol() {}
	
	public Protocol(URL identifier) {
		setResourceURL(identifier);
	}
	
	// bean methods
	
	public void setLicense(URL license) {
		this.license = license;
	}
	public URL getLicense() {
		return license;
	}
	
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
	public Template getDataTemplate() {
		return dataTemplate;
	}

	public void setDataTemplate(Template dataTemplate) {
		this.dataTemplate = dataTemplate;
	}
	
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public ToxBankResourceSet<Project> getProjects() {
		if (projects == null) projects = new ToxBankResourceSet<Project>();
		return projects;
	}
	public void setProject(int index,Project project) {
		if (project == null) return;
		if (projects == null) projects = new ToxBankResourceSet<Project>();
		projects.set(index, project);
	}
	public void addProject(Project project) {
		if (project == null) return;

		if (projects == null) projects = new ToxBankResourceSet<Project>();
		projects.add(project);
	}

	public void removeProject(Project project) {
		if (project == null || projects == null) return;
		if (projects.contains(project)) projects.remove(project);
	}

	@Deprecated
	public Project getProject() {
		return (projects == null)?null:projects.size()>0?projects.get(0):null;
	}

	@Deprecated
	public void setProject(Project project) {
		addProject(project);
	}

	public void setSearchable(Boolean isSearchable) {
		this.isSearchable = isSearchable;
	}

	public Boolean isSearchable() {
		return isSearchable;
	}

	public void setSubmissionDate(Long submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Long getSubmissionDate() {
		return submissionDate;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void addKeyword(String keyword) {
		if (keyword == null) return;

		if (keywords == null) keywords = new ArrayList<String>();
		keywords.add(keyword);
	}

	public void removeKeyword(String keyword) {
		if (keyword == null || keywords == null) return;
		
		if (keywords.contains(keyword)) keywords.remove(keyword);
	}

	public List<String> getKeywords() {
		if (keywords == null) keywords =  new ArrayList<String>();
		return keywords;
	}

	public void addAuthor(User author) {
		if (author == null) return;

		if (authors == null) authors = new ToxBankResourceSet<User>();
		authors.add(author);
	}

	public void removeAuthor(User author) {
		if (author == null || authors == null) return;
		if (authors.contains(author)) authors.remove(author);
	}

	public ToxBankResourceSet<User> getAuthors() {
		if (authors == null) authors = new ToxBankResourceSet<User>();
		return authors;
	}

	public void setOwner(User author) {
		this.owner = author;
	}

	public User getOwner() {
		return owner;
	}

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setAbstract(String abstrakt) {
		this.abstrakt = abstrakt;
	}

	public String getAbstract() {
		return abstrakt;
	}

	public String getInvestigationLabel() {
	  if (investigationLabels.size() == 0) {
	    return null;
	  }
	  else {
	    StringBuilder sb = new StringBuilder();
	    List<String> labels = new ArrayList<String>(investigationLabels);
	    Collections.sort(labels);
	    for (String label : labels) {
	      if (sb.length() > 0) {
	        sb.append(", ");
	      }
	      sb.append(label);
	    }
	    return sb.toString();
	  }	  
	}
		
	public Set<String> getInvestigationLabels() {
	  return investigationLabels;
	}
	
	public void addInvestigationLabel(String label) {
	  investigationLabels.add(label);
	}
	
	public void removeInvestigationLabel(String label) {
	  investigationLabels.remove(label);
	}
}
