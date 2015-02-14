/*
 * TestMTree.java
 * 
 * Version: 1.0.0
 */

/**
 * Questa classe si occupa di effettuare tutti i test necessari per controllare
 * la correttezza della classe MTreeOfInt.
 * 
 * @author Simone Cappabianca - Mat: 5423306
 *
 */
public class TestMTreeOfInt {

	// Properties
	
	// Contructors
	
	// Methods
		
	/**
	 * Questo metodo effettua i test di correttezza per il metodo insRoot
	 * della classe MTree.<br>
	 * Il metodo effettua i seguenti controlli:
	 * <ul>
	 * <li>crea un nuovo MTreeOfInt e controllo se é giá presente una root;</li>
	 * <li>prova a inserire 2 volte la root.</li>
	 * </ul>
	 * 
	 * @return Restituisce true se i controlli hanno esito positivo, 
	 * false altrimenti.
	 */
	private boolean testInsRoot() {
		
		// Creo un nuovo albero
		MTreeOfInt tree = new MTreeOfInt(20, 5);
		
		// Controllo se é giá presente la chiave se cosi fosse il test ha 
		// esito negativo
		if (tree.isRoot()) {
			return false;
		}
		
		// Provo ad inserire la root se l'inserimento non riesce allora il test
		// ha esito negativo
		if (!tree.insRoot(1)) {
			return false;
		}
		
		// Provo ad inserire nuovamente una nuova root se l'inserimento riesce 
		// il test ha esito negativo
		if (tree.insRoot(1)) {
			return false;
		}
		
		// Il test del metodo ha avuto esito positivo
		return true;
	}
	
	/**
	 * Questo metodo effettua i test dell metodo insNode della classe 
	 * MTreeOfInt.<br>
	 * I controllo effettuati sono:
	 * <ul>
	 * <li>controllo se l'albero ha una root;</li>
	 * <li>controllo la correttezza dei dei parametri value, father e pos;</li>
	 * <li>controllo se il padre del nuovo nodo esiste;</li>
	 * <li>controllo se la posizione del nuovo nodo é libera;</li>
	 * <li>controllo che l'albero non sia pieno.</li>
	 * </ul>
	 * 
	 * @return Restituisce true se i controlli hanno esito positivo, 
	 * false altrimenti.
	 */
	private boolean testInsNode() {
		
		// Creo un nuovo albero di grado 5 e dimensione 10
		MTreeOfInt tree = new MTreeOfInt(5, 10);
		
		// Inserisco un nuovo nodo in un albero privo di root se l'inserimento 
		// ha esito positivo il test ha esisto negativo
		if (tree.insNode(1, 2, 3)) {
			return false;
		}
		
		// Inserisco la root
		tree.insRoot(1);
		
		// Inserisco un nodo con valori dei parametri talmente sbagliati se
		// inserimento ha esito positivo il test ha esito negativo
		if (tree.insNode(-2, 12, 6)) {
			return false;
		}
		
		// Inserisco un nuovo nodo ad un padre inesistente se l'inserimento ha 
		// esito positivo il test ha esito negativo
		if (tree.insNode(2, 5, 1)) {
			return false;
		}
		
		// Inserisco un nodo con padre e posizione corretta se l'inserimento 
		// ha esito negativo allora il test ha esito negativo
		if (!tree.insNode(2, 0, 1)) {
			return false;
		}
		
		// Inserisco un nuovo nodo con padre e posizione corretta ma con la 
		// posizione giá assegnata se l'inserimento ha esito positivo il test
		// ha esito negativo
		if (tree.insNode(2, 0, 1)) {
			return false;
		}
		
		// Riempio tutto l'albero
		if (!tree.insNode(3, 0, 2)) {
			return false;
		}
		if (!tree.insNode(4, 0, 3)) {
			return false;
		}
		if(!tree.insNode(5, 0, 4)) {
			return false;
		}
		if(!tree.insNode(6, 0, 5)) {
			return false;
		}
		if(!tree.insNode(7, 1, 1)) {
			return false;
		}
		if(!tree.insNode(8, 1, 2)) {
			return false;
		}
		if(!tree.insNode(9, 1, 3)) {
			return false;
		}
		if(!tree.insNode(10, 1, 4)) {
			return false;
		}
		
		// Inserisco un nuovo nodo con padre e posizione corretta ma con l'albero
		// completo, se l'inserimento ha esito positivo il test ha esito negativo
		if (tree.insNode(11, 1, 5)) {
			return false;
		}
		
		// Il test del metodo ha avuto esito positivo
		return true;
	}
	
