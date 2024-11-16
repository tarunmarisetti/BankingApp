package springBoot.project.Banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springBoot.project.Banking_app.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
