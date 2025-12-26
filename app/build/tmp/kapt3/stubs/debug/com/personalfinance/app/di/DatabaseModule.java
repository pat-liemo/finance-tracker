package com.personalfinance.app.di;

import android.content.Context;
import androidx.room.Room;
import com.personalfinance.app.data.local.database.PersonalFinanceDatabase;
import com.personalfinance.app.data.local.dao.TransactionDao;
import com.personalfinance.app.data.local.dao.CategoryDao;
import com.personalfinance.app.data.local.dao.BudgetDao;
import com.personalfinance.app.data.local.dao.UserDao;
import com.personalfinance.app.data.local.dao.DebtDao;
import com.personalfinance.app.data.local.dao.SavingsGoalDao;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/personalfinance/app/di/DatabaseModule;", "", "()V", "provideBudgetDao", "Lcom/personalfinance/app/data/local/dao/BudgetDao;", "database", "Lcom/personalfinance/app/data/local/database/PersonalFinanceDatabase;", "provideCategoryDao", "Lcom/personalfinance/app/data/local/dao/CategoryDao;", "provideDebtDao", "Lcom/personalfinance/app/data/local/dao/DebtDao;", "providePersonalFinanceDatabase", "context", "Landroid/content/Context;", "provideSavingsGoalDao", "Lcom/personalfinance/app/data/local/dao/SavingsGoalDao;", "provideTransactionDao", "Lcom/personalfinance/app/data/local/dao/TransactionDao;", "provideUserDao", "Lcom/personalfinance/app/data/local/dao/UserDao;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.personalfinance.app.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.data.local.database.PersonalFinanceDatabase providePersonalFinanceDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.data.local.dao.TransactionDao provideTransactionDao(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.database.PersonalFinanceDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.data.local.dao.CategoryDao provideCategoryDao(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.database.PersonalFinanceDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.data.local.dao.BudgetDao provideBudgetDao(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.database.PersonalFinanceDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.data.local.dao.UserDao provideUserDao(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.database.PersonalFinanceDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.data.local.dao.DebtDao provideDebtDao(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.database.PersonalFinanceDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.data.local.dao.SavingsGoalDao provideSavingsGoalDao(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.database.PersonalFinanceDatabase database) {
        return null;
    }
}