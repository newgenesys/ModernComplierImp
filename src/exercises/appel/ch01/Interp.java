package exercises.appel.ch01;

import java.util.LinkedList;
import java.util.Queue;

import exercises.appel.ch01.Exp.EseqExp;
import exercises.appel.ch01.Exp.IdExp;
import exercises.appel.ch01.Exp.NumExp;
import exercises.appel.ch01.Exp.OpExp;
import exercises.appel.ch01.ExpList.LastExpList;
import exercises.appel.ch01.ExpList.PairExpList;
import exercises.appel.ch01.Inf.Exp;
import exercises.appel.ch01.Inf.ExpList;
import exercises.appel.ch01.Inf.Stm;
import exercises.appel.ch01.Stm.AssignStm;
import exercises.appel.ch01.Stm.CompoundStm;
import exercises.appel.ch01.Stm.PrintStm;

public class Interp {
	static Stm prog = new CompoundStm(
			new AssignStm("a",
					new OpExp(new NumExp(5), OpExp.Plus,
							new NumExp(3))),
			new CompoundStm(
					new AssignStm("b",
							new EseqExp(
									new PrintStm(new PairExpList(new IdExp("a"),
											new LastExpList(new OpExp(new IdExp("a"), OpExp.Minus, new NumExp(1))))),
									new OpExp(new NumExp(10), OpExp.Times, new IdExp("a")))),
					new PrintStm(new LastExpList(new IdExp("b")))));

	/**
	 * Write a Java function int maxargs(Stm s) that tells the maximum number of
	 * arguments of any print statement within any subexpressionof a given
	 * statement. For example, maxargs(prog) is 2.
	 * 
	 * @param stm
	 * @return
	 */
	public static Queue<Stm> queue = new LinkedList<Stm>();
	static int maxargs(Stm stm) {
		/* you write this part */
		queue.add(stm);
		int maxPrintNum = 0;
		
		while(!queue.isEmpty()){
			Stm s = queue.poll();
			
			if (s instanceof CompoundStm) {
				queue.add(((CompoundStm) s).stm1);
				queue.add(((CompoundStm) s).stm2);
			} else if (s instanceof AssignStm) {
				Exp exp = ((AssignStm)s).exp;
				if(exp instanceof EseqExp){
					queue.add(((EseqExp)exp).stm);
				}
			} else if (s instanceof PrintStm) {
				int curNum = traversePrintStm((PrintStm)s);
				maxPrintNum = curNum>maxPrintNum?curNum:maxPrintNum;
			}
		}
		return maxPrintNum;
	}
	
	public static int traversePrintStm(PrintStm ps){
		ExpList expList = ps.exps;
		int expCount = 0;
		Exp nextExp = null;
		ExpList nextExpList = null;
		
		while(expList instanceof PairExpList){
			//if expList is the instanceof PairExpList
			nextExp = ((PairExpList)expList).head;
			nextExpList = ((PairExpList)expList).tail;
			
			if(nextExp instanceof EseqExp){
				queue.add(((EseqExp)nextExp).stm);
			}
			expCount++;
			expList = nextExpList;
		}
		//then expList is instance of LastExpList
		nextExp = ((LastExpList)expList).head;
		if(nextExp instanceof EseqExp){
			queue.add(((EseqExp)nextExp).stm);
		}
		expCount++;
		
		return expCount;
	}
	
	static void interp(Stm s) {
		/* you write this part */
	}

	public static void main(String args[]) throws java.io.IOException {
		System.out.println("test");
		System.out.println(maxargs(prog));
//		interp(prog);
	}

}
