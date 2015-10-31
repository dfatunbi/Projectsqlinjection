package io.github.lucienh.common.dao


import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by h on 15-10-29.
 */
@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("classpath*:ioc-*.xml"))
class ElasticSearchTemplateExtTest {

  var elasticSearchTemplateExt: ElasticSearchTemplateExt = null

  @Autowired
  def setElasticSearchTemplateExt(es: ElasticSearchTemplateExt): Unit = {
    elasticSearchTemplateExt = es
  }

  @Test
  def testAdd(): Unit = {
    println(elasticSearchTemplateExt)


  }

}
