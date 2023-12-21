package kr.or.ddit.bts;

public class BtsVO {
	private String name;
	private String title;
	private String logicalPath;
	
	public BtsVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BtsVO(String name, String title, String logicalPath) {
		super();
		this.name = name;
		this.title = title;
		this.logicalPath = logicalPath;
	}

	@Override
	public String toString() {
		return "BtsVO [name=" + name + ", title=" + title + ", logicalPath=" + logicalPath + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BtsVO other = (BtsVO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogicalPath() {
		return logicalPath;
	}

	public void setLogicalPath(String logicalPath) {
		this.logicalPath = logicalPath;
	}
	
	
}
