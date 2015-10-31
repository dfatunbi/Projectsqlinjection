package io.github.lucienh.sqlinjection.dao

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by h on 15-10-29.
 */
@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("classpath*:ioc-*.xml"))
class InjectionParamDaoTest {

  var injectionParamDao: InjectionParamDao = null

  @Autowired
  def setInjectionParamDao(dao: InjectionParamDao): Unit = {
    injectionParamDao = dao
  }

  @Test
  def testAddInjectionLog(): Unit = {
    injectionParamDao.addInjectionLog("test")
  }

}
