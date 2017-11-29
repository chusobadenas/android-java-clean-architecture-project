package com.chusobadenas.boilerplatecleanarchitecture.common.di.modules;

import android.content.Context;

import com.chusobadenas.boilerplatecleanarchitecture.AndroidApplication;
import com.chusobadenas.boilerplatecleanarchitecture.common.executor.JobExecutor;
import com.chusobadenas.boilerplatecleanarchitecture.common.executor.UIThread;
import com.chusobadenas.boilerplatecleanarchitecture.data.repository.UserDataRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApplicationModuleTest {

  private ApplicationModule applicationModule;

  @Mock
  private AndroidApplication application;
  @Mock
  private UIThread uiThread;
  @Mock
  private JobExecutor jobExecutor;
  @Mock
  private UserDataRepository userDataRepository;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    applicationModule = new ApplicationModule(application);
  }

  @Test
  public void testProvideApplicationContextSuccess() {
    Context context = applicationModule.provideApplicationContext();
    assertNotNull(context);
    assertEquals(context, application);
  }

  @Test
  public void testProvidePostExecutionThreadSuccess() {
    assertEquals(applicationModule.providePostExecutionThread(uiThread), uiThread);
  }

  @Test
  public void testProvideThreadExecutorSuccess() {
    assertEquals(applicationModule.provideThreadExecutor(jobExecutor), jobExecutor);
  }

  @Test
  public void testProvideUserRepositorySuccess() {
    assertEquals(applicationModule.provideUserRepository(userDataRepository), userDataRepository);
  }
}
