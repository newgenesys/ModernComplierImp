package mcij.appel.ch01.exp;

import mcij.appel.ch01.inf.Exp;
import mcij.appel.ch01.inf.Stm;

public class EseqExp extends Exp {
	public Stm stm;
	public Exp exp;
	public EseqExp(Stm stm, Exp exp) {
		super();
		this.stm = stm;
		this.exp = exp;
	}
	
}
