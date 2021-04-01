package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainV2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            int margin = 0;
            int currentStreak = 0;
            List<Integer> streaksLength = new ArrayList<>();
            for (int j = 0; j < 1000; j++) {
                if (rnd.nextBoolean()){
                    currentStreak++;
                }
                else {
                    if (currentStreak>0){
                        streaksLength.add(currentStreak);
                        currentStreak = 0;
                    }

                }
            }
            double average = 0;
            if (streaksLength.size()!=0){
                int sum = 0;
                for (Integer item:streaksLength) {
                    sum+=item;
                }
                average = ((double)sum)/streaksLength.size();
            }



            System.out.println("Average streak = " + average);
        }
    }
}
