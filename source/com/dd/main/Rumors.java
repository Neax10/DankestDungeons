package com.dd.main;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Rumors {
    private Scanner in = new Scanner(System.in);
    private boolean gotrumor;
    private Random rand = new Random();

    public void listenForARumor (){
        LocalDateTime now = LocalDateTime.now();
        Player player = Player.getPlayer();
        int hour = now.getHour();
        System.out.println(hour);
        float chance = rand.nextFloat();
        if(hour >= 10){
            if(chance >= 0.75){
                System.out.println("du hast 1 nices gerücht am beentun gehöat");
                int rumorID = (int)(rand.nextFloat() * 10 + 1);
                System.out.println(rumorID);
                gotrumor = true;
            }
            else System.out.println("spasti du kannst nicht zuhören");

        }
        if(gotrumor == true){
            System.out.println("%QUESTNAME%");
            System.out.println("Do you want to follow up the rumor?");
            System.out.println("[1] Yes");
            System.out.println("[2] No");
            int answer = in.nextInt();
            in.nextLine();
            if(answer == 1){
                player.setOnquest(true);
            }
        }
    }

}
