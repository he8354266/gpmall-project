package com.gpmall.search.repository;

import com.gpmall.search.entity.ItemDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Description //TODO
 * @Date 2023/6/21 16:33
 * @Author hy
 **/
public interface ProductRepository extends ElasticsearchRepository<ItemDocument, Integer> {
}
