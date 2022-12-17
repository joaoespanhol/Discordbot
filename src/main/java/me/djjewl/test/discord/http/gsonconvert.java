package me.djjewl.test.discord.http;

import java.io.Serializable;
//WIP GSON CONVERT
public class gsonconvert implements Serializable {
    public String name;
    public String tag_name;
    public String created_at;
    public String link;
    public String git_commit_url;
    //
    // Gets the vaules and returns them
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTagname() {
        return tag_name;
    }
    public void setTagname(String tag_name) {
        this.tag_name = tag_name;
    }
    public String created_at() {
        return created_at;
    }
    public void setcreated_at(String created_at) {
        this.created_at = created_at;
    }
    public String link() {
        return link;
    }
    public void setlink(String link) {
        this.link = link;
    }
    public String git_commit_url() {
        return git_commit_url;
    }
    public void setgit_commit_url(String git_commit_url) {
        this.git_commit_url = git_commit_url;
    }
}
