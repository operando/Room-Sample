package sample.room.operando.os.com.roomsample;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.util.StringUtil;
import android.database.Cursor;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.List;

public class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUser;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `users`(`id`,`first_name`,`last_name`,`age`,`birthday`,`uid`,`street`,`state`,`city`,`post_code`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
        if (value.getFirstName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLastName());
        }
        stmt.bindLong(4, value.age);
        final Long _tmp;
        _tmp = DateConverter.fromDateToTime(value.birthday);
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        if (value.uid == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.uid);
        }
        final Address _tmpAddress = value.address;
        if(_tmpAddress != null) {
          if (_tmpAddress.street == null) {
            stmt.bindNull(7);
          } else {
            stmt.bindString(7, _tmpAddress.street);
          }
          if (_tmpAddress.state == null) {
            stmt.bindNull(8);
          } else {
            stmt.bindString(8, _tmpAddress.state);
          }
          if (_tmpAddress.city == null) {
            stmt.bindNull(9);
          } else {
            stmt.bindString(9, _tmpAddress.city);
          }
          stmt.bindLong(10, _tmpAddress.postCode);
        } else {
          stmt.bindNull(7);
          stmt.bindNull(8);
          stmt.bindNull(9);
          stmt.bindNull(10);
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `users` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `users` SET `id` = ?,`first_name` = ?,`last_name` = ?,`age` = ?,`birthday` = ?,`uid` = ?,`street` = ?,`state` = ?,`city` = ?,`post_code` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
        if (value.getFirstName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLastName());
        }
        stmt.bindLong(4, value.age);
        final Long _tmp;
        _tmp = DateConverter.fromDateToTime(value.birthday);
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        if (value.uid == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.uid);
        }
        final Address _tmpAddress = value.address;
        if(_tmpAddress != null) {
          if (_tmpAddress.street == null) {
            stmt.bindNull(7);
          } else {
            stmt.bindString(7, _tmpAddress.street);
          }
          if (_tmpAddress.state == null) {
            stmt.bindNull(8);
          } else {
            stmt.bindString(8, _tmpAddress.state);
          }
          if (_tmpAddress.city == null) {
            stmt.bindNull(9);
          } else {
            stmt.bindString(9, _tmpAddress.city);
          }
          stmt.bindLong(10, _tmpAddress.postCode);
        } else {
          stmt.bindNull(7);
          stmt.bindNull(8);
          stmt.bindNull(9);
          stmt.bindNull(10);
        }
        stmt.bindLong(11, value.getId());
      }
    };
  }

  @Override
  public long insert(User user) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfUser.insertAndReturnId(user);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Long> insertAll(User... users) {
    __db.beginTransaction();
    try {
      List<Long> _result = __insertionAdapterOfUser.insertAndReturnIdsList(users);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBothUsers(User user1, User user2) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user1);
      __insertionAdapterOfUser.insert(user2);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertUsersAndFriends(User user, List<User> friends) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __insertionAdapterOfUser.insert(friends);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(User user) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(User user) {
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<User> getAll() {
    final String _sql = "select * from users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfFirstName = _cursor.getColumnIndexOrThrow("first_name");
      final int _cursorIndexOfLastName = _cursor.getColumnIndexOrThrow("last_name");
      final int _cursorIndexOfAge = _cursor.getColumnIndexOrThrow("age");
      final int _cursorIndexOfBirthday = _cursor.getColumnIndexOrThrow("birthday");
      final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
      final int _cursorIndexOfStreet = _cursor.getColumnIndexOrThrow("street");
      final int _cursorIndexOfState = _cursor.getColumnIndexOrThrow("state");
      final int _cursorIndexOfCity = _cursor.getColumnIndexOrThrow("city");
      final int _cursorIndexOfPostCode = _cursor.getColumnIndexOrThrow("post_code");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        final Address _tmpAddress;
        if (! (_cursor.isNull(_cursorIndexOfStreet) && _cursor.isNull(_cursorIndexOfState) && _cursor.isNull(_cursorIndexOfCity) && _cursor.isNull(_cursorIndexOfPostCode))) {
          _tmpAddress = new Address();
          _tmpAddress.street = _cursor.getString(_cursorIndexOfStreet);
          _tmpAddress.state = _cursor.getString(_cursorIndexOfState);
          _tmpAddress.city = _cursor.getString(_cursorIndexOfCity);
          _tmpAddress.postCode = _cursor.getInt(_cursorIndexOfPostCode);
        }  else  {
          _tmpAddress = null;
        }
        _item = new User();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        _item.setFirstName(_tmpFirstName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _item.setLastName(_tmpLastName);
        _item.age = _cursor.getLong(_cursorIndexOfAge);
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfBirthday)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfBirthday);
        }
        _item.birthday = DateConverter.fromTimeToDate(_tmp);
        _item.uid = _cursor.getString(_cursorIndexOfUid);
        _item.address = _tmpAddress;
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Cursor getCursor() {
    final String _sql = "select * from users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.query(_statement);
  }

  @Override
  public List<User> loadAllByIds(int[] userIds) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("select * from users where id in (");
    final int _inputSize = userIds.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int _item : userIds) {
      _statement.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfFirstName = _cursor.getColumnIndexOrThrow("first_name");
      final int _cursorIndexOfLastName = _cursor.getColumnIndexOrThrow("last_name");
      final int _cursorIndexOfAge = _cursor.getColumnIndexOrThrow("age");
      final int _cursorIndexOfBirthday = _cursor.getColumnIndexOrThrow("birthday");
      final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
      final int _cursorIndexOfStreet = _cursor.getColumnIndexOrThrow("street");
      final int _cursorIndexOfState = _cursor.getColumnIndexOrThrow("state");
      final int _cursorIndexOfCity = _cursor.getColumnIndexOrThrow("city");
      final int _cursorIndexOfPostCode = _cursor.getColumnIndexOrThrow("post_code");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item_1;
        final Address _tmpAddress;
        if (! (_cursor.isNull(_cursorIndexOfStreet) && _cursor.isNull(_cursorIndexOfState) && _cursor.isNull(_cursorIndexOfCity) && _cursor.isNull(_cursorIndexOfPostCode))) {
          _tmpAddress = new Address();
          _tmpAddress.street = _cursor.getString(_cursorIndexOfStreet);
          _tmpAddress.state = _cursor.getString(_cursorIndexOfState);
          _tmpAddress.city = _cursor.getString(_cursorIndexOfCity);
          _tmpAddress.postCode = _cursor.getInt(_cursorIndexOfPostCode);
        }  else  {
          _tmpAddress = null;
        }
        _item_1 = new User();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item_1.setId(_tmpId);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        _item_1.setFirstName(_tmpFirstName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _item_1.setLastName(_tmpLastName);
        _item_1.age = _cursor.getLong(_cursorIndexOfAge);
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfBirthday)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfBirthday);
        }
        _item_1.birthday = DateConverter.fromTimeToDate(_tmp);
        _item_1.uid = _cursor.getString(_cursorIndexOfUid);
        _item_1.address = _tmpAddress;
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<NameTuple> loadFullName() {
    final String _sql = "select first_name,last_name from users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfFirstName = _cursor.getColumnIndexOrThrow("first_name");
      final int _cursorIndexOfLastName = _cursor.getColumnIndexOrThrow("last_name");
      final List<NameTuple> _result = new ArrayList<NameTuple>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final NameTuple _item;
        _item = new NameTuple();
        _item.firstName = _cursor.getString(_cursorIndexOfFirstName);
        _item.lastName = _cursor.getString(_cursorIndexOfLastName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
