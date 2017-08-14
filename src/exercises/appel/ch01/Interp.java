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

	static int maxargs(Stm stm) {
		/* you write this part */

		// if(s instanceof CompoundStm){
		// Stm stm1 = ((CompoundStm) s).stm1;
		// Stm stm2 = ((CompoundStm) s).stm2;
		// return Math.max(maxargs(stm1), maxargs(stm2));
		// }else if(s instanceof AssignStm){
		// return 0;
		// }else if(s instanceof PrintStm){
		// ExpList expList = ((PrintStm) s).exps;
		// if(expList instanceof LastExpList){
		// Exp head = ((LastExpList) expList).head;
		//
		// if(head instanceof EseqExp){// means that there are at least 2 args
		// Stm ss = ((EseqExp) head).stm;
		// int max_inside_stm = maxargs(ss);
		// return Math.max(2, max_inside_stm);
		// }else{// IdExp, NumExp, OpExp
		// return 1;
		// }
		// }else if(expList instanceof PairExpList){
		// Exp head = ((PairExpList) expList).head;
		// ExpList tail = ((PairExpList) expList).tail;
		//
		// int current_num =
		//
		// }
		// }

		Queue<Stm> queue = new LinkedList<Stm>();
		queue.add(stm);
		int maxPrintNum = 0;
		
		
		while(!queue.isEmpty()){
			Stm s = queue.poll();
			
			if (stm instanceof CompoundStm) {
				queue.add(((CompoundStm) stm).stm1);
				queue.add(((CompoundStm) stm).stm2);
			} else if (stm instanceof AssignStm) {
				continue;
			} else if (stm instanceof PrintStm) {
				
			}
			
		}
		return 0;
	}

	public static int vistExp(Exp exp) {

		if (exp instanceof EseqExp) {

		} else {
			return 0;
		}

		return 0;
	}

	public static int visitPairExpList(ExpList exps) {

		if (exps instanceof LastExpList) {

		} else if (exps instanceof PairExpList) {

		}

		return 0;
	}

	public static int get_maxargs_from_exp(Exp e) {

		if (e instanceof EseqExp) {
			Stm s = ((EseqExp) e).stm;
			return maxargs(s);
		} else {// IdExp, NumExp, OpExp,
			return 1;
		}
	}

	static void interp(Stm s) {
		/* you write this part */
	}

	public static void main(String args[]) throws java.io.IOException {
		System.out.println(maxargs(prog));
		interp(prog);
	}

}
