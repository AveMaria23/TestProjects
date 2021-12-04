package com.Test;

import java.util.Scanner;

public class ut {
    char[][] hall;
    int r;
    int n;

    public void menu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit\n");

        int num = sc.nextInt();

        if (num == 1){
            ut.show(n, r, hall);
        }
        else if (num == 2){
            System.out.println("Enter a row number:");
            int r1 = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            int n1 = sc.nextInt();
            System.out.println("");
            ut.buy(n, r, n1, r1, hall);
        }
        else if (num == 0){
            System.exit(0);
        }
    }

    public static void show(int n, int r, char hall[][]) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= n; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        for (int i = 1; i <= r; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print("" + hall[i][j] + ' ');
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void buy(int n, int r, int n1, int r1, char[][] hall) {
        int price;
        if (n*r <= 60){
            price = 10;
        }
        else {
            if (r % 2 == 0) {
                if (r1 <= r / 2) {
                    price = 10;
                } else {
                    price = 8;
                }
            } else {
                if (r1 < r / 2 + 1) {
                    price = 10;
                } else {
                    price = 8;
                }
            }
        }
        System.out.println("Ticket price: $" + price);
        System.out.println("");
        hall[r1][n1] = 'B';
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        r = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        n = sc.nextInt();

        hall = new char[r+1][n+1];// Create cinema hall
        hall[0][0] = ' ';
        for (int i = 1; i < r + 1; i++) {
            hall[i][0] = (char)(i + '0');
        }
        for (int i = 1; i < n + 1; i++) {
            hall[0][i] = (char)(i + '0');
        }
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                hall[i][j] = 'S';
            }
        }
    }
}
