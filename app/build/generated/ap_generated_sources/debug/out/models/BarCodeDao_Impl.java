package models;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BarCodeDao_Impl implements BarCodeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BarCode> __insertionAdapterOfBarCode;

  private final EntityDeletionOrUpdateAdapter<BarCode> __deletionAdapterOfBarCode;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllBarCodes;

  public BarCodeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBarCode = new EntityInsertionAdapter<BarCode>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `BarCode` (`uid`,`bar_code`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BarCode value) {
        stmt.bindLong(1, value.uid);
        if (value.bar_code == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.bar_code);
        }
      }
    };
    this.__deletionAdapterOfBarCode = new EntityDeletionOrUpdateAdapter<BarCode>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `BarCode` WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BarCode value) {
        stmt.bindLong(1, value.uid);
      }
    };
    this.__preparedStmtOfDeleteAllBarCodes = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE from BarCode";
        return _query;
      }
    };
  }

  @Override
  public void insertBarCode(final BarCode... barCodes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBarCode.insert(barCodes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteBarCode(final BarCode barCode) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfBarCode.handle(barCode);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllBarCodes() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllBarCodes.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllBarCodes.release(_stmt);
    }
  }

  @Override
  public List<BarCode> getAllBarCodes() {
    final String _sql = "SELECT * from BarCode";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfBarCode = CursorUtil.getColumnIndexOrThrow(_cursor, "bar_code");
      final List<BarCode> _result = new ArrayList<BarCode>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BarCode _item;
        _item = new BarCode();
        _item.uid = _cursor.getInt(_cursorIndexOfUid);
        _item.bar_code = _cursor.getString(_cursorIndexOfBarCode);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
