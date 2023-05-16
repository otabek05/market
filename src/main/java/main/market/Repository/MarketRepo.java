package main.market.Repository;

import main.market.Entity.MarketBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepo extends JpaRepository<MarketBase, Long> {
}