	/**
	 * Questo metodo si occupa di testare il metedo findNodePosition della classe 
	 * MTreeOfInt.<br>
	 * I controlli effettuati sono:
	 * <ul>
	 * <li>controllo se restituisce la posizione corretta di un valore presente
	 * all'interno dell'albero;</li>
	 * <li>controllo se non restituisce alcuna posizione per un valore non 
	 * presente non presente nell'albero;</li>
	 * <li>controllo se restituisce tutte le posizione di un valore presente 
	 * piú volte all'interno dell'albero.</li>
	 * </ul>
	 * 
	 * @return Restituisce true se i controlli hanno esito positivo, 
	 * false altrimenti.
	 * @return
	 */
	private boolean testFindNodePosition() {
		
		// Vettore con la lista delle posizioni dello occorenze del valore 
		// ricercato
		int[] listOccor;
		
		// Creo un nuovo albero di grado 5 e dimensione 10
		MTreeOfInt tree = new MTreeOfInt(5, 10);
		
		// Inserisco la root con valore 1
		tree.insRoot(1);
		
		// Ricerco il valore 1 presente nell'albero, se il metodo restiuisce 
		// un vettore vuoto il test ha esito negativo
		listOccor = tree.findNodePosition(1);
		if (listOccor.length == 0) {
			return false;
		}
		
		// Controllo che la posizione che il metodo ritorna sia quella corretta
		// altrimenti il test ha esito negativo
		if (listOccor[0] != 0) {
			return false;
		}
		
		// Ricerco un valore non presente nell'albero se il metodo restituisce 
		// una o piú posizione il test ha esito negativo
		listOccor = tree.findNodePosition(2);
		if (listOccor.length != 0) {
			return false;
		}
		
		// Inserisco due nodi con lo stesso valore
		tree.insNode(2, 0, 1);
		tree.insNode(2, 0, 4);
		
		// Ricerco il valore 2 presente 2 volte all'interno dell'albero se il 
		// metodo non restituisce esattemente due posizione il test ha esito
		// negativo
		listOccor = tree.findNodePosition(2);
		if (listOccor.length != 2) {
			return false;
		}
		
		// Controllo che le posizioni restituite dal metodo siano quelle corette
		// se le posizione non sono corrette il test ha esito negativo
		if (listOccor[0] != 1 || listOccor[1] != 4) {
			return false;
		}
		
		// Il test del metodo ha avuto esito positivo
		return true;
	}
	
