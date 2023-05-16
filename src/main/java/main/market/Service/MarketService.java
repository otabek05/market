package main.market.Service;

import main.market.Entity.MarketBase;
import main.market.Repository.MarketRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class MarketService {

    private final MarketRepo repo;

    public MarketService(MarketRepo repo) {
        this.repo = repo;
    }

    public MarketBase save(MarketBase data){
        if (data.getId() == null){
            data.setCreatedDate(ZonedDateTime.now());
        }
        return repo.save(data);
    }

    public MarketBase findOne(Long id){
        Optional<MarketBase> data = repo.findById(id);
        if (data.isPresent()){
            MarketBase base = data.get();
            return  base;
        }
         return null;
    }

    public Page<MarketBase> findAll(Pageable pageable){
        Page<MarketBase> data = repo.findAll(pageable);
        return data;
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
