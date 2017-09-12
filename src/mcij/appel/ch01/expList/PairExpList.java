package mcij.appel.ch01.expList;

import mcij.appel.ch01.inf.Exp;
import mcij.appel.ch01.inf.ExpList;

public class PairExpList extends ExpList {
	public Exp head;
	public ExpList tail;
	public PairExpList(Exp head, ExpList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}
}
