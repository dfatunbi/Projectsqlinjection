package io.github.lucienh.sqlinjection.dao

import java.text.SimpleDateFormat
import java.util
import java.util.{UUID, Date}
import javax.annotation.Resource

import io.github.lucienh.common.dao.ElasticSearchTemplateExt
import io.github.lucienh.sqlinjection.entity.InjectionParam
import org.springframework.data.elasticsearch.core.query.{IndexQuery, IndexQueryBuilder}
import org.springframework.stereotype.Repository

import scala.beans.BeanProperty

/**
 * Created by h on 15-10-29.
 */
@Repository
class InjectionParamDaoImpl extends Object with InjectionParamDao {

  var elasticSearchTemplateExt: ElasticSearchTemplateExt = null

  @Resource
  def setElasticSearchTemplateExt(esTemplate: ElasticSearchTemplateExt): Unit = {
    elasticSearchTemplateExt = esTemplate
  }

  def addInjectionLog(param: String): Unit = {

    val dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'S'Z'")
    val injectparam = new InjectionParam()
    injectparam.setTime(dateFormat.format(new Date()))
    injectparam.setParam(param)

    val indexQuery = new IndexQueryBuilder().withId(UUID.randomUUID().toString).withObject(injectparam).build()
    val indexQueries: util.List[IndexQuery] = new java.util.ArrayList[IndexQuery]()
    indexQueries.add(indexQuery)

    elasticSearchTemplateExt.bulkIndex(indexQueries)
    println("add param to es")
  }

}
