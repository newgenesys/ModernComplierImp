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
				FindPrintStmFromExp(exp);
			} else if (s instanceof PrintStm) {
				int curNum = traversePrintStm((PrintStm)s);
				maxPrintNum = curNum>maxPrintNum?curNum:maxPrintNum;
			}
		}
		return maxPrintNum;
	}
	
	/**
	 * traverse the PrintStm, and if there are some other printStme, add to the queue
	 * @param ps
	 * @return
	 */
	public static int traversePrintStm(PrintStm ps){
		ExpList expList = ps.exps;
		int expCount = 0;
		Exp nextExp = null;
		ExpList nextExpList = null;
		
		while(expList instanceof PairExpList){
			//if expList is the instanceof PairExpList
			nextExp = ((PairExpList)expList).head;
			nextExpList = ((PairExpList)expList).tail;
			
			FindPrintStmFromExp(nextExp);
			expCount++;
			expList = nextExpList;
		}
		//then expList is instance of LastExpList
		nextExp = ((LastExpList)expList).head;
		FindPrintStmFromExp(nextExp);
		expCount++;
		
		return expCount;
	}
	
	/**
	 * check if there are PrintStm in a given Exp
	 * @param nextExp
	 */
	private static void FindPrintStmFromExp(Exp nextExp) {
		if(nextExp instanceof EseqExp){
			queue.add(((EseqExp)nextExp).stm);
		}
	}
	
	
	/**
	 * Write a Java function void interp(Stm s) that ¡°interprets¡± a program
	 * in this language. To write in a ¡°functional programming¡± style ¨C in which
	 * you never use an assignment statement ¨C initialize each local variable as you
	 * declare it.
	 * @param s
	 */
	static void interp(Stm stm) {
		/* you write this part */
//		Table t = new Table(null,null,null);
//		interpStm(stm,t);
		
	}
	
	static Table interpStm(Stm stm, Table t){
		
		if(stm instanceof AssignStm){
			String id = ((AssignStm)stm).id;
			Exp exp = ((AssignStm)stm).exp;
			IntAndTable result = interpExp(exp,t);
			
		}else if(stm instanceof CompoundStm){
			
		}else if(stm instanceof PrintStm){
			
		}
		
		return new Table("",1,t);
	}
	
	static IntAndTable interpExp(Exp e, Table t){
		
		return new IntAndTable(0,t);
	}
	
	/**
	 * update the value of id
	 * @param t
	 * @param id
	 * @param value
	 * @return
	 */
	static Table update(Table t, String id, int value){
		Table tempTable = new Table(id,value,t);
		return tempTable;
	}
	
	/**
	 * lookup value
	 * @param t
	 * @param key
	 * @return value of key
	 */
	static int lookup(Table t, String key){
		String id = t.id;
		int value = 0;
		Table temp = t;
		while(id!=key){
			temp = t.tail;
		}
		value = temp.value;
		return value;
	}
	
	public static void main(String args[]) throws java.io.IOException {
		System.out.println(maxargs(prog));
		
		System.out.println("-----------start interp--------------");
//		interp(prog);
		interp(prog);
		
	}

}
