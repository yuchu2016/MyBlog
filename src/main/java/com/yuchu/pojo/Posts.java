package com.yuchu.pojo;

public class Posts {
    private Integer id;

    private String title;

    private String summary;

    private String labelImg;

    private Integer catId;

    private Integer userId;

    private String userName;

    private Boolean isValid;

    private String createdAt;

    private String updatedAt;

    private String content;
    
    private Cats cats=new Cats();
    
    
    private Post_extends post_extends = new Post_extends();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getLabelImg() {
        return labelImg;
    }

    public void setLabelImg(String labelImg) {
        this.labelImg = labelImg == null ? null : labelImg.trim();
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public Cats getCats() {
		return cats;
	}

	public void setCats(Cats cats) {
		this.cats = cats;
	}

	public Post_extends getPost_extends() {
		return post_extends;
	}

	public void setPost_extends(Post_extends post_extends) {
		this.post_extends = post_extends;
	}
	
	
    
}