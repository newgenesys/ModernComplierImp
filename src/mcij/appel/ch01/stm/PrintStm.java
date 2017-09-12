package mcij.appel.ch01.stm;

import mcij.appel.ch01.inf.ExpList;
import mcij.appel.ch01.inf.Stm;

public class PrintStm extends Stm {
	public ExpList exps;
	public PrintStm(ExpList e){
		exps = e;
	}
}
