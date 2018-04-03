package com.yxyc.gate.ratelimit.config.repository.springdata;

import com.yxyc.gate.ratelimit.config.Rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRateLimiterRepository extends CrudRepository<Rate, String> {

}
