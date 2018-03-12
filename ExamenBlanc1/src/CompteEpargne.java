
public class CompteEpargne extends Compte{
	private Double interet ;

	
	public CompteEpargne(Integer numero, Float solde) {
		super(numero, solde);
	}
	@Override
	/**
	 * Cette méthode doit respecter les régles métier suivantes :
	 * O- Verifier que le client n'est pas déja signataire
	 * 1-Les signataires doivent avoir le même nom de famille
	 * 2-Le nombre de signataire ne doit pas dépasser 3
	 * 3-L'interet est calculé par la moyenne d'interer offert de chaque tranche 
	 * d'age des signataires ( 5% pour les mineurs, 4% de 18 à 25, 3.5 de 25 à 40 , 
	 * 3% de 40 à 60 et 2.5 pour le reste)
	 */
	public boolean addSignataires(Client client) {
		//TODO
		if(this.getSignataires().size()<3 && client.getNom()==this.getSignataires().get(0).getNom())
		{ this.getSignataires().add(client); }
		return false;
	}
	/**
	 * Cette méthode suuprime un signataire  et recalcule l'interet du compte
	 */
	@Override
	public boolean removeSignataires(Integer id) {
		for (Client signataires : this.getSignataires()) {
			this.getSignataires().remove(signataires.getId().equals(id));
		}
		return false;
	}
	/**
	 * Cette méthode ajoute une opération en respectant les régles suivantes :
	 * 1- Pour un débit :  la somme ne doit jamais dépasser le solde
	 * 2- Pour un crédit : l'opération est permise seulement en anniversaire du compte
	 * 3- La méthode doit recalculer le solde
	 */
	@Override
	public boolean addOperation(Operation operation) {
		// TODO Auto-generated method stub
		this.getListeOperations().put(operation.getDate(),operation);
		return false;
	}
	/**
	 * Calcul l'interet et ajoute la somme au solde
	 */
	public void addIntert(){
		for (Client signataires : this.getSignataires()) {
			if(signataires.getAge()<18){super.setSolde(super.getSolde()*105/100);}
			else if(signataires.getAge()>18 && signataires.getAge()<25){super.setSolde(super.getSolde()*104/100);}
			else if(signataires.getAge()>25 && signataires.getAge()<40){super.setSolde(super.getSolde()*1035/1000);}
			else if(signataires.getAge()>40&& signataires.getAge()<60){super.setSolde(super.getSolde()*103/100);}
			else {super.setSolde(super.getSolde()*1025/1000);}
		}
		//TODO
	}
}
