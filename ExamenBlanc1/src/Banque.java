import java.util.HashMap;
import java.util.Map;


/**
 * Cette classe représente une banque 
 * @author   HAFIDI IMAD
 */
public class Banque {
	/**
	 * Liste des clients, la clé est le numéro du client
	 */
	private HashMap<Integer, Client> mesClients;
	/**
	 * Nom de la banque
	 */
	private String nom;

	/**
	 * La méthode respecte les régles suivantes :
	 * 1-Le client ne doit pas exister
	 * 2-Le numéro du client est généré automatiquement ( dernier numéro +1)
	 *
	 * @param nom
	 * @param age

	 * @return false : si le client n'est pas ajouté
	 */
	public boolean addClient(String nom, String prenom, Integer age) {
		mesClients.put(mesClients.size() + 1, new Client(nom, prenom, mesClients.size() + 1));
		return false;
	}

	/**
	 * La méthode ajoute un compte et l'attribue à un client
	 *
	 * @param client
	 * @param typeCompte
	 * @return false : si le compte n'est pas crée
	 */
	public boolean addCompte(Client client, String typeCompte) {
		//TODO
		if (typeCompte == "CompteCourant") {
			client.mesComptes.add(new CompteCourant(client.mesComptes.size() + 1, (float) 0, (float) 0));
			return true;
		}
		return false;
	}

	/**
	 * La méthode supprime un client si seulement si le solde de tous ses comptes
	 * est zéro
	 *
	 * @param client
	 * @return false si le client est supprimé
	 */
	public boolean removeClient(Client client) {
		//TODO
		mesClients.remove(client);
		return false;
	}

	/**
	 * Cette méthode affiche les relvés bancaires d'un client pour une date précise(05/14)
	 *
	 * @param id
	 */
	public void afficheTousComptesClient(Integer id, String mois, String année) {
		for (Map.Entry<Integer, Client> entry : mesClients.entrySet()) {
			Integer key = entry.getKey();
			Client client = entry.getValue();
			if (client.getId().equals(id)) {
				for (Compte compte : client.mesComptes) {

				}
			}

		}

	}
}
