package Solr;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.Field;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.coodex.util.Common;
import org.junit.Before;
import org.junit.Test;

public class SolrTest {

    private static final String URL = "http://127.0.0.1:8080/solr/collection1";
    private HttpSolrClient server = null;

    @Before
    public void init() {
        // 创建 server
        server = new HttpSolrClient(URL);
    }

    @Test
    public void addDoc() {
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", Common.getUUIDStr());
        doc.addField("name", "002的名称");
        doc.addField("qitade", false);
        try {
            UpdateResponse response = server.add(doc);
            // 提交
            server.commit();
            System.out.println("########## Query Time :" + response.getQTime());
            System.out.println("########## Elapsed Time :" + response.getElapsedTime());
            System.out.println("########## Status :" + response.getStatus());
        } catch (SolrServerException | IOException e) {
            System.err.print(e);
        }
    }

    /**
     * 查询
     */
    @Test
    public void testQuery() {
        String queryStr = "*:*";
        SolrQuery params = new SolrQuery(queryStr);
        params.set("rows", 10);
        try {
            QueryResponse response = null;
            response = server.query(params);
            SolrDocumentList list = response.getResults();
            System.out.println("########### 总共 ： " + list.getNumFound() + "条记录");
            for (SolrDocument doc : list) {
                System.out.println("######### id : " + doc.get("id") + "  name : " + doc.get("news_name")
                        + "  address : " + doc.get("news_address")
                        + "  updateTime : " + ctsToDate(doc.get("news_updateTime").toString()));
            }
        } catch (SolrServerException e) {
            System.err.print(e);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /*
    * 删除数据
    *
    */
    @Test
    public void testDelete() throws IOException, SolrServerException {
        //删除全部，第一个参数是设置需要删除的数据的域和值，第二个是执行后多久进行删除操作
        server.deleteByQuery("*:*",1000);
        //删除某个特定域的特定值的数据
        /*String key = "578c048af4c14fca873423dfd2bc7566";
        server.deleteByQuery("id:" + key, 1000);*/
    }

    // 时间格式转换  Thu Aug 27 18:05:49 CST 2015  --> 2015-08-27 18:05:49
    public String ctsToDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date d = sdf.parse(date);
        String formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
        System.out.println(formatDate);
        return formatDate;
    }
}
