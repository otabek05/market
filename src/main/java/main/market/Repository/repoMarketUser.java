package main.market.Repository;

import main.market.Entity.MarketUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repoMarketUser extends JpaRepository<MarketUser, Long > {
    boolean existsByLogin(String login);

    MarketUser findByLogin(String login);
}
