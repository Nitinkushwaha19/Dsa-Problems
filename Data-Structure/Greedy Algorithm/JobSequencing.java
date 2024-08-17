import java.util.*;

public class JobSequencing {
    static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int i, int d, int p) {
            this.id = i;
            this.deadline = d;
            this.profit = p;
        }
    }

    public static void main(String[] args) {
        int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Sort based on profit --- (desecending order)
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        int time = 0;
        ArrayList<Integer> seq = new ArrayList<>();

        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println("Maximum jobs : " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
        
    }
}
