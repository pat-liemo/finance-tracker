package com.personalfinance.app.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.personalfinance.app.data.local.converter.DateTimeConverter;
import com.personalfinance.app.data.local.converter.PaymentScheduleConverter;
import com.personalfinance.app.data.local.entity.DebtEntity;
import com.personalfinance.app.domain.model.PaymentSchedule;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.datetime.LocalDate;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DebtDao_Impl implements DebtDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DebtEntity> __insertionAdapterOfDebtEntity;

  private final DateTimeConverter __dateTimeConverter = new DateTimeConverter();

  private final PaymentScheduleConverter __paymentScheduleConverter = new PaymentScheduleConverter();

  private final EntityDeletionOrUpdateAdapter<DebtEntity> __deletionAdapterOfDebtEntity;

  private final EntityDeletionOrUpdateAdapter<DebtEntity> __updateAdapterOfDebtEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteDebtById;

  public DebtDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDebtEntity = new EntityInsertionAdapter<DebtEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `debts` (`id`,`creditorName`,`originalAmount`,`currentBalance`,`interestRate`,`minimumPayment`,`dueDate`,`paymentSchedule`,`isActive`,`userId`,`createdAt`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DebtEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getCreditorName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCreditorName());
        }
        statement.bindDouble(3, entity.getOriginalAmount());
        statement.bindDouble(4, entity.getCurrentBalance());
        statement.bindDouble(5, entity.getInterestRate());
        statement.bindDouble(6, entity.getMinimumPayment());
        final String _tmp = __dateTimeConverter.fromLocalDate(entity.getDueDate());
        if (_tmp == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, _tmp);
        }
        final String _tmp_1 = __paymentScheduleConverter.fromPaymentSchedule(entity.getPaymentSchedule());
        if (_tmp_1 == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp_1);
        }
        final int _tmp_2 = entity.isActive() ? 1 : 0;
        statement.bindLong(9, _tmp_2);
        if (entity.getUserId() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getUserId());
        }
        statement.bindLong(11, entity.getCreatedAt());
        statement.bindLong(12, entity.getUpdatedAt());
      }
    };
    this.__deletionAdapterOfDebtEntity = new EntityDeletionOrUpdateAdapter<DebtEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `debts` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DebtEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfDebtEntity = new EntityDeletionOrUpdateAdapter<DebtEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `debts` SET `id` = ?,`creditorName` = ?,`originalAmount` = ?,`currentBalance` = ?,`interestRate` = ?,`minimumPayment` = ?,`dueDate` = ?,`paymentSchedule` = ?,`isActive` = ?,`userId` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DebtEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getCreditorName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCreditorName());
        }
        statement.bindDouble(3, entity.getOriginalAmount());
        statement.bindDouble(4, entity.getCurrentBalance());
        statement.bindDouble(5, entity.getInterestRate());
        statement.bindDouble(6, entity.getMinimumPayment());
        final String _tmp = __dateTimeConverter.fromLocalDate(entity.getDueDate());
        if (_tmp == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, _tmp);
        }
        final String _tmp_1 = __paymentScheduleConverter.fromPaymentSchedule(entity.getPaymentSchedule());
        if (_tmp_1 == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp_1);
        }
        final int _tmp_2 = entity.isActive() ? 1 : 0;
        statement.bindLong(9, _tmp_2);
        if (entity.getUserId() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getUserId());
        }
        statement.bindLong(11, entity.getCreatedAt());
        statement.bindLong(12, entity.getUpdatedAt());
        statement.bindLong(13, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteDebtById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM debts WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertDebt(final DebtEntity debt, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfDebtEntity.insertAndReturnId(debt);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteDebt(final DebtEntity debt, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfDebtEntity.handle(debt);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateDebt(final DebtEntity debt, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfDebtEntity.handle(debt);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteDebtById(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteDebtById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteDebtById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<DebtEntity>> getAllDebts(final String userId) {
    final String _sql = "SELECT * FROM debts WHERE userId = ? ORDER BY dueDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"debts"}, new Callable<List<DebtEntity>>() {
      @Override
      @NonNull
      public List<DebtEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreditorName = CursorUtil.getColumnIndexOrThrow(_cursor, "creditorName");
          final int _cursorIndexOfOriginalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "originalAmount");
          final int _cursorIndexOfCurrentBalance = CursorUtil.getColumnIndexOrThrow(_cursor, "currentBalance");
          final int _cursorIndexOfInterestRate = CursorUtil.getColumnIndexOrThrow(_cursor, "interestRate");
          final int _cursorIndexOfMinimumPayment = CursorUtil.getColumnIndexOrThrow(_cursor, "minimumPayment");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfPaymentSchedule = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentSchedule");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<DebtEntity> _result = new ArrayList<DebtEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DebtEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpCreditorName;
            if (_cursor.isNull(_cursorIndexOfCreditorName)) {
              _tmpCreditorName = null;
            } else {
              _tmpCreditorName = _cursor.getString(_cursorIndexOfCreditorName);
            }
            final double _tmpOriginalAmount;
            _tmpOriginalAmount = _cursor.getDouble(_cursorIndexOfOriginalAmount);
            final double _tmpCurrentBalance;
            _tmpCurrentBalance = _cursor.getDouble(_cursorIndexOfCurrentBalance);
            final double _tmpInterestRate;
            _tmpInterestRate = _cursor.getDouble(_cursorIndexOfInterestRate);
            final double _tmpMinimumPayment;
            _tmpMinimumPayment = _cursor.getDouble(_cursorIndexOfMinimumPayment);
            final LocalDate _tmpDueDate;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDueDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDueDate);
            }
            _tmpDueDate = __dateTimeConverter.toLocalDate(_tmp);
            final PaymentSchedule _tmpPaymentSchedule;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPaymentSchedule)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfPaymentSchedule);
            }
            _tmpPaymentSchedule = __paymentScheduleConverter.toPaymentSchedule(_tmp_1);
            final boolean _tmpIsActive;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_2 != 0;
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new DebtEntity(_tmpId,_tmpCreditorName,_tmpOriginalAmount,_tmpCurrentBalance,_tmpInterestRate,_tmpMinimumPayment,_tmpDueDate,_tmpPaymentSchedule,_tmpIsActive,_tmpUserId,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getDebtById(final long id, final Continuation<? super DebtEntity> $completion) {
    final String _sql = "SELECT * FROM debts WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<DebtEntity>() {
      @Override
      @Nullable
      public DebtEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreditorName = CursorUtil.getColumnIndexOrThrow(_cursor, "creditorName");
          final int _cursorIndexOfOriginalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "originalAmount");
          final int _cursorIndexOfCurrentBalance = CursorUtil.getColumnIndexOrThrow(_cursor, "currentBalance");
          final int _cursorIndexOfInterestRate = CursorUtil.getColumnIndexOrThrow(_cursor, "interestRate");
          final int _cursorIndexOfMinimumPayment = CursorUtil.getColumnIndexOrThrow(_cursor, "minimumPayment");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfPaymentSchedule = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentSchedule");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final DebtEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpCreditorName;
            if (_cursor.isNull(_cursorIndexOfCreditorName)) {
              _tmpCreditorName = null;
            } else {
              _tmpCreditorName = _cursor.getString(_cursorIndexOfCreditorName);
            }
            final double _tmpOriginalAmount;
            _tmpOriginalAmount = _cursor.getDouble(_cursorIndexOfOriginalAmount);
            final double _tmpCurrentBalance;
            _tmpCurrentBalance = _cursor.getDouble(_cursorIndexOfCurrentBalance);
            final double _tmpInterestRate;
            _tmpInterestRate = _cursor.getDouble(_cursorIndexOfInterestRate);
            final double _tmpMinimumPayment;
            _tmpMinimumPayment = _cursor.getDouble(_cursorIndexOfMinimumPayment);
            final LocalDate _tmpDueDate;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDueDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDueDate);
            }
            _tmpDueDate = __dateTimeConverter.toLocalDate(_tmp);
            final PaymentSchedule _tmpPaymentSchedule;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPaymentSchedule)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfPaymentSchedule);
            }
            _tmpPaymentSchedule = __paymentScheduleConverter.toPaymentSchedule(_tmp_1);
            final boolean _tmpIsActive;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_2 != 0;
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new DebtEntity(_tmpId,_tmpCreditorName,_tmpOriginalAmount,_tmpCurrentBalance,_tmpInterestRate,_tmpMinimumPayment,_tmpDueDate,_tmpPaymentSchedule,_tmpIsActive,_tmpUserId,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<DebtEntity>> getActiveDebts(final String userId) {
    final String _sql = "SELECT * FROM debts WHERE userId = ? AND isActive = 1 ORDER BY dueDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"debts"}, new Callable<List<DebtEntity>>() {
      @Override
      @NonNull
      public List<DebtEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreditorName = CursorUtil.getColumnIndexOrThrow(_cursor, "creditorName");
          final int _cursorIndexOfOriginalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "originalAmount");
          final int _cursorIndexOfCurrentBalance = CursorUtil.getColumnIndexOrThrow(_cursor, "currentBalance");
          final int _cursorIndexOfInterestRate = CursorUtil.getColumnIndexOrThrow(_cursor, "interestRate");
          final int _cursorIndexOfMinimumPayment = CursorUtil.getColumnIndexOrThrow(_cursor, "minimumPayment");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfPaymentSchedule = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentSchedule");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<DebtEntity> _result = new ArrayList<DebtEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DebtEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpCreditorName;
            if (_cursor.isNull(_cursorIndexOfCreditorName)) {
              _tmpCreditorName = null;
            } else {
              _tmpCreditorName = _cursor.getString(_cursorIndexOfCreditorName);
            }
            final double _tmpOriginalAmount;
            _tmpOriginalAmount = _cursor.getDouble(_cursorIndexOfOriginalAmount);
            final double _tmpCurrentBalance;
            _tmpCurrentBalance = _cursor.getDouble(_cursorIndexOfCurrentBalance);
            final double _tmpInterestRate;
            _tmpInterestRate = _cursor.getDouble(_cursorIndexOfInterestRate);
            final double _tmpMinimumPayment;
            _tmpMinimumPayment = _cursor.getDouble(_cursorIndexOfMinimumPayment);
            final LocalDate _tmpDueDate;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDueDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDueDate);
            }
            _tmpDueDate = __dateTimeConverter.toLocalDate(_tmp);
            final PaymentSchedule _tmpPaymentSchedule;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPaymentSchedule)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfPaymentSchedule);
            }
            _tmpPaymentSchedule = __paymentScheduleConverter.toPaymentSchedule(_tmp_1);
            final boolean _tmpIsActive;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_2 != 0;
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new DebtEntity(_tmpId,_tmpCreditorName,_tmpOriginalAmount,_tmpCurrentBalance,_tmpInterestRate,_tmpMinimumPayment,_tmpDueDate,_tmpPaymentSchedule,_tmpIsActive,_tmpUserId,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
