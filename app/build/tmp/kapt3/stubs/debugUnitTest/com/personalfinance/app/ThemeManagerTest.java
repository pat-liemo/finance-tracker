package com.personalfinance.app;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import com.personalfinance.app.data.preferences.ThemeMode;
import com.personalfinance.app.data.preferences.ThemePreferences;
import com.personalfinance.app.presentation.theme.ThemeManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@org.junit.runner.RunWith(value = org.robolectric.RobolectricTestRunner.class)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\f\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0007J\f\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0007J\b\u0010\r\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/personalfinance/app/ThemeManagerTest;", "", "()V", "context", "Landroid/content/Context;", "themeManager", "Lcom/personalfinance/app/presentation/theme/ThemeManager;", "themePreferences", "Lcom/personalfinance/app/data/preferences/ThemePreferences;", "default theme mode should be SYSTEM", "", "Lkotlinx/coroutines/test/TestResult;", "setting theme mode should persist the value", "setup", "app_debugUnitTest"})
public final class ThemeManagerTest {
    private android.content.Context context;
    private com.personalfinance.app.data.preferences.ThemePreferences themePreferences;
    private com.personalfinance.app.presentation.theme.ThemeManager themeManager;
    
    public ThemeManagerTest() {
        super();
    }
    
    @org.junit.Before()
    public final void setup() {
    }
}