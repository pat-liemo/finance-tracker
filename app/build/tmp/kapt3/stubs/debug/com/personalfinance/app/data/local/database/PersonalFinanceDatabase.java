package com.personalfinance.app.data.local.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.personalfinance.app.data.local.converter.*;
import com.personalfinance.app.data.local.dao.*;
import com.personalfinance.app.data.local.entity.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/personalfinance/app/data/local/database/PersonalFinanceDatabase;", "Landroidx/room/RoomDatabase;", "()V", "budgetDao", "Lcom/personalfinance/app/data/local/dao/BudgetDao;", "categoryDao", "Lcom/personalfinance/app/data/local/dao/CategoryDao;", "debtDao", "Lcom/personalfinance/app/data/local/dao/DebtDao;", "savingsGoalDao", "Lcom/personalfinance/app/data/local/dao/SavingsGoalDao;", "transactionDao", "Lcom/personalfinance/app/data/local/dao/TransactionDao;", "userDao", "Lcom/personalfinance/app/data/local/dao/UserDao;", "app_debug"})
@androidx.room.Database(entities = {com.personalfinance.app.data.local.entity.TransactionEntity.class, com.personalfinance.app.data.local.entity.CategoryEntity.class, com.personalfinance.app.data.local.entity.BudgetEntity.class, com.personalfinance.app.data.local.entity.UserEntity.class, com.personalfinance.app.data.local.entity.DebtEntity.class, com.personalfinance.app.data.local.entity.SavingsGoalEntity.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.personalfinance.app.data.local.converter.DateTimeConverter.class, com.personalfinance.app.data.local.converter.PaymentMethodConverter.class, com.personalfinance.app.data.local.converter.RecurringPatternConverter.class, com.personalfinance.app.data.local.converter.SyncStatusConverter.class, com.personalfinance.app.data.local.converter.StringListConverter.class, com.personalfinance.app.data.local.converter.BudgetPeriodConverter.class, com.personalfinance.app.data.local.converter.PaymentScheduleConverter.class})
public abstract class PersonalFinanceDatabase extends androidx.room.RoomDatabase {
    
    public PersonalFinanceDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.data.local.dao.TransactionDao transactionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.data.local.dao.CategoryDao categoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.data.local.dao.BudgetDao budgetDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.data.local.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.data.local.dao.DebtDao debtDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.data.local.dao.SavingsGoalDao savingsGoalDao();
}