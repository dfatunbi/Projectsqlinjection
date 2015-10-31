package io.github.lucienh.common.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by h on 15-10-29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ioc-*.xml"})
public class ElasticSearchTemplateExtTest2 {

    private ElasticSearchTemplateExt elasticSearchTemplateExt;

    @Autowired
    public void setElasticSearchTemplateExt(ElasticSearchTemplateExt elasticSearchTemplateExt) {
        this.elasticSearchTemplateExt = elasticSearchTemplateExt;
    }

    @Test
    public void testAdd() {
        List<IndexQuery> indexQueries = new ArrayList<IndexQuery>();
        //first document
        String documentId = "12345";

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'S'Z'");
        SampleEntity sampleEntity1 = new SampleEntity();
        sampleEntity1.setId(documentId);
        sampleEntity1.setMessage("some message");
        sampleEntity1.setNum(1);
        sampleEntity1.setTime(new Date());
        sampleEntity1.setDate(dateFormat.format(new Date()));

        IndexQuery indexQuery1 = new IndexQueryBuilder().withId(sampleEntity1.getId()).withObject(sampleEntity1).build();
        indexQueries.add(indexQuery1);

        //second document
        for (int i = 0; i < 10000; i++) {
            String documentId2 = "723457" + i;
            SampleEntity sampleEntity2 = new SampleEntity();
            sampleEntity2.setId(documentId2);
            sampleEntity2.setMessage("some message");
            sampleEntity2.setNum(i);
            sampleEntity2.setTime(new Date());
            sampleEntity2.setDate(dateFormat.format(new Date()));

            IndexQuery indexQuery2 = new IndexQueryBuilder().withId(sampleEntity2.getId()).withObject(sampleEntity2).build();
            indexQueries.add(indexQuery2);
        }

        //bulk index
        elasticSearchTemplateExt.bulkIndex(indexQueries);
    }
}
