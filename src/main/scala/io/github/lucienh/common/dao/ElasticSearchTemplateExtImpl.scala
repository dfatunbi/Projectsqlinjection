package io.github.lucienh.common.dao

import org.elasticsearch.client.Client
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate

/**
 * Created by h on 15-10-29.
 */
class ElasticSearchTemplateExtImpl(client: Client) extends ElasticsearchTemplate(client: Client) with ElasticSearchTemplateExt {

}
