package main.market.Controller;

import main.market.Entity.MarketBase;
import main.market.Service.MarketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MarketBaseController {

    private final MarketService service;

    public MarketBaseController(MarketService service) {
        this.service = service;
    }


    @PostMapping("/market-base")
    public ResponseEntity save(@RequestBody MarketBase marketBase){

        MarketBase data = service.save(marketBase);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/market-base/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        MarketBase data = service.findOne(id);
        if (data.getId() == null){
            return ResponseEntity.ok("Data not found");
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping("/market-base")
    public Page<MarketBase> getAll(Pageable pageable){
        Page<MarketBase> data = service.findAll(pageable);
        return data;

    }
    @DeleteMapping("/market-base/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("Data has been deleted");
    }
}
