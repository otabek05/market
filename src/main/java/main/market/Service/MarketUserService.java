package main.market.Service;

import main.market.Entity.MarketUser;
import main.market.Repository.repoMarketUser;
import org.springframework.stereotype.Service;

@Service
public class MarketUserService {

   private final repoMarketUser repo;

    public MarketUserService(repoMarketUser repo) {
        this.repo = repo;
    }

    public MarketUser save( MarketUser user){
        MarketUser data = repo.save(user);
        return data;
    }
    public Boolean existsByLogin(String login){
        return repo.existsByLogin(login);
    }
}
