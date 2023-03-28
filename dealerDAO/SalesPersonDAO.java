package dealerDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import dealerPD.SalesPerson;

public class SalesPersonDAO {

	public static void addSalesPerson(SalesPerson salesPerson)
	{
		emDAO.getEM().persist(salesPerson);
	}
		
	public static void saveSalesPerson(SalesPerson salesPerson) {
		emDAO.getEM().persist(salesPerson);
	}

	public static List<SalesPerson> listSalesPerson()
	{
		TypedQuery<SalesPerson> query = emDAO.getEM().createQuery(
				"SELECT salesPerson FROM salesPerson salesPerson", SalesPerson.class);
		return query.getResultList();
	}

	public static SalesPerson findSalesPersonById(int id)
	{
		SalesPerson salesPerson = emDAO.getEM().find(SalesPerson.class, new Integer(id));
		return salesPerson;
	}
	
	public static void removeSalesPerson(SalesPerson salesPerson)
	{
		emDAO.getEM().remove(salesPerson);
	}
}
