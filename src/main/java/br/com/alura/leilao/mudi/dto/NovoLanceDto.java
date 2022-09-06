package br.com.alura.leilao.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Usuario;
import lombok.Data;

@Data
public class NovoLanceDto {
	
	@NotNull
	@DecimalMin(value = "0.1")
	private BigDecimal valor;
	
	private Long leilaoId;

	public Lance toLance(Usuario usuario) {
		Lance lance = new Lance(usuario, valor);
		lance.setData(LocalDate.now());
		return lance;
	}

}
