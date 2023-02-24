package br.com.DrinksAndClubs.Order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Table(name = "tb_credit-card")
@Data
@Entity
@Getter
@Setter
public class creditcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(length = 7, nullable = false)
    @NotBlank(message = "este campo não pode ser nulo!")
    private String Type; //Tipo do cartão: Debito ou Credito

    @Column(name = "v_cardnumber", length = 16, nullable = false, unique = true)
    @NotBlank(message = "este campo não pode ser nulo!")
    @Size(min = 16, max = 16, message = "numero inválido!")
    private String Number; //Numero do cartão

    @Column(name = "v_titular", length = 100, nullable = false)
    @NotBlank(message = "este campo não pode ser nulo!")
    private String Name; //Nome do titular do cartão

    @Column(length = 3, nullable = false)
    @NotBlank(message = "este campo não pode ser nulo!")
    @Size(min = 3, max = 3, message = "código invalido!")
    private int SecretCode; //Código de segurança do cartão

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yyyy", locale = "pt-BR")
    @NotBlank(message = "este campo não pode ser nulo!")
    private Date Validate; //Validade do cartão no formato MM/YYYY

    @Column(nullable = false)
    @NotBlank(message = "este campo não pode ser nulo!")
    private String Installment; //Parcelado ou a vista;
//1
}
