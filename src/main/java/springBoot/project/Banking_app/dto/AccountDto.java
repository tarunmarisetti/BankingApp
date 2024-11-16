package springBoot.project.Banking_app.dto;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Data
//@AllArgsConstructor
//public class AccountDto {
//    private Long id;
//    private String accountHolderName;
//    private double balance;
//}

//using record class for the DTO
public record AccountDto(Long id,String accountHolderName, double balance ) {
}