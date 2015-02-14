import java.util.ArrayList;
import java.util.LinkedList;

/*
 * MTree.java
 * 
 * Version: 1.0.0
 */


/**
 * Questo classe implementa un M-Tree di int.
 * 
 * @author Simone Cappabianca - 5423306
 *
 */
public class MTreeOfInt {
	
	// Properties
	
	/**
	 * Valore sentinella per indicare che il valore vuoto.
	 */
	public static final int EMPTY_VALUE = 0;
	
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
	private int tree[];

	// Constructors 
	
	/**
	 * Creo il nuovo albero di grado m e con n nodi
	 * 
	 * @param m Grado dell'albero
	 * @param n Dimensioni dell'albero(massimo numero dei nodi) 
	 */
	public MTreeOfInt (int m, int n) {
		grade = m;
		dim = n;
		this.root = false;
		tree = new int[dim];
		for (int i=0; i<dim; i++) {
			tree[i] = EMPTY_VALUE;
		}
	}
	
	// Methods
	
	/**
	 * Questo metodo controlla che il valore da inserire nel nodo rispetti i 
	 * vincoli di integritá. Possono essere assegnati solamente valori maggiori 
	 * di 0.
	 * 
	 * @param value Valure da controllare
	 * @return Restituisce true il valore rispetta i vincoli, false altrimenti
	 */
	private boolean checkValue(int value) {
		if (value > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Questo metodo controllo che la posizione del vettore sia tra quelle 
	 * posibili. 
	 * 
	 * @param father Posizione del padre 
	 * @return Restituisce
	 */
	private boolean checkPosition(int father) {
		if (father >= 0 && father < dim) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Questo metodo controllo che la posizione rispetti il grado dell'albero.
	 * 
	 * @param pos Posizione del nodo
	 * @return Restituisce true se la posizione é corretta, false altrimenti
	 */
	private boolean checkGrade(int pos) {
		if (pos > 0 && pos <= grade) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Questo metodo controlla se é stata inserita o no la radice dell'albero.
	 * 
	 * @return Restituisce true se nell'albero ha la radice, altrimenti false 
	 */
	public boolean isRoot() {
		return root;
	}
	
	/**
	 * Inserisco la nuova radice. 
	 * Il metodo controlla che non sia giá presente la root, se cosi fosse 
	 * l'inserimento da esito negativo 
	 * 
	 * @param value Valore da assegnare alla radice
	 * @return Restituisce true se la radice viene inserita, false altrimenti.
	 */
	public boolean insRoot(int value) {
		boolean res = false;
		if (!root && checkValue(value)) { 
			root = true;
			tree[0] = value;
			res = true;
			numNode++;
		}
		return res;
	}
		
	/**
	 * Inserisce un nuovo nodo specificando il valore, il padre (indicando la 
	 * la posizione) e la sua posizione come figlio (primo, secondo, ecc).
	 *  
	 * @param value Valore da assegnare al nuovo nodo
	 * @param father Posizione del padre del nuovo figlio
	 * @param pos Posizione come figlio del nuovo nodo
	 * @return Restituisce true se il nodo viene inserito, false altrimenti
	 */
	public boolean insNode (int value, int father, int pos) {
		boolean res = true;
		
		// Controllo se é presente la root
		if (root) {
			
			// L'albero ha una root
			// Controllo la validitá dei dati value, father e pos
			if (checkValue(value) && checkPosition(father) && checkGrade(pos)) {
				
				// I dati sono corretti
				// Controllo che l'albero non sia pieno
				if (numNode < dim) {
					
					// L'albero non é pieno
					// Controllo la validitá del padre
					if (tree[father] != EMPTY_VALUE) {
						
						// La posizione indicata per il padre é valida
						// Controllo se la posizione per il figlio é libera
						pos = (father*grade)+pos;
						if (tree[pos] == EMPTY_VALUE) {
							
							// La posizione indicata per il figlio é libera quindi 
							// si puó assegnare al nuovo nodo
							// Inserimento ha avuto esito positivo e incremento
							// in contatore numNode
							tree[pos] = value;
							numNode++;
						} else {
							
							// La posizione indicata per il nuovo nodo é giá
							// occupata quindi non puó essreutilizzata
							res = false;
						}
					} else {
						
						// La posizione indicata risulta essere vuota
						res = false;
					}
				} else {
					
					// L'albero é pieno
					res = false;
				}
			} else {
				
				// I dati non sono corretti
				res = false;
			}
		} else {
			
			// L'albero é privo di root
			res = false;
		}
		
		return res;
	}
	
	/**
	 * Questo metodo ricerca i nodo che contengono il valore indicato dal 
	 * parametro e ristuisce le posizioni di tali nodi.
	 * 
	 * @param value Valore del nodo da ricercare
	 * @return Ritorna un vettore valurizzato con le posizioni dei nodo che
	 * contegono il valore ricercato
	 */
	public int[] findNodePosition (int value) {
		int count = 0;
		int[] res;
		ArrayList<Integer> pos = new ArrayList<Integer>(); 
		for (int i=0; (i < dim) && (count < numNode); i++) {
			if (tree[i] != EMPTY_VALUE) {
				count++;
				if (tree[i] == value) {
					pos.add(i);
				}
			}
		}
		res = new int[pos.size()];
		for (int i=0; i < res.length; i++) {
			res[i] = pos.get(i);
		}
		return res;
	}
	
	/**
	 * Questo metodo restituisce la posizione padre del nodo individuato dalla 
	 * posizione passata come parametro. Nel caso in cui la posizione del nodo
	 * passato come parametro corrisponde alla root dell'albero allora il metodo
	 * restituisce -1. Se la posizione passata come parametro non individua 
	 * nessun nodo alla il metedo restituisce -1.
	 * 
	 * @param sonPos Poizione del nodo i cui si vuole trovare il parametro 
	 * @return Return Restituisce la posizione del padre del nodo individuato
	 * dalla posizione, altrimenti restituisce -1
	 */
	public int findFatherPosition (int sonPos) {
		/*
		 * @todo: Metodo da implementare
		 */
		int fatherPos = -1;
		
		// Controllo che il nodo di cui bisogna individuare il padre non sia
		// la root dell'albero.
		if (sonPos != 0) {
			
			// Controllo che la posizione del figlio sia tra quelle possibili
			if (checkPosition(sonPos)) {
				
				// Controllo che la posizione del nodo individui un nodo non vuoto
				if (checkValue(tree[sonPos])) {
					fatherPos = (sonPos - 1) / grade;
				}
			}
		}
		return fatherPos;
	}
	
	/**
	 * Questo metodo restituisce il valore del padre del nodo individuato dalla 
	 * posizione passata come parametro. Nel caso in cui la posizione del nodo
	 * passato come parametro corrisponde alla root dell'albero allora il metodo
	 * restituisce EMPTY_VALUE. Se la posizione passata come parametro non individua 
	 * nessun nodo alla il metedo restituisce EMPTY_VALUE.
	 * 
	 * @param sonPos Poizione del nodo i cui si vuole trovare il parametro 
	 * @return Return Restituisce la posizione del padre del nodo individuato
	 * dalla posizione, altrimenti restituisce -1 
	 */
	public int findFatherValue (int sonPos) {
		return tree[findFatherPosition(sonPos)];
	}
	
	/**
	 * Questo metodo restituisce il numero di nodi non vuoti presenti nell'albero.
	 * 
	 * @return Restituisce in numero di nodi non vuoti.
	 */
	public int countNoEmptyNode() {
		return numNode;
	}
	
	/**
	 * Questo metodo restituisce le posizione dei figlio del padre individuato 
	 * dalla posizione passata come parametro.
	 * 
	 * @param fatherPos Posizione del padre
	 * @return Restituisce un array con le posizione dei figli del padre
	 */
	public int[] getSons(int fatherPos) {
		int count = 0;
		int[] res;
		ArrayList<Integer> sons = new ArrayList<Integer>();
		for (int i=(fatherPos*grade)+1; (i < (fatherPos*grade)+grade) && (i < dim); i++) {
			if (tree[i] != EMPTY_VALUE) {
				sons.add(i);
			}
		}
		res = new int[sons.size()];
		for (int i=0; i < res.length; i++) {
			res[i] = sons.get(i);
		}
		return res;
	}
	
	/**
	 * Questo metodo implementa la visita in ampiezza dell'albero. Si utilizza
	 * una struttura ausiliaria di tipo CODA (FIFO) per morizzare i nodi da 
	 * visitare. 
	 * 
	 * @return Restituisce un array con il risultato della visita
	 */
	public int[] breadthFirstSearch() {
		/*
		 * @todo Metodo da implementare
		 * Coda (queue)
		 * enqueue (add): aggiungo un elemento alla fine della sequenza
		 * dequeue (remove): rimuovo un elemento dalla testa della sequenza
		 */
		// Coda di servizio
		LinkedList<Node> queue = new LinkedList<Node>();
		
		// Lista dei nodi
		int[] view = new int[numNode];
		int i = 0;
		
		// Controllo che l'albero non sia vuoto
		if (numNode > 0) {
			
			// L'albero non é vuoto
			// Aggiunco la radice dell'albero nella coda
			Node nRoot = new Node(tree[0], 0);
			queue.add(nRoot);
			while (!queue.isEmpty()) {
				
				// Visito i nodo presente nelle coda
				Node node = queue.remove();
				view[i] = node.value;
				
				// Recupero i figlio del nodo appena visitato e gli inserisco
				// allora volta nella coda
				int[] sons = getSons(node.pos);
				for (int s=0; s < sons.length; s++) {
					queue.add(new Node(tree[sons[s]], sons[s]));
				}
			}
		}
		/*
		 public LinkedList<T> visitaBFS(){
		LinkedList<NodoBinPF<T>> c=new LinkedList<NodoBinPF<T>>(); //coda di servizio: la simulo con una LinkedList
		LinkedList<T> listaNodi=new LinkedList<T>(); //lista nodi in uscita
		c.add(radice); // add di LinkedList aggiunge in fondo
		while (!c.isEmpty()){
			NodoBinPF<T> u=c.remove();//remove di LinkedList toglie il primo
			if(u!=null){
				listaNodi.add(u.getInfo());	// Il nodo viene ''chiuso''.
				
				c.add(u.getSin());			// Si inseriscono nella coda
				c.add(u.getDes());			// i nodi ''aperti'', da visitare.
			}
		}
		return listaNodi;
		}
		 */
		return view;
	}
	
	/**
	 * Questo metodo implementa la visita in profonditá dell'albero. Si utilizza
	 * una struttura ausiliaria di tipo PILA (LIFO) per memorizzare i nodi da 
	 * visitare.
	 *  
	 * @return Restituisce un array con il risultato della visita
	 */
	public int[] depthFirstSearch() {
		/*
		 * @todo Metodo da implementare
		 * Pila (Stack)
		 * push: aggiungo elemento alla fine della sequenza
		 * pop: rimuovo elemento dalla fine della sequanza 
		 */
		// Coda di servizio
		LinkedList<Node> stack = new LinkedList<Node>();
				
		// Lista dei nodi
		int[] view = new int[numNode];
		int i = 0;
		
		// Controllo che l'albero non sia vuoto
		if (numNode > 0) {
			
			// L'albero non é vuoto
			// Aggiunco la radice dell'albero nella coda
			Node nRoot = new Node(tree[0], 0);
			stack.push(nRoot);
			while (!stack.isEmpty()) {
				
				// Visito i nodo presente nelle coda
				Node node = stack.pop();
				view[i] = node.value;
				
				// Recupero i figlio del nodo appena visitato e gli inserisco
				// allora volta nella coda
				int[] sons = getSons(node.pos);
				for (int s=0; s < sons.length; s++) {
					stack.push(new Node(tree[sons[s]], sons[s]));
				}
			}
		}
		/*
		Visita in PROFONDITA' (anticipata) alg. iterativo.
		public LinkedList<T> visitaDFS(){
			Stack<NodoBinPF<T>> p=new Stack<NodoBinPF<T>>(); 	// Struttura di servizio.
			LinkedList<T> nodiAlbero=new LinkedList<T>();			// Conterra' i nodi visitati.
			p.push(radice);
			while (!p.isEmpty()){
				NodoBinPF<T> u=p.pop();
				if (u!=null){
					nodiAlbero.add(u.getInfo());	//	Il nodo viene ''chiuso''.
					p.push(u.getDes());			//	Si inseriscono nella pila
					p.push(u.getSin());			//	i nodo ''aperti'', da visitare.
				}
			}
			return nodiAlbero;
		}
		*/
		return view;
	}
	
	// Inner class
	
	/**
	 * Classe di servizio per la rappresentare i nodi
	 * 
	 * @author simonecappabianca
	 */
	private class Node {
		
		// Properties
		private int value;
		
		private int pos;
		
		// Constructor
		public Node(int v, int p) {
			value = v;
			pos = p;
		}
		
		// Methods
		
	}
}
