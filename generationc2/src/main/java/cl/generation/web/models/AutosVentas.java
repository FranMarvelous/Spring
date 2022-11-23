package cl.generation.web.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="autos_ventas")
public class AutosVentas {
	//tabla relacional para agregar columnas adicionales (atributos)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer cantidad;
	private Float valorUnitario;
	private Float total;//cantidad*valorUnitario
	
	//Relacion ManyToMany = 2 ManyToOne
	//1 ManyToOne Auto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="auto_id")
	private Auto auto;
	
	//1 ManyToOne Auto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="venta_id")
	private Venta venta;

	public AutosVentas() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	

}
