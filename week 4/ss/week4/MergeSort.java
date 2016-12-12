package ss.week4;

import java.util.*;

public class MergeSort {
    public static <E extends Comparable<E>> void mergesort(List<E> list) {
    	if (list.size() > 1) {
    	    List<E> temp = list.subList(0, list.size() / 2);

    	    ArrayList<E> left = new ArrayList<E>(0);
    	    for (E e : temp) {
    	    	left.add(e);
    	    }

    	    temp = list.subList(list.size() / 2, list.size());

    	    ArrayList<E> right = new ArrayList<E>(0);
    	    for (E e : temp) {
    	    	right.add(e);
    	    }

    	    if (right.size() != 1) {
				mergesort(right);
			}
    	    if (left.size() != 1) {
				mergesort(left);
			}

    	    list.clear();
    	    list.addAll(mergeSortedLists(left, right));
    	}
    }
    
    public static <E extends Comparable<E>> List<E> mergeSortedLists(List<E> leftList,
    		List<E> rightList) {
    	ArrayList<E> list = new ArrayList<E>();

    	while (!leftList.isEmpty() && !rightList.isEmpty()) {
    		if ((leftList.get(0)).compareTo(rightList.get(0)) <= 0) {
    			list.add(leftList.remove(0));
    		} else {
    			list.add(rightList.remove(0));
    		}
    	}
    	while (!leftList.isEmpty()) {
    		list.add(leftList.remove(0));
    	}
    	while (!rightList.isEmpty()) {
    		list.add(rightList.remove(0));
    	}
    	return list;
    }
}
// {1,4,5,6,1,3,3,56,1,2,3}
// {1,4,5,6,1} {3,4,56,1,2,3}