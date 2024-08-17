import java.util.*;

public class ClassRoom {

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        // Swapping two numbers
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);

        System.out.println(list);

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Adding element to list
        list.add(2); // O(1)
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        // list.add(1,9); // O(n)

        // System.out.println(list);

        // to access element of arraylist // O(1)
        // System.out.println(list.get(2));

        // To remove element from list
        // list.remove(2); // O(n)

        // To set the element at particular position
        // list.set(1, 23);

        // return true or false whether the element is contain in list or not
        // System.out.println(list.contains(1));

        // Return the size of list
        // System.out.println(list.size());

        // To print the array list
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < list.size(); i++) {
        // if (max < list.get(i)) {
        // max = list.get(i);
        // }
        // }
        // System.out.print("maximum : " + max);

        // swapping function
        // swap(list,1,3);

        // To sort the Arraylist
        // Collections.sort(list); // ascending order
        // Collectisut.println(list);

        // Multi-dimensional arraylist
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list1.add(i * 1);
            list2.add(i * 2);
            list3.add(i * 3);
        }

        list2.remove(2);
        list2.remove(3);

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        

        // System.out.println(mainList);

        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }
}