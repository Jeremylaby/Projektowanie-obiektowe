package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.util.*;


public class Order {
    private static final BigDecimal TAX_VALUE = BigDecimal.valueOf(1.23);
	private final UUID id;
    private final ArrayList<Product> products=new ArrayList<>();
    private boolean paid;
    private Shipment shipment;
    private ShipmentMethod shipmentMethod;
    private PaymentMethod paymentMethod;

    public Order(Collection<Product> productsList) {
        products.addAll(productsList);
        id = UUID.randomUUID();
        paid = false;
    }

//    private void generateProducts(Collection<Product> productsList){
//        for(Product product:productsList){
//            if(productsList.contains(product)){
//                products.put(product, products.get(product) + 1);
//            }else{
//                products.put(product,1);
//            }
//        }
//    }
    public UUID getId() {
        return id;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isSent() {
        return shipment != null && shipment.isShipped();
    }

    public boolean isPaid() { return paid; }

    public Shipment getShipment() {
        return shipment;
    }

    public BigDecimal getPrice() {
        BigDecimal totalPrice= BigDecimal.valueOf(0);
        for(Product product : products){
            totalPrice = totalPrice.add(product.getPrice());
        }
        return totalPrice;
    }

    public BigDecimal getPriceWithTaxes() {
        return getPrice().multiply(TAX_VALUE).setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY);
    }

    public ArrayList<Product> getProducts() {
        return (ArrayList<Product>) Collections.unmodifiableList(products);
    }

    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public void send() {
        boolean sentSuccesful = getShipmentMethod().send(shipment, shipment.getSenderAddress(), shipment.getRecipientAddress());
        shipment.setShipped(sentSuccesful);
    }

    public void pay(MoneyTransfer moneyTransfer) {
        moneyTransfer.setCommitted(getPaymentMethod().commit(moneyTransfer));
        paid = moneyTransfer.isCommitted();
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
