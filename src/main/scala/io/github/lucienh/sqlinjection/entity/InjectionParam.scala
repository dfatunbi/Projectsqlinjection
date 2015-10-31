package io.github.lucienh.sqlinjection.entity

import org.springframework.data.elasticsearch.annotations.Document

import scala.beans.BeanProperty

/**
 * Created by h on 15-10-30.
 */
@Document(indexName = "sqlinjection")
class InjectionParam {

  @BeanProperty
  var param: String = null

  @BeanProperty
  var time: String = null

}
