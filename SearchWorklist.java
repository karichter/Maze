/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */
import java.util.*;

class StackWorklist implements SearchWorklist {
	Stack<Square> stack;
	StackWorklist() {
		this.stack = new Stack<Square>();
	}
	public void add(Square c) {
		stack.push(c);
	}
	public Square remove() {
		return stack.pop();
	}
	public boolean isEmpty() {
		return stack.size() == 0;
	}
}

class QueueWorklist implements SearchWorklist {
	Queue<Square> queue;
	QueueWorklist() {
		this.queue = new LinkedList<>();
	}
	public void add(Square c) {
		queue.add(c);
	}
	public Square remove() {
		return queue.remove();
	}
	public boolean isEmpty() {
		return queue.size() == 0;
	}
}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
}
