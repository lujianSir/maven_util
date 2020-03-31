package com.lj.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * 模糊查询
 * 
 * @author Administrator
 *
 */
public class luceneQuery {

	public List<String> searchIndex(String name) throws IOException {

		List<String> list = new ArrayList<String>();
		// 指定索引库存放路径
		// E:\Lucene_index
		Directory directory = FSDirectory.open(Paths.get(new File("E:\\Lucene_index").getPath()));
		// 创建indexReader对象
		IndexReader indexReader = DirectoryReader.open(directory);
		// 创建indexSearcher对象
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		// 创建查询
		Query query = new TermQuery(new Term("fileContent", name));
		// 执行查询
		// 参数一 查询对象 参数二 查询结果返回的最大值
		TopDocs topDocs = indexSearcher.search(query, 10);
		System.out.println("查询结果的总数" + topDocs.totalHits);
		// 遍历查询结果
		for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
			// scoreDoc.doc 属性就是doucumnet对象的id
			Document doc = indexSearcher.doc(scoreDoc.doc);
			System.out.println(doc.getField("fileName"));
			System.out.println(doc.getField("fileContent"));
			System.out.println(doc.get("fileName"));
			System.out.println(doc.get("fileContent"));
			// System.out.println(doc.getField("filePath"));
			// System.out.println(doc.getField("fileSize"));
			list.add(doc.get("fileName").substring(0, doc.get("fileName").indexOf(".txt")));
		}
		indexReader.close();
		return list;
	}

	public static void main(String[] args) {
		luceneQuery a = new luceneQuery();
		try {
			List<String> list = a.searchIndex("功夫");
			System.err.println(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
