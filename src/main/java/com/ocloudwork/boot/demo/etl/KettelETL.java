package com.ocloudwork.boot.demo.etl;

import java.io.IOException;
import java.io.InputStream;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KettelETL {
	@Value("${com.ocloudwork.boot.enableETL}")
	private boolean enableETL;

	@Scheduled(cron = "0 53 13 ? * *")
	public void execute() throws KettleException, IOException {
		if (!enableETL)
			return;
		PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
		Resource resource = patternResolver.getResource("/kettle/user.ktr");
		InputStream inputStream = resource.getInputStream();
		KettleEnvironment.init();
		TransMeta transMeta = new TransMeta(inputStream, null, true, null, null);
		Trans trans = new Trans(transMeta);
		trans.execute(null);
		trans.waitUntilFinished();
	}
}
