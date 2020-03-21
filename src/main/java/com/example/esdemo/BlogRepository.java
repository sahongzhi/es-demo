package com.example.esdemo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: SaHongzhi
 * @Date: 2020-03-21 9:49
 */
public interface BlogRepository extends ElasticsearchRepository<BlogModel, String> {
}
