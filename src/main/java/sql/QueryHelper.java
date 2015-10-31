/*******************************************************************************
 * Copyright (c) 1996, 2013 Venustech Corporation and others.
 * All rights reserved.
 * <p/>
 * Contributors:
 * Venustech Corporation - POC Team
 *******************************************************************************/
package sql;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.Type;

import java.util.Map;

/**
 * @author huacheng
 *
 */
public class QueryHelper {
    /**
     * 向Query对象中设置参数
     *
     * @param paramValues
     *            参数值
     * @param queryObject
     */
    public static void setQueryParams(final Object[] paramValues,
                                      final Query queryObject) {
        if (paramValues != null) {
            for (int i = 0; i < paramValues.length; i++) {
                queryObject.setParameter(i, paramValues[i]);
            }
        }
    }

    /**
     * 向Query对象中设置参数
     *
     * @param paramNames
     *            参数名
     * @param paramValues
     *            参数值
     * @param queryObject
     */
    public static void setQueryParams(final String[] paramNames,
                                      final Object[] paramValues, final Query queryObject) {
        if (paramValues != null && paramValues.length > 0) {
            final int nlen = paramNames == null ? 0 : paramNames.length;
            if (nlen != paramValues.length) {
                throw new RuntimeException("为HQL语句指定的参数名称个数" + nlen + "与参数值个数"
                        + paramValues.length + "不匹配！");
            }
            for (int i = 0; i < paramValues.length; i++) {
                queryObject.setParameter(paramNames[i], paramValues[i]);
            }
        }
    }

    /**
     * 向Query对象中设置参数
     *
     * @param paramValues
     *            参数值
     * @param paramTypes
     * @param qry
     */
    public static void setQueryParams(final Object[] paramValues,
                                      final Type[] paramTypes, final Query qry) {
        if (paramValues.length != paramTypes.length) {
            throw new RuntimeException("为查询指定的参数个数与参数类型的个数不匹配！");
        }
        for (int i = 0; i < paramValues.length; i++) {
            qry.setParameter(i, paramValues[i], paramTypes[i]);
        }
    }

    /**
     * 向Query对象中设置参数
     *
     * @param paramNames
     *            参数名
     * @param paramValues
     *            参数值
     * @param types
     *            参数类型
     * @param queryObject
     */
    public static void setQueryParams(final String[] paramNames,
                                      final Object[] paramValues, final Type[] types,
                                      final Query queryObject) {
        if (paramValues != null && paramValues.length > 0) {
            if (paramNames != null && paramNames.length > 0) {
                if (types != null && types.length > 0) {
                    for (int i = 0; i < paramValues.length; i++) {
                        queryObject.setParameter(paramNames[i], paramValues[i],
                                types[i]);
                    }
                } else {
                    setQueryParams(paramNames, paramValues, queryObject);
                }
            } else {
                if (types != null && types.length > 0) {
                    setQueryParams(paramValues, types, queryObject);
                } else {
                    setQueryParams(paramValues, queryObject);
                }
            }
        }
    }

    /**
     * 向Query对象中设置取出的结果范围
     *
     * @param firstResult
     *            开始位置
     * @param maxResults
     *            取出多少条记录
     * @param query
     */
    public static void setResultBounds(final int firstResult,
                                       final int maxResults, final Query query) {
        if (firstResult >= 0) {
            query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query.setMaxResults(maxResults);
        }
    }

    public static <T> void setResultTransformer(final Class<T> entityClass,
                                                final Query query) {
        if (entityClass != null) {
            if (entityClass.equals(Map.class)) {
                query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            } else {
                query.setResultTransformer(Transformers
                        .aliasToBean(entityClass));
            }
        }
    }
}
