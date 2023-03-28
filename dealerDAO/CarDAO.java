package dealerDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import dealerPD.Car;

public class CarDAO {

	public static void addCar(Car car)
	{
		emDAO.getEM().persist(car);
	}
		
	public static void saveCar(Car car) {
		emDAO.getEM().persist(car);
	}

	public static List<Car> listCar()
	{
		TypedQuery<Car> query = emDAO.getEM().createQuery(
				"SELECT car FROM car car", Car.class);
		return query.getResultList();
	}

	public static Car findCarById(int id)
	{
		Car car = emDAO.getEM().find(Car.class, new Integer(id));
		return car;
	}
	
	public static void removeCar(Car car)
	{
		emDAO.getEM().remove(car);
	}
}
