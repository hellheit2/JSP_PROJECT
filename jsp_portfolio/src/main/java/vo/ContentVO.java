package vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ContentVO {
	
	private int cno;
	private String title;
	private String summary;
	private String image_path;
	private int view_count;
	private float rate;
	
	public ContentVO() {};
	
	public ContentVO(int cno, String title, String summary, String image_path, int view_count, float rate) {
		super();
		this.cno = cno;
		this.title = title;
		this.summary = summary;
		this.image_path = image_path;
		this.view_count = view_count;
		this.rate = rate;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String content) {
		this.summary = content;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		try {
			if(image_path!=null && image_path.length()!=0) {
				this.image_path = URLEncoder.encode(image_path, "UTF-8");  //파일이름에 특수문자가 있을 경우 인코딩
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.image_path = image_path;
	}

	public int getView_count() {
		return view_count;
	}

	public void setView_count(int view_count) {
		this.view_count = view_count;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}
	
	
	
	
	
}
