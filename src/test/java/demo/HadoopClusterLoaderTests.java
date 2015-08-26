package demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.hadoop.conf.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.hadoop.test.context.MiniHadoopCluster;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/app-test-ctx.xml")
@MiniHadoopCluster(configName = "hadoopConfiguration", clusterName = "hadoopCluster", nodes = 1, id = "default")
public class HadoopClusterLoaderTests {

	@Autowired
	private ApplicationContext ctx;

	@Test
	public void configContainsAllRequiredBeans() {
		assertNotNull(ctx);
		assertTrue(ctx.containsBean("hadoopCluster"));
		assertTrue(ctx.containsBean("hadoopConfiguration"));
		assertNotNull(ctx.getBean("hadoopConfiguration", Configuration.class));
	}
}
