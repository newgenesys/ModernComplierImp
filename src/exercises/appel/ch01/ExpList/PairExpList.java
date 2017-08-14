package exercises.appel.ch01.ExpList;

import exercises.appel.ch01.Inf.Exp;
import exercises.appel.ch01.Inf.ExpList;

public class PairExpList extends ExpList {
	public Exp head;
	public ExpList tail;
	public PairExpList(Exp head, ExpList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}
}
