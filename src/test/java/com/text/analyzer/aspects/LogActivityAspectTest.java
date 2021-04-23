package com.text.analyzer.aspects;

import static org.junit.Assert.assertEquals;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LogActivityAspectTest {
	
	@Mock
	private ProceedingJoinPoint proceedingJoinPoint;
	
	@Mock
	private LogActivity logActivity;
	
	@InjectMocks
	LogActivityAspect logActivityAspect;
	
	@Test
	public void testPositiveScenario() throws Throwable {
		
		Mockito.when(logActivity.value()).thenReturn("TEST");
		Mockito.when(proceedingJoinPoint.proceed()).thenReturn("OUTPUT");
		Object resultObj= logActivityAspect.around(proceedingJoinPoint, logActivity);
		assertEquals("OUTPUT",resultObj.toString());
	}
	
	@Test(expected = Exception.class)
	public void testNegativeScenario() throws Throwable {
		
		Mockito.when(logActivity.value()).thenReturn("TEST");
		Mockito.when(proceedingJoinPoint.proceed()).thenThrow(new Exception("TEST"));
		logActivityAspect.around(proceedingJoinPoint, logActivity);
	}
	
	
	
	

}
