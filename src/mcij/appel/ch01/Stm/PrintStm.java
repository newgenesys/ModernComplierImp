package mcij.appel.ch01.Stm;

import mcij.appel.ch01.Inf.ExpList;
import mcij.appel.ch01.Inf.Stm;

public class PrintStm extends Stm {
	public ExpList exps;
	public PrintStm(ExpList e){
		exps = e;
	}
}
