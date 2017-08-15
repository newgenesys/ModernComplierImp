package exercises.appel.ch01.Stm;

import exercises.appel.ch01.Inf.ExpList;
import exercises.appel.ch01.Inf.Stm;

public class PrintStm extends Stm {
	public ExpList exps;
	public PrintStm(ExpList e){
		exps = e;
	}
}
