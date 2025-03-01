/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mazesolver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
//import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author ADMIN
 */
public class NewClass extends JFrame{
    private int[][] maze = 
    {{1,1,1,1,1,1,1,1,1,1,1,1,1},
     {1,0,1,0,1,0,1,0,0,0,0,0,1},
     {1,0,1,0,0,0,1,0,1,1,1,0,1},
     {1,0,1,1,1,1,1,0,0,0,0,0,1},
     {1,0,0,1,0,0,0,0,1,1,1,0,1},
     {1,0,1,0,1,1,1,0,1,0,0,0,1},
     {1,0,1,0,1,0,0,0,1,1,1,0,1},
     {1,0,1,0,1,1,1,0,1,0,1,0,1},
     {1,0,0,0,0,0,0,0,0,0,1,9,1},
     {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    public List<Integer> path = new ArrayList<>();
    
    public NewClass(){
        setTitle("Maze Solver");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchpath(maze, 1, 1, path);
//        System.out.println(path);
    }
    @Override
//    we are changing the implimentation of paint function
    public void paint(Graphics g){
        g.translate(50,50);
//        translate the graphiscs to start from x, y cordinate
        
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                Color color;
                switch(maze[i][j]){
                    case 1: color = Color.BLACK;break;
                    case 9: color = Color.RED;break;
                    default: color=Color.WHITE;break;
                }
                g.setColor(color);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.RED);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }
        for(int i=0; i<path.size(); i+=2){
            //array contains x1, y1, x2, y2 so next x is at +2 position
            int pathx =path.get(i);
            int pathy = path.get(i+1);
            
//            System.out.println("Xcordinates "+pathx);
//            System.out.println("Y/cordinates "+pathy);
            
            g.setColor(Color.GREEN);
            g.fillRect(30 * pathx + 5,30*pathy + 5, 20, 20);
        }
    }
    
    public static void main(String[] args){
        NewClass view = new NewClass();
        view.setVisible(true);
        
    }
}
