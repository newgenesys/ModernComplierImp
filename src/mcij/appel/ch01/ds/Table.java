package mcij.appel.ch01.ds;

/**
 *  Represent a ��table,�� mapping identifiers to the integer values
 *  assigned to them, as a list of id �� int pairs
 *  It dosen't mean to be unique.
 * @author Deng Li
 * @version 2017��8��16������12:49:34
 */
public class Table {
	public String id;
	public int value;
	public Table tail;

	public Table(String i, int v, Table t) {
		id = i;
		value = v;
		tail = t;
	}
	
}
