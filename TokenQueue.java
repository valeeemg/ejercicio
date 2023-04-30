/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class TokenQueue {
    
    private final Queue<String> queue = new LinkedList<>();
    private final Semaphore semaphore;
    
    public TokenQueue(int capacity) {
        semaphore = new Semaphore(capacity);
    }
    
    public void addToken(String token) throws InterruptedException {
        semaphore.acquire();
        synchronized (queue) {
            queue.add(token);
        }
    }
    
    public String getToken() {
        synchronized (queue) {
            String token = queue.poll();
            if (token != null) {
                semaphore.release();
            }
            return token;
        }
    }
    
    public static void main(String[] args) {
        TokenQueue tokenQueue = new TokenQueue(5);
        try {
            for (int i = 0; i < 10; i++) {
                tokenQueue.addToken("Token " + i);
                System.out.println("Added token " + i);
            }
            for (int i = 0; i < 10; i++) {
                String token = tokenQueue.getToken();
                System.out.println("Got token: " + token);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}