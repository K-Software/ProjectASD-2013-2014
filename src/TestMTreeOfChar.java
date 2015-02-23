/*
 * TestMTreeOfChar.java
 * 
 * Version: 1.0.0
 */

/**
 * Questa classe si occupa di effettuare tutti i test necessari per controllare
 * la correttezza della classe MTreeOfChar.
 * 
 * @author Simone Cappabianca - Mat: 5423306
 *
 */
public class TestMTreeOfChar implements TestMTree {

	// Properties
	
	// Contructors
		
	// Methods
	
	@Override
	public boolean testInsRoot() {
		
		// Creo un nuovo albero
		MTreeOfInt tree = new MTreeOfInt(20, 5);
		
		// Controllo se é giá presente la chiave se cosi fosse il test ha 
		// esito negativo
		if (tree.isRoot()) {
			return false;
		}
		
		// Provo ad inserire la root se l'inserimento non riesce allora il test
		// ha esito negativo
		if (!tree.insRoot('A')) {
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

	@Override
	public boolean testInsNode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean testFindNodePosition() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean testFindFatherPosition() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean testGetSons() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String testBreadthFirstSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String testDepthFirstSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void runTest() {
		// TODO Auto-generated method stub

	}

}
