package dealerDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import dealerPD.Dealer;

public class DealerDAO {

	public static void addDealer(Dealer dealer)
	{
		emDAO.getEM().persist(dealer);
	}
		
	public static void saveDealer(Dealer dealer) {
		emDAO.getEM().persist(dealer);
	}

	public static List<Dealer> listDealer()
	{
		TypedQuery<Dealer> query = emDAO.getEM().createQuery(
				"SELECT dealer FROM dealer dealer", Dealer.class);
		return query.getResultList();
	}

	public static Dealer findDealerById(int id)
	{
		Dealer dealer = emDAO.getEM().find(Dealer.class, new Integer(id));
		return dealer;
	}
	
	public static void removeDealer(Dealer dealer)
	{
		emDAO.getEM().remove(dealer);
	}
}
