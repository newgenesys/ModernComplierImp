package exercises.appel.ch01;

/**
 *  Represent a “table,” mapping identifiers to the integer values
 *  assigned to them, as a list of id × int pairs
 * @author Deng Li
 * @version 2017年8月16日下午12:49:34
 */
public class Table {
	String id;
	int value;
	Table tail;

	Table(String i, int v, Table t) {
		id = i;
		value = v;
		tail = t;
	}
	
}
