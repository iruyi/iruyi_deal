package com.faxintong.iruyi.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hehj on 15-1-12.
 */
@ActiveProfiles("TEST")
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class BaseTest extends AbstractJUnit4SpringContextTests {


}
