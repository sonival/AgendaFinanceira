package finance.demo.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finance.demo.finance.model.AgendamentoTransferencia;

@Repository
public interface AgendamentoTransferenciaRepository extends JpaRepository<AgendamentoTransferencia, Integer> {
    
}
