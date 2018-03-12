import java.util.Map;

public class CompteCourant extends Compte{
	/**
	 * le solde Max est une valeur négative que le compte ne doit jamais dépasser
	 */
	private Float soldeMax;
	
	public CompteCourant(Integer numero, Float solde, Float soldeMax) {
		super(numero, solde);
		this.soldeMax = soldeMax;
	}

	@Override
	/**
	 * Le  nombre de signataire ne doit jamais dépasser 4
	 */
	public boolean addSignataires(Client client) {
		// TODO Auto-generated method stub
		if(super.getSignataires().size()<4)
		{ this.getSignataires().add(client); }
		return false ;
	}

	@Override
	public boolean removeSignataires(Integer id) {
		// TODO Auto-generated method stub
		for (Client signataires : this.getSignataires()) {
			this.getSignataires().remove(signataires.getId().equals(id));
		}
		return false;

	}
	/**
	 * Recalcule le solde 
	 */
	@Override
	public boolean addOperation(Operation operation) {
		// TODO Auto-generated method stub
		this.getListeOperations().put(operation.getDate(),operation);

		return false;
	}
	




    /**
     * Une méthode qui affiche le relvé d'un mois pour une année (5/14)
     */

	public void afficheReleveCourant(String mois, String anne) {
		Float total = new Float(0);
		for (Map.Entry<String, Operation> entry : getListeOperations().entrySet()) {
			Operation p = entry.getValue();
			if ((p.getMois().equals(mois) && p.getAnnee().equals(anne)) && p.getType().getCode().equals(TypeOperation.Debit))
				total -= p.getMontant();
			if ((p.getMois().equals(mois) && p.getAnnee().equals(anne)) && p.getType().getCode().equals(TypeOperation.Credit))
				total += p.getMontant();
		}
		System.out.println(total);
	}

	/**
	 * Une méthode qui affiche la somme des opérations de Débit d'un mois
	 * pour une année (5/14)
	 */
	public void afficheDébitCourant(String mois, String année) {
		Float total = new Float(0);
		for (Map.Entry<String, Operation> entry : getListeOperations().entrySet()) {
			Operation p = entry.getValue();
			if ((p.getMois().equals(mois) && p.getAnnee().equals(année)) && p.getType().getCode().equals(TypeOperation.Debit))
				total += p.getMontant();
		}
		System.out.println(total);
	}

	/**
	 * Une méthode qui affiche la somme des opérations de Crédit d'un mois
	 * pour une année (5/14)
	 *
	 * @param mois
	 * @param année
	 */
	public void afficheCréditCourant(String mois, String année) {
		Float total = new Float(0);
		for (Map.Entry<String, Operation> entry : getListeOperations().entrySet()) {
			String key = entry.getKey();
			Operation p = entry.getValue();
			if ((p.getMois().equals(mois) && p.getAnnee().equals(année)) && p.getType().getCode().equals(TypeOperation.Credit))
				total += p.getMontant();
		}
		System.out.println(total);
	}


}

	

