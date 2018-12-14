package com.ocloudwork.boot.demo.utils;

import java.io.File;
/**
 * 文件工具
 * @author minghui
 *
 */
public class FileUtils {
	/**
	 * 刪除目录及目录下的所有文件
	 * @param path
	 */
	public static void deleteDir(String path) {
		File file = new File(path);
		if (file.exists()) {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File subFile : files) {
					if (subFile.isDirectory())
						deleteDir(subFile.getPath());
					else
						subFile.delete();
				}
			}
			file.delete();
		}
	}
}