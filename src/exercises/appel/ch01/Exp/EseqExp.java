package exercises.appel.ch01.Exp;

import exercises.appel.ch01.Inf.Exp;
import exercises.appel.ch01.Inf.Stm;

public class EseqExp extends Exp {
	public Stm stm;
	public Exp exp;
	public EseqExp(Stm stm, Exp exp) {
		super();
		this.stm = stm;
		this.exp = exp;
	}
	
}
