
/**
 * 
 * @author simonecappabianca
 *
 */
public interface Test {

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
	public boolean testInsRoot();
	
	/**
	 * Questo metodo effettua i test dell metodo insNode della classe 
	 * MTree.<br>
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
	public boolean testInsNode();
	
	/**
	 * Questo metodo si occupa di testare il metedo findNodePosition della classe 
	 * MTree.<br>
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
	 */
	public boolean testFindNodePosition();
	
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
	public boolean testFindFatherPosition();
	
	/**
	 * Questo metodo si occupa di testare il metodo getSons della classe 
	 * MTree.<br>
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
	public boolean testGetSons();
	
	/**
	 * Questo metodo si occupa di testare il metodo breadthFirstSearch della 
	 * classe MTree.
	 * 
	 * @return Restituisce la visita in ambiezza della albero inserito per test
	 */
	public String testBreadthFirstSearch();
	
	/**
	 * Questo metodo si occupa di testare il metodo depthFirstSearch della 
	 * classe MTree.
	 * 
	 * @return Restituisce la visita in profonditá della albero inserito per test
	 */
	public String testDepthFirstSearch();
	
	/**
	 * Questo metodo esegue i test della classe
	 */
	public void runTest();
}
