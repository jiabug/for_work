package Stacks_and_Queues;
/*
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes 
 * which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from
 * top to bottom(i.e., each disk sits on top of an even larger one). You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto the next tower.
 * (3) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 */
public class e4 {

	public static void main(String[] args) {
		int n = 3;
		Tower[] tower = new Tower[n];
		for (int i = 0;i < 3; i++){
			tower[i] = new Tower(i);
		}
		for (int i = n - 1; i >= 0; i--){// a disk must be placed on the top of a larger disk
			tower[0].add(i);
		}
		tower[0].moveDisk(n, tower[2], tower[1]);
	}
}

class Tower{
	private Stack s;
	private int index;
	public Tower(int i){
		index = i;
		s = new Stack();
	}
	
	public int index(){
		return index;
	}
	
	public void add(int item){
		if (!s.isEmpty() && s.peek() <= item){
			System.out.println("Error placing disk" + item);
		} else {
			s.push(item);
		}
	}
	
	public void moveTopTo(Tower t){
		int value = s.pop();
		t.add(value);
		System.out.println("Move disk " + value + " from " + index() + " to " + t.index());
	}
	
	public void moveDisk(int n, Tower destination, Tower buffer){
		if (n > 0){
			moveDisk(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisk(n - 1, destination, this);
		}
	}
}





