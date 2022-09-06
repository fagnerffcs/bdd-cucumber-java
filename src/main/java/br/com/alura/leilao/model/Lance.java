package br.com.alura.leilao.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Lance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private BigDecimal valor;

	@NotNull
	private LocalDate data;

	@OneToOne(fetch = FetchType.EAGER)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Leilao leilao;

	@Deprecated
	public Lance() {}
	
	public Lance(Usuario usuario, BigDecimal valor) {
		if (valor.doubleValue() <= 0) {
			throw new IllegalArgumentException();
		}
		this.usuario = usuario;
		this.valor = valor;
		this.data = LocalDate.now();
	}

	public Lance(@NotNull @DecimalMin("0.1") BigDecimal valor) {
		this.valor = valor;
	}

}
