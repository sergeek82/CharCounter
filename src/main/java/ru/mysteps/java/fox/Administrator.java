package ru.mysteps.java.fox;

import ru.mysteps.java.fox.cache.SimpleCache;
import ru.mysteps.java.fox.formatter.CharacterFrequencyFormatter;
import ru.mysteps.java.fox.calculator.Calculator;
import ru.mysteps.java.fox.facade.CharCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Administrator {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String answer = "";
            CharCounter counter = new CharCounter(new Calculator(), new CharacterFrequencyFormatter(), new SimpleCache());
            while (!answer.equalsIgnoreCase("N")) {
                System.out.println("Good choice!!! Just type few symbols to get started!");
                String inString = reader.readLine();
                System.out.println(counter.count(inString));
                System.out.println("Would you like to continue?\n\"NO\" >> press \"n\" or \"N\"");
                System.out.println("\"YES\" >> press \"Enter\"");
                answer = reader.readLine();
            }
        } catch (IOException e) {
            System.err.printf("It was bad Sys_In reading ", e);
        }
    }
}
