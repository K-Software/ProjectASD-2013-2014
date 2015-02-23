/*
 * MTreeOfChar.java
 * 
 * Version: 1.0.0
 */

/**
 * Questo classe implementa un M-Tree di char.
 * 
 * @author Simone Cappabianca - Mat: 5423306
 *
 */
public class MTreeOfChar {

	// Properties
	
	/**
	 * Valore sentinella per indicare che il valore vuoto.
	 */
	public static final char EMPTY_VALUE = ' ';
	
	/**
	 * Questa proprietá indica il grado dell'albero.
	 */
	private int grade;
	
	/**
	 * Questa proprietá indica il numero dei nodi dell'albero.
	 */
	private int dim;
	
	/**
	 * Numero di nodi presenti nell'albero.
	 */
	private int numNode;
	
	/**
	 * Questa proprietá indica se l'albero é presente (true) o no (false) la
	 * radice.
	 */
	private boolean root;
	
	/**
	 * Albero M-ario
	 */
	private char tree[];
	
	// Constructors 
	
	/**
	 * Creo il nuovo albero di grado m e con n nodi
	 * 
	 * @param m Grado dell'albero
	 * @param n Dimensioni dell'albero(massimo numero dei nodi) 
	 */
	public MTreeOfChar (int m, int n) {
		grade = m;
		dim = n;
		this.root = false;
		tree = new char[dim];
		for (int i=0; i<dim; i++) {
			tree[i] = EMPTY_VALUE;
		}
	}
	
	/**
	 * Questo metodo controlla che il valore da inserire nel nodo rispetti i 
	 * vincoli di integritá. Possono essere assegnati solamente valori 
	 * A,B,C,D,E,F,G,H,I,J,K,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,
	 * m,n,o,p,q,r,s,t,u,v,w,x,y,z.
	 * 
	 * @param value Valure da controllare
	 * @return Restituisce true il valore rispetta i vincoli, false altrimenti
	 */
	private boolean checkValue(char value) {
		// @TODO: implementare il metodo con la regolar expression
		return false;
	}
}
