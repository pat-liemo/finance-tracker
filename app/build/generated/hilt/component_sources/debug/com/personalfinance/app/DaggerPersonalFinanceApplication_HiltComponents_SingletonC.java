package com.personalfinance.app;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.auth.FirebaseAuth;
import com.personalfinance.app.data.local.dao.BudgetDao;
import com.personalfinance.app.data.local.dao.CategoryDao;
import com.personalfinance.app.data.local.dao.TransactionDao;
import com.personalfinance.app.data.local.dao.UserDao;
import com.personalfinance.app.data.local.database.PersonalFinanceDatabase;
import com.personalfinance.app.data.preferences.OnboardingPreferences;
import com.personalfinance.app.data.preferences.ThemePreferences;
import com.personalfinance.app.data.remote.notifications.PersonalFinanceMessagingService;
import com.personalfinance.app.data.repository.AnalyticsRepositoryImpl;
import com.personalfinance.app.data.repository.AuthRepositoryImpl;
import com.personalfinance.app.data.repository.BudgetRepositoryImpl;
import com.personalfinance.app.data.repository.CategoryRepositoryImpl;
import com.personalfinance.app.data.repository.RecurringTransactionRepositoryImpl;
import com.personalfinance.app.data.repository.TransactionRepositoryImpl;
import com.personalfinance.app.di.AppModule;
import com.personalfinance.app.di.AppModule_ProvideContextFactory;
import com.personalfinance.app.di.DatabaseModule;
import com.personalfinance.app.di.DatabaseModule_ProvideBudgetDaoFactory;
import com.personalfinance.app.di.DatabaseModule_ProvideCategoryDaoFactory;
import com.personalfinance.app.di.DatabaseModule_ProvidePersonalFinanceDatabaseFactory;
import com.personalfinance.app.di.DatabaseModule_ProvideTransactionDaoFactory;
import com.personalfinance.app.di.DatabaseModule_ProvideUserDaoFactory;
import com.personalfinance.app.di.NetworkModule;
import com.personalfinance.app.di.NetworkModule_ProvideFirebaseAuthFactory;
import com.personalfinance.app.di.PreferencesModule;
import com.personalfinance.app.di.PreferencesModule_ProvideThemeManagerFactory;
import com.personalfinance.app.di.PreferencesModule_ProvideThemePreferencesFactory;
import com.personalfinance.app.domain.repository.AnalyticsRepository;
import com.personalfinance.app.domain.repository.AuthRepository;
import com.personalfinance.app.domain.repository.BudgetRepository;
import com.personalfinance.app.domain.repository.CategoryRepository;
import com.personalfinance.app.domain.repository.RecurringTransactionRepository;
import com.personalfinance.app.domain.repository.TransactionRepository;
import com.personalfinance.app.presentation.MainActivity;
import com.personalfinance.app.presentation.MainActivity_MembersInjector;
import com.personalfinance.app.presentation.analytics.AnalyticsViewModel;
import com.personalfinance.app.presentation.analytics.AnalyticsViewModel_HiltModules_KeyModule_ProvideFactory;
import com.personalfinance.app.presentation.auth.AuthViewModel;
import com.personalfinance.app.presentation.auth.AuthViewModel_HiltModules_KeyModule_ProvideFactory;
import com.personalfinance.app.presentation.budget.BudgetViewModel;
import com.personalfinance.app.presentation.budget.BudgetViewModel_HiltModules_KeyModule_ProvideFactory;
import com.personalfinance.app.presentation.categories.CategoriesViewModel;
import com.personalfinance.app.presentation.categories.CategoriesViewModel_HiltModules_KeyModule_ProvideFactory;
import com.personalfinance.app.presentation.home.HomeViewModel;
import com.personalfinance.app.presentation.home.HomeViewModel_HiltModules_KeyModule_ProvideFactory;
import com.personalfinance.app.presentation.onboarding.OnboardingViewModel;
import com.personalfinance.app.presentation.onboarding.OnboardingViewModel_HiltModules_KeyModule_ProvideFactory;
import com.personalfinance.app.presentation.recurring.RecurringTransactionsViewModel;
import com.personalfinance.app.presentation.recurring.RecurringTransactionsViewModel_HiltModules_KeyModule_ProvideFactory;
import com.personalfinance.app.presentation.settings.SettingsViewModel;
import com.personalfinance.app.presentation.settings.SettingsViewModel_HiltModules_KeyModule_ProvideFactory;
import com.personalfinance.app.presentation.theme.ThemeManager;
import com.personalfinance.app.presentation.transaction.AddTransactionViewModel;
import com.personalfinance.app.presentation.transaction.AddTransactionViewModel_HiltModules_KeyModule_ProvideFactory;
import com.personalfinance.app.presentation.transactions.TransactionsViewModel;
import com.personalfinance.app.presentation.transactions.TransactionsViewModel_HiltModules_KeyModule_ProvideFactory;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DaggerPersonalFinanceApplication_HiltComponents_SingletonC {
  private DaggerPersonalFinanceApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder appModule(AppModule appModule) {
      Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder databaseModule(DatabaseModule databaseModule) {
      Preconditions.checkNotNull(databaseModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule(
        HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule) {
      Preconditions.checkNotNull(hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder networkModule(NetworkModule networkModule) {
      Preconditions.checkNotNull(networkModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder preferencesModule(PreferencesModule preferencesModule) {
      Preconditions.checkNotNull(preferencesModule);
      return this;
    }

    public PersonalFinanceApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements PersonalFinanceApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public PersonalFinanceApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl(singletonCImpl);
    }
  }

  private static final class ActivityCBuilder implements PersonalFinanceApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public PersonalFinanceApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements PersonalFinanceApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public PersonalFinanceApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements PersonalFinanceApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public PersonalFinanceApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements PersonalFinanceApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public PersonalFinanceApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements PersonalFinanceApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public PersonalFinanceApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements PersonalFinanceApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public PersonalFinanceApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends PersonalFinanceApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends PersonalFinanceApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends PersonalFinanceApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends PersonalFinanceApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
      injectMainActivity2(mainActivity);
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return ImmutableSet.<String>of(AddTransactionViewModel_HiltModules_KeyModule_ProvideFactory.provide(), AnalyticsViewModel_HiltModules_KeyModule_ProvideFactory.provide(), AuthViewModel_HiltModules_KeyModule_ProvideFactory.provide(), BudgetViewModel_HiltModules_KeyModule_ProvideFactory.provide(), CategoriesViewModel_HiltModules_KeyModule_ProvideFactory.provide(), HomeViewModel_HiltModules_KeyModule_ProvideFactory.provide(), OnboardingViewModel_HiltModules_KeyModule_ProvideFactory.provide(), RecurringTransactionsViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SettingsViewModel_HiltModules_KeyModule_ProvideFactory.provide(), TransactionsViewModel_HiltModules_KeyModule_ProvideFactory.provide());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @CanIgnoreReturnValue
    private MainActivity injectMainActivity2(MainActivity instance) {
      MainActivity_MembersInjector.injectThemeManager(instance, singletonCImpl.provideThemeManagerProvider.get());
      return instance;
    }
  }

  private static final class ViewModelCImpl extends PersonalFinanceApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AddTransactionViewModel> addTransactionViewModelProvider;

    private Provider<AnalyticsViewModel> analyticsViewModelProvider;

    private Provider<AuthViewModel> authViewModelProvider;

    private Provider<BudgetViewModel> budgetViewModelProvider;

    private Provider<CategoriesViewModel> categoriesViewModelProvider;

    private Provider<HomeViewModel> homeViewModelProvider;

    private Provider<OnboardingViewModel> onboardingViewModelProvider;

    private Provider<RecurringTransactionsViewModel> recurringTransactionsViewModelProvider;

    private Provider<SettingsViewModel> settingsViewModelProvider;

    private Provider<TransactionsViewModel> transactionsViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.addTransactionViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.analyticsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.authViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.budgetViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.categoriesViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.onboardingViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.recurringTransactionsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.settingsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
      this.transactionsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 9);
    }

    @Override
    public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
      return ImmutableMap.<String, Provider<ViewModel>>builderWithExpectedSize(10).put("com.personalfinance.app.presentation.transaction.AddTransactionViewModel", ((Provider) addTransactionViewModelProvider)).put("com.personalfinance.app.presentation.analytics.AnalyticsViewModel", ((Provider) analyticsViewModelProvider)).put("com.personalfinance.app.presentation.auth.AuthViewModel", ((Provider) authViewModelProvider)).put("com.personalfinance.app.presentation.budget.BudgetViewModel", ((Provider) budgetViewModelProvider)).put("com.personalfinance.app.presentation.categories.CategoriesViewModel", ((Provider) categoriesViewModelProvider)).put("com.personalfinance.app.presentation.home.HomeViewModel", ((Provider) homeViewModelProvider)).put("com.personalfinance.app.presentation.onboarding.OnboardingViewModel", ((Provider) onboardingViewModelProvider)).put("com.personalfinance.app.presentation.recurring.RecurringTransactionsViewModel", ((Provider) recurringTransactionsViewModelProvider)).put("com.personalfinance.app.presentation.settings.SettingsViewModel", ((Provider) settingsViewModelProvider)).put("com.personalfinance.app.presentation.transactions.TransactionsViewModel", ((Provider) transactionsViewModelProvider)).build();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.personalfinance.app.presentation.transaction.AddTransactionViewModel 
          return (T) new AddTransactionViewModel(singletonCImpl.bindTransactionRepositoryProvider.get(), singletonCImpl.bindCategoryRepositoryProvider.get(), singletonCImpl.bindAuthRepositoryProvider.get());

          case 1: // com.personalfinance.app.presentation.analytics.AnalyticsViewModel 
          return (T) new AnalyticsViewModel(singletonCImpl.bindAnalyticsRepositoryProvider.get());

          case 2: // com.personalfinance.app.presentation.auth.AuthViewModel 
          return (T) new AuthViewModel(singletonCImpl.bindAuthRepositoryProvider.get());

          case 3: // com.personalfinance.app.presentation.budget.BudgetViewModel 
          return (T) new BudgetViewModel(singletonCImpl.bindBudgetRepositoryProvider.get());

          case 4: // com.personalfinance.app.presentation.categories.CategoriesViewModel 
          return (T) new CategoriesViewModel(singletonCImpl.bindCategoryRepositoryProvider.get());

          case 5: // com.personalfinance.app.presentation.home.HomeViewModel 
          return (T) new HomeViewModel(singletonCImpl.bindTransactionRepositoryProvider.get());

          case 6: // com.personalfinance.app.presentation.onboarding.OnboardingViewModel 
          return (T) new OnboardingViewModel(singletonCImpl.onboardingPreferencesProvider.get());

          case 7: // com.personalfinance.app.presentation.recurring.RecurringTransactionsViewModel 
          return (T) new RecurringTransactionsViewModel(singletonCImpl.bindRecurringTransactionRepositoryProvider.get());

          case 8: // com.personalfinance.app.presentation.settings.SettingsViewModel 
          return (T) new SettingsViewModel(singletonCImpl.provideThemeManagerProvider.get(), singletonCImpl.provideThemePreferencesProvider.get());

          case 9: // com.personalfinance.app.presentation.transactions.TransactionsViewModel 
          return (T) new TransactionsViewModel(singletonCImpl.bindTransactionRepositoryProvider.get(), singletonCImpl.bindCategoryRepositoryProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends PersonalFinanceApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends PersonalFinanceApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }

    @Override
    public void injectPersonalFinanceMessagingService(
        PersonalFinanceMessagingService personalFinanceMessagingService) {
    }
  }

  private static final class SingletonCImpl extends PersonalFinanceApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<ThemePreferences> provideThemePreferencesProvider;

    private Provider<ThemeManager> provideThemeManagerProvider;

    private Provider<PersonalFinanceDatabase> providePersonalFinanceDatabaseProvider;

    private Provider<TransactionRepositoryImpl> transactionRepositoryImplProvider;

    private Provider<TransactionRepository> bindTransactionRepositoryProvider;

    private Provider<CategoryRepositoryImpl> categoryRepositoryImplProvider;

    private Provider<CategoryRepository> bindCategoryRepositoryProvider;

    private Provider<FirebaseAuth> provideFirebaseAuthProvider;

    private Provider<AuthRepositoryImpl> authRepositoryImplProvider;

    private Provider<AuthRepository> bindAuthRepositoryProvider;

    private Provider<AnalyticsRepositoryImpl> analyticsRepositoryImplProvider;

    private Provider<AnalyticsRepository> bindAnalyticsRepositoryProvider;

    private Provider<BudgetRepositoryImpl> budgetRepositoryImplProvider;

    private Provider<BudgetRepository> bindBudgetRepositoryProvider;

    private Provider<Context> provideContextProvider;

    private Provider<OnboardingPreferences> onboardingPreferencesProvider;

    private Provider<RecurringTransactionRepositoryImpl> recurringTransactionRepositoryImplProvider;

    private Provider<RecurringTransactionRepository> bindRecurringTransactionRepositoryProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private TransactionDao transactionDao() {
      return DatabaseModule_ProvideTransactionDaoFactory.provideTransactionDao(providePersonalFinanceDatabaseProvider.get());
    }

    private CategoryDao categoryDao() {
      return DatabaseModule_ProvideCategoryDaoFactory.provideCategoryDao(providePersonalFinanceDatabaseProvider.get());
    }

    private UserDao userDao() {
      return DatabaseModule_ProvideUserDaoFactory.provideUserDao(providePersonalFinanceDatabaseProvider.get());
    }

    private BudgetDao budgetDao() {
      return DatabaseModule_ProvideBudgetDaoFactory.provideBudgetDao(providePersonalFinanceDatabaseProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideThemePreferencesProvider = DoubleCheck.provider(new SwitchingProvider<ThemePreferences>(singletonCImpl, 1));
      this.provideThemeManagerProvider = DoubleCheck.provider(new SwitchingProvider<ThemeManager>(singletonCImpl, 0));
      this.providePersonalFinanceDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<PersonalFinanceDatabase>(singletonCImpl, 3));
      this.transactionRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 2);
      this.bindTransactionRepositoryProvider = DoubleCheck.provider((Provider) transactionRepositoryImplProvider);
      this.categoryRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 4);
      this.bindCategoryRepositoryProvider = DoubleCheck.provider((Provider) categoryRepositoryImplProvider);
      this.provideFirebaseAuthProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseAuth>(singletonCImpl, 6));
      this.authRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 5);
      this.bindAuthRepositoryProvider = DoubleCheck.provider((Provider) authRepositoryImplProvider);
      this.analyticsRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 7);
      this.bindAnalyticsRepositoryProvider = DoubleCheck.provider((Provider) analyticsRepositoryImplProvider);
      this.budgetRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 8);
      this.bindBudgetRepositoryProvider = DoubleCheck.provider((Provider) budgetRepositoryImplProvider);
      this.provideContextProvider = DoubleCheck.provider(new SwitchingProvider<Context>(singletonCImpl, 10));
      this.onboardingPreferencesProvider = DoubleCheck.provider(new SwitchingProvider<OnboardingPreferences>(singletonCImpl, 9));
      this.recurringTransactionRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 11);
      this.bindRecurringTransactionRepositoryProvider = DoubleCheck.provider((Provider) recurringTransactionRepositoryImplProvider);
    }

    @Override
    public void injectPersonalFinanceApplication(
        PersonalFinanceApplication personalFinanceApplication) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.personalfinance.app.presentation.theme.ThemeManager 
          return (T) PreferencesModule_ProvideThemeManagerFactory.provideThemeManager(singletonCImpl.provideThemePreferencesProvider.get());

          case 1: // com.personalfinance.app.data.preferences.ThemePreferences 
          return (T) PreferencesModule_ProvideThemePreferencesFactory.provideThemePreferences(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 2: // com.personalfinance.app.data.repository.TransactionRepositoryImpl 
          return (T) new TransactionRepositoryImpl(singletonCImpl.transactionDao());

          case 3: // com.personalfinance.app.data.local.database.PersonalFinanceDatabase 
          return (T) DatabaseModule_ProvidePersonalFinanceDatabaseFactory.providePersonalFinanceDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 4: // com.personalfinance.app.data.repository.CategoryRepositoryImpl 
          return (T) new CategoryRepositoryImpl(singletonCImpl.categoryDao());

          case 5: // com.personalfinance.app.data.repository.AuthRepositoryImpl 
          return (T) new AuthRepositoryImpl(singletonCImpl.provideFirebaseAuthProvider.get(), singletonCImpl.userDao());

          case 6: // com.google.firebase.auth.FirebaseAuth 
          return (T) NetworkModule_ProvideFirebaseAuthFactory.provideFirebaseAuth();

          case 7: // com.personalfinance.app.data.repository.AnalyticsRepositoryImpl 
          return (T) new AnalyticsRepositoryImpl(singletonCImpl.transactionDao(), singletonCImpl.categoryDao(), singletonCImpl.budgetDao());

          case 8: // com.personalfinance.app.data.repository.BudgetRepositoryImpl 
          return (T) new BudgetRepositoryImpl(singletonCImpl.budgetDao(), singletonCImpl.transactionDao());

          case 9: // com.personalfinance.app.data.preferences.OnboardingPreferences 
          return (T) new OnboardingPreferences(singletonCImpl.provideContextProvider.get());

          case 10: // android.content.Context 
          return (T) AppModule_ProvideContextFactory.provideContext(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 11: // com.personalfinance.app.data.repository.RecurringTransactionRepositoryImpl 
          return (T) new RecurringTransactionRepositoryImpl(singletonCImpl.transactionDao(), singletonCImpl.bindTransactionRepositoryProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
