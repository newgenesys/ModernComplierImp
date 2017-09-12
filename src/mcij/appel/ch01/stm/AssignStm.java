package mcij.appel.ch01.stm;

import mcij.appel.ch01.inf.Exp;
import mcij.appel.ch01.inf.Stm;

public class AssignStm extends Stm {
	public String id;
	public Exp exp;
	public AssignStm(String i, Exp e){
		id = i;
		exp = e;
	}
}
