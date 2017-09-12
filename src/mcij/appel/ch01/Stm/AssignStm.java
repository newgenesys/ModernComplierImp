package mcij.appel.ch01.Stm;

import mcij.appel.ch01.Inf.Exp;
import mcij.appel.ch01.Inf.Stm;

public class AssignStm extends Stm {
	public String id;
	public Exp exp;
	public AssignStm(String i, Exp e){
		id = i;
		exp = e;
	}
}