	/**
	 * Questo metodo si occupa di testare il metodo findFatherPosition della 
	 * classe MTreeOfInt.<br>
	 * I controlli effettuati sono:
	 * <ul>
	 * <li>controllo che la pasizione passata come parametro sia una posizione 
	 * valida;</li>
	 * <li>controllo che la posizione passata come parametro individui un nodo
	 * non vuoto;</li>
	 * <li>controllo che restituisca -1 se la posizione passata come parametro
	 * corrisponde alla root dell'albero;</li>
	 * <li>controllo che la posizione che restituisce sia corretta.</li>
	 * </ul>
	 * 
	 * @return Restituisce true se i controlli hanno avuto esito positivo,
	 * false altrimenti.
	 */
	private boolean testFindFatherPosition() {
		
		// Creo un nuovo albero di grado 5 e dimensione 10
		MTreeOfInt tree = new MTreeOfInt(5, 10);
		
		// Inserisco la root con valore 1
		tree.insRoot(1);
		
		// Ricerco il padre di un nodo con una posizione non ammessa se il 
		// metodo restituisce in una posizione diversa da -1 il test ha esito 
		// negativo
		if (tree.findFatherPosition(100) != -1) {
			return false;
		}
		
		// Ricerco il padre della radice se il metodo restituisce una posizione
		// diversa da -1 il test ha esito negativo
		if (tree.findFatherPosition(0) != -1) {
			return false;
		}
		
		// Ricerco il padre di una posizione non ancora assegna a nessun nodo
		// se il metodo restituisce una posizione diversa da -1 il test ha 
		// esito negativo
		if  (tree.findFatherPosition(2) != -1) {
			return false;
		}
		
		// Inserisco 2 nuovi nodi
		tree.insNode(1, 0, 1);
		tree.insNode(2, 1, 2);
		
		// Ricerco il padre di due node di cui conosco la posizione dei 
		// rispettivi padri se il metodo restituisce posizione diverse da quelle
		// corrette il test ha esito negativo
		if ((tree.findFatherPosition(1) != 0) 
				&& (tree.findFatherPosition(7) != 1)) {
			return false;
		}
		
		// Il test del metodo ha avuto esito positivo
		return true;
	}
	
	
	/**
	 * Questo metodo si occupa di testare il metodo getSons della classe 
	 * MTreeOfInt.<br>
	 * I controlli effettuati sono:
	 * <ul>
	 * <li>controllo che la pasizione passata come parametro sia una posizione 
	 * valida;</li>
	 * <li>controllo che la posizione passata come parametro individui un nodo
	 * non vuoto;</li>
	 * <li>controllo che restituisca il numero giusto di figli;</li>
	 * </ul>
	 * 
	 * @return Restitusce true se i test hanno avuto esito positivo, false 
	 * altrimenti.
	 */
	private boolean testGetSons() {
		
		// Creo un nuovo albero di grado 5 e dimensione 10
		MTreeOfInt tree = new MTreeOfInt(5, 10);
				
		// Inserisco la root con valore 1
		tree.insRoot(1);
		
		// Recupre i figli di un padre con una posizione non ammessa se il 
		// metodo restituisce un array di non vuoto il test ha esito negativo
		if (tree.getSons(100).length != 0) {
			return false;
		}
		
		// Ricerco i figli di un padre la cui posizione individua una posizione 
		// vuota se il metodo restituisce un array di non vuoto il test ha esito 
		// negativo
		if (tree.getSons(100).length != 0) {
			return false;
		}
		
		tree.insNode(1, 0, 1);
		tree.insNode(2, 0, 2);
		tree.insNode(6, 1, 1);
		tree.insNode(8, 1, 3);
		tree.insNode(9, 1, 4);
		
		// Controllo che il numero dei figlio sia corretto
		int[] sonsOfNode0 = tree.getSons(0);
		int[] sonsOfNode1 = tree.getSons(1);
		if ((sonsOfNode0.length != 2) || (sonsOfNode1.length != 3)) {
			return false;
		}
		
		// Controllo che le posizioni dei figli recuperate siano quelle corrette
		if ((sonsOfNode0[0] != 1) || (sonsOfNode0[1] != 2) || (sonsOfNode1[0] != 6) || 
				(sonsOfNode1[1] != 8) || (sonsOfNode1[2] != 9)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean testBreadthFirstSearch() {
		/*
		 * @todo Metodo da implementare
		 */
		MTreeOfInt tree = new MTreeOfInt(5, 10);
		tree.insRoot(0);
		tree.insNode(1, 0, 1);
		tree.insNode(2, 0, 2);
		tree.insNode(3, 0, 3);
		tree.insNode(4, 0, 4);
		tree.insNode(5, 0, 5);
		tree.insNode(6, 1, 1);
		tree.insNode(7, 1, 2);
		tree.insNode(8, 1, 3);
		tree.insNode(9, 1, 4);
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean testDepthFirstSearch() {
		/*
		 * @todo Metodo da implementare
		 */
		return true;
	}
	
	/**
	 * Questo metodo esegue i test della classe
	 */
	public void runTest() {
		System.out.println("Test MTreeOfInt");
		System.out.println("Test inserimento root: " + testInsRoot());
		System.out.println("Test inserimento nodo: " + testInsNode());
		System.out.println("Test ricerca posizione node: " + testFindNodePosition());
		System.out.println("Test ricerca posizione padre: " + testFindFatherPosition());
		System.out.println("Test ricerca figli di un padre: " + testGetSons());
	}
}
