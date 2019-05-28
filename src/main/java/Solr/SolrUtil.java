/*
package Solr;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import com.zhongan.util.StringUtil;
import com.zhongan.util.config.ModelConfig;

*/
/**
 * 转换SolrDocument 到实体对象 
 * @author wesson
 *
 *//*

public class SolrUtil {
	
	*/
/**
	 * 将SolrDocument转换成实体对象
	 * @param record solr记录对象
	 * @param obj 实体类对象
	 * @return 
 	 *//*

	 public static <T> T toBean(SolrDocument record , T obj){
        T o = null;
        Class clazz = obj.getClass();
        try {
            o = (T)clazz.newInstance();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
        Method m = null;
        int columns = 0;
		try {
			m = (Method) clazz.getMethod(ModelConfig.SOLR_FIELDS_COUNT);
			columns = (Integer) m.invoke(obj);
			Field[] fields =  clazz.getDeclaredFields();
			for (int i = 0; i < columns; i++) {
				Field field = fields[i];
				Object value = record.get(field.getName());
//				//solr时间比当前时间多8小时
//				Date tmpDate = (Date)value;
//				if(tmpDate != null) {
//					Long jsgjMilliseconds= tmpDate.getTime() - 8*60*60*1000;
//					BeanUtils.setProperty(o, field.getName(), new Date(jsgjMilliseconds));
//				}
//			} else {
//				BeanUtils.setProperty(o, field.getName(), value);
//			}	
				if(field.getGenericType().toString().equals("class java.util.Date")) {
					if(value != null) {
						BeanUtils.setProperty(o, field.getName(), value);
					}
				} else {
					BeanUtils.setProperty(o, field.getName(), value);
				}
	
			}
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
        return o;
    }
	
	*/
/**
	 * 实体对象转换成SolrDocument对象
	 * @param obj
	 * @return
	 *//*

	public static SolrInputDocument toSolrInputDocument(Object t) {
		Class clazz = null;
		Method m = null;
		int columns = 0;
		clazz = t.getClass();
        SolrInputDocument record = new SolrInputDocument();
        try{
        	m = (Method) clazz.getMethod(ModelConfig.SOLR_FIELDS_COUNT);
			columns = (Integer) m.invoke(t);
			Field[] fields =  clazz.getDeclaredFields();
			for (int i = 0; i < columns; i++) {
				Field field = fields[i];
				Method tm = (Method) clazz.getMethod("get" + getMethodName(field.getName()));
				Object val = tm.invoke(t);
				if(val != null) {
					if(field.getGenericType().toString().equals("class java.util.Date")) {
						record.addField(field.getName(),toSolrDate((Date)val));
					} else {
						record.addField(field.getName(),val);
					}
				}
			}
        } catch(Exception e) {
        	e.printStackTrace();
        }
        return record;
	}
	 
    
	 */
/**
	  * SolrDocumentList 转换成List<实体类>集合
	 * @param <T>
	  * @param records solr数据列表
	  * @param obj 实体对象
	  * @return
	  *//*

    public static <T> List<T> toBeanList(SolrDocumentList records, T obj){
        List list = new ArrayList();
        for(SolrDocument record : records){
            list.add(toBean(record, obj));
        }
        return list;
    }
    
    */
/**
     * 取得方法名
     * @param fildename
     * @return
     * @throws Exception
     *//*

	public static String getMethodName(String fildename) {
		byte[] items = fildename.getBytes();

		if (items[0] < 'a') {
			return fildename;
		}
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}

	*/
/**
	 * 转换为solr格式日期
	 * @param date yyyy-MM-dd HH:mm:ss
	 * @return yyyy-MM-ddTHH:mm:ssZ
	 *//*

	public static String toSolrDate(String date) {
		if(StringUtil.isNull(date)) {
			return null;
		}
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		String solrDate = "";
		try {
			Date dateObj = sdf1.parse(date);
			Long jsgjMilliseconds= dateObj.getTime() - 8*60*60*1000;
			dateObj = new Date(jsgjMilliseconds);
			solrDate = sdf2.format(dateObj);
		} catch (ParseException e) {
			solrDate = date;
			e.printStackTrace();
		}
		return solrDate;
	}
	
	*/
/**
	 * 转换为solr格式日期
	 * @param date yyyy-MM-dd HH:mm:ss
	 * @return yyyy-MM-ddTHH:mm:ssZ
	 *//*

	public static String toSolrDate(Date date) {
		if(date == null) {
			return null;
		}
		Long jsgjMilliseconds= date.getTime() - 8*60*60*1000;
		Date dateObj = new Date(jsgjMilliseconds);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		String solrDate = sdf.format(dateObj);
		return solrDate;
	}
}
*/
