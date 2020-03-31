package com.lj.test;

import java.io.File;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

/**
 * 创建
 * 
 * @author Administrator
 *
 */
public class luceneCreateIndex {

	// 创建索引
	@Test
	public void luceneCreateIndex() throws Exception {

		// 指定索引存放的位置
		// E:\Lucene_index
		Directory directory = FSDirectory.open(Paths.get(new File("E:\\Lucene_index").getPath()));
		System.out.println("pathname" + Paths.get(new File("E:\\Lucene_index").getPath()));
		// 创建一个分词器
		// StandardAnalyzer analyzer = new StandardAnalyzer();
		// CJKAnalyzer cjkAnalyzer = new CJKAnalyzer();
		SmartChineseAnalyzer smartChineseAnalyzer = new SmartChineseAnalyzer();
		// 创建indexwriterConfig(参数分词器)
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(smartChineseAnalyzer);
		// 创建indexwrite 对象(文件对象，索引配置对象)
		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
		// 原始文件
		File file = new File("E:/upload/HDWX/book/txt");

		for (File f : file.listFiles()) {
			// 文件名
			String fileName = f.getName();
			// 文件内容
			String fileContent = FileUtils.readFileToString(f, "UTF-8");
			System.out.println(fileContent);
			// 文件路径
			String path = f.getPath();
			// 文件大小
			// long fileSize = FileUtils.sizeOf(f);

			// 创建文件域名
			// 域的名称 域的内容 是否存储
			Field fileNameField = new TextField("fileName", fileName, Field.Store.YES);
			Field fileContentField = new TextField("fileContent", fileContent, Field.Store.YES);
			// Field filePathField = new TextField("filePath", path,
			// Field.Store.YES);
			// Field fileSizeField = new TextField("fileSize", fileSize + "",
			// Field.Store.YES);

			// 创建Document 对象
			Document indexableFields = new Document();
			indexableFields.add(fileNameField);
			indexableFields.add(fileContentField);
			// indexableFields.add(filePathField);
			// indexableFields.add(fileSizeField);
			// 创建索引，并写入索引库
			indexWriter.addDocument(indexableFields);

		}

		// 关闭indexWriter
		indexWriter.close();
	}

}
