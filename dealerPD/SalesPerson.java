package dealerPD;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import dealerDAO.CarDAO;
@Entity(name = "salesperson")
public class SalesPerson implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id //signifies the primary key
  @Column(name = "salesPersonId", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long salesPersonID;
  
  @Column(name = "name", nullable = false,length = 50)
  private String name;
  
  @Column(name = "position", nullable = false,length = 50)
  private String position;
  
  @OneToMany(mappedBy="salesPerson",targetEntity=Car.class,fetch=FetchType.EAGER)
  private Collection<Car> cars;
  
  @ManyToOne(optional=false)
  @JoinColumn(name="dealerId",referencedColumnName="dealerId")
  private Dealer dealer;
  
  public SalesPerson(){
	  
  }
  
  public Dealer getDealer() {
	return dealer;
  }

  public void setDealer(Dealer dealer) {
	this.dealer = dealer;
  }
  
  public long getSalesPersonID() {
	return salesPersonID;
  }

  public void setSalesPersonID(long salesPersonID) {
	this.salesPersonID = salesPersonID;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public String getPosition() {
    return position;
  }
  
  public void setPosition(String position) {
    this.position = position;
  }
  
  public Collection<Car> getCars() {
    return cars;
  }
  
  public void addCar(Car car) {
	car.setSalesPerson(this);
    CarDAO.addCar(car);
  }
  
  public void removeCar(Car car)
  {
    CarDAO.removeCar(car);
  }
  
  public boolean isOkToRemove() {
    if (getCars().size() == 0) 
    	return true; 
    else 
    	return false;
  }
  
  public String toString() {
    return getName();
  }
}
