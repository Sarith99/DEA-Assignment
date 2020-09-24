/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClasses;

import java.util.List;

/**
 *
 * @author imesh
 */
public class Reservation {
    private int id;
    private String date;
    private Post post;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Post getPostList() {
        return post;
    }

    public void setPostList(Post post) {
        this.post = post;
    }
    
    
}
