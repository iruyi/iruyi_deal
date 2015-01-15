package com.faxintong.iruyi.base;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Created by hehj on 15-1-12.
 */
//@ActiveProfiles("TEST")
@ActiveProfiles("LOCAL")
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {

}
