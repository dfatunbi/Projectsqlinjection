package io.github.lucienh.sqlinjection.dao

/**
 * Created by h on 15-10-31.
 */
trait InjectionParamDao {

  def addInjectionLog(params: String): Unit

}
