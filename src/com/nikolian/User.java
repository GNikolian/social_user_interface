package com.nikolian;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User extends DataModel{
    private String username;
    private String email;
    private int userId;
    private ArrayList<Post> userPosts = new ArrayList<Post>();
    Scanner scanner = new Scanner(System.in);

    User(String username, String email){
        this.setUsername(username);
        this.setEmail(email);
        this.userId = this.setNewId();
    }

    public void setUsername(String username) {this.username = username;}
    public void setEmail(String email) {this.email = email;}
    public String getUsername() {return this.username;}
    public String getEmail() {return this.email;}
    public int getUserId() {return this.userId;}

    //  CRUD OPERATIONS
    //  CREATE POST
    public void createPost() {
        System.out.println("Enter new title:");
        String title = scanner.nextLine();

        System.out.println("Enter new body text:");
        String body = scanner.nextLine();

        Post post = new Post(title, body);
        this.userPosts.add(post);
        this.printPost(post);
    }

    //  READ ALL
    public void readAllPosts() {
        if (this.userPosts.isEmpty()) {
            System.out.println("User has no posts.");
        } else {
            int sum = 1;
            for(Post p : this.userPosts) {
                System.out.println("Post #"+sum);
                this.printPost(p);
                sum++;
            }
        }
    }

    //  UPDATE POST
    public void updatePost(String title) {
        for(Post p : this.userPosts){
            if(p.getPostTitle().equals(title)){
                System.out.println("Enter new title:");
                String newTitle = scanner.nextLine();
                p.setPostTitle(newTitle);

                System.out.println("Enter new body text:");
                String newBody = scanner.nextLine();
                p.setPostBody(newBody);

                System.out.println("Update successful. Printing new post: ");
                printPost(p);
            } else {
                if(this.userPosts.indexOf(p) == this.userPosts.size()-1){
                    System.out.println("No post found. Please try again.");
                }
            }
        }
    }

    //  DELETE POST
    public void deletePost(String title) {
        ArrayList<Post> toRemove = new ArrayList<Post>();
        for(Post p : this.userPosts){
            if(p.getPostTitle().equals(title)){
                toRemove.add(p);
            }
        }
        if(toRemove.isEmpty()) {
            System.out.println("No post found. Try again.");
        } else {
            this.userPosts.removeAll(toRemove);
            System.out.println("Post removed!");
        }
    }

    //  READ SPECIFIC POST
    private void printPost(Post post) {
        if(userPosts.contains(post)) {
            System.out.println("\'"+post.getPostTitle().toUpperCase()+"\'");
            System.out.println("\t\'"+post.getPostBody()+"\'");
        } else {
            System.out.println("No post found. Please try again.");
        }
    }

    private void userActions(User user) {
        System.out.println("Hello, "+user.getUsername());
        System.out.println("Type (1) to create a post.");
        System.out.println("Type (2) to read your posts.");
        System.out.println("Type (3) to update a post.");
        System.out.println("Type (4) to delete a post.");
        System.out.println("Type (5) to quit");
    }

    public void userOperate(User user) {
        int userInput;

        do {
            try {
                userActions(user);
                userInput = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Something went wrong!");
                scanner.nextLine();
                userInput = 0;
            }
            switch (userInput) {
                case 1:
                    user.createPost();
                    break;
                case 2:
                    user.readAllPosts();
                    break;
                case 3:
                    System.out.println("Enter post title you want to update");
                    String updateTitle = scanner.nextLine();
                    user.updatePost(updateTitle);
                    break;
                case 4:
                    System.out.println("Enter post title you want to delete");
                    String deleteTitle = scanner.nextLine();
                    user.deletePost(deleteTitle);
                    break;
                case 5:
                    System.out.println("User quit. Bye-Bye!");
                    break;
                default:
                    System.out.println("Not a valid option. Please select a new action.");
            }

        } while(userInput != 5);
    }


}
