package io.github.lucienh.common.dao


import java.util.Date

import org.springframework.data.elasticsearch.annotations.Document

import scala.beans.BeanProperty

/**
 * Created by h on 15-10-29.
 */
@Document(indexName = "foo")
class SampleEntity {

  @BeanProperty
  var id: String = null

  @BeanProperty
  var message: String = null

  @BeanProperty
  var time: Date = null

  @BeanProperty
  var num: Integer = null

  @BeanProperty
  var date: String = null
}
