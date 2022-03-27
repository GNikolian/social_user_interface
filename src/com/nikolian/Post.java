package com.nikolian;

public class Post extends DataModel{

    private String postTitle;
    private String postBody;
    private int postId;

    Post(String postTitle, String postBody){
        this.setPostTitle(postTitle);
        this.setPostBody(postBody);
        this.postId = this.setNewId();
    }

    public void setPostTitle(String postTitle) {this.postTitle = postTitle;}
    public void setPostBody(String postBody) {this.postBody = postBody;}
    public String getPostTitle() {return this.postTitle;}
    public String getPostBody() {return this.postBody;}
    public int getPostId() {return this.postId;}
}
