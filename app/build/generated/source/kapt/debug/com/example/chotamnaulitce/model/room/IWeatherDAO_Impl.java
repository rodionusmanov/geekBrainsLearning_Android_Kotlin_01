package com.example.chotamnaulitce.model.room;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class IWeatherDAO_Impl implements IWeatherDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WeatherEntity> __insertionAdapterOfWeatherEntity;

  private final SharedSQLiteStatement __preparedStmtOfInsertNative;

  public IWeatherDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWeatherEntity = new EntityInsertionAdapter<WeatherEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `weather_entity_table` (`id`,`name`,`latitude`,`longitude`,`temperatureActual`,`temperatureFeels`,`humidity`,`condition`,`windSpeed`,`windDirection`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WeatherEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindDouble(3, value.getLatitude());
        stmt.bindDouble(4, value.getLongitude());
        stmt.bindLong(5, value.getTemperatureActual());
        stmt.bindLong(6, value.getTemperatureFeels());
        stmt.bindLong(7, value.getHumidity());
        if (value.getCondition() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCondition());
        }
        stmt.bindDouble(9, value.getWindSpeed());
        if (value.getWindDirection() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getWindDirection());
        }
      }
    };
    this.__preparedStmtOfInsertNative = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "INSERT INTO weather_entity_table (id, name, latitude, longitude, temperatureActual, temperatureFeels, humidity, condition, windSpeed, windDirection) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return _query;
      }
    };
  }

  @Override
  public void insertRoom(final WeatherEntity weatherEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWeatherEntity.insert(weatherEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertNative(final long id, final String name, final double latitude,
      final double longitude, final int temperatureActual, final int temperatureFeels,
      final int humidity, final String condition, final double windSpeed,
      final String windDirection) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfInsertNative.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    _argIndex = 2;
    if (name == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, name);
    }
    _argIndex = 3;
    _stmt.bindDouble(_argIndex, latitude);
    _argIndex = 4;
    _stmt.bindDouble(_argIndex, longitude);
    _argIndex = 5;
    _stmt.bindLong(_argIndex, temperatureActual);
    _argIndex = 6;
    _stmt.bindLong(_argIndex, temperatureFeels);
    _argIndex = 7;
    _stmt.bindLong(_argIndex, humidity);
    _argIndex = 8;
    if (condition == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, condition);
    }
    _argIndex = 9;
    _stmt.bindDouble(_argIndex, windSpeed);
    _argIndex = 10;
    if (windDirection == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, windDirection);
    }
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfInsertNative.release(_stmt);
    }
  }

  @Override
  public List<WeatherEntity> getWeatherByLocation(final double mLatitude, final double mLongitude) {
    final String _sql = "SELECT * FROM weather_entity_table WHERE latitude=? AND longitude=? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindDouble(_argIndex, mLatitude);
    _argIndex = 2;
    _statement.bindDouble(_argIndex, mLongitude);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final int _cursorIndexOfTemperatureActual = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureActual");
      final int _cursorIndexOfTemperatureFeels = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureFeels");
      final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
      final int _cursorIndexOfCondition = CursorUtil.getColumnIndexOrThrow(_cursor, "condition");
      final int _cursorIndexOfWindSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "windSpeed");
      final int _cursorIndexOfWindDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "windDirection");
      final List<WeatherEntity> _result = new ArrayList<WeatherEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WeatherEntity _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final double _tmpLatitude;
        _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        final double _tmpLongitude;
        _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
        final int _tmpTemperatureActual;
        _tmpTemperatureActual = _cursor.getInt(_cursorIndexOfTemperatureActual);
        final int _tmpTemperatureFeels;
        _tmpTemperatureFeels = _cursor.getInt(_cursorIndexOfTemperatureFeels);
        final int _tmpHumidity;
        _tmpHumidity = _cursor.getInt(_cursorIndexOfHumidity);
        final String _tmpCondition;
        if (_cursor.isNull(_cursorIndexOfCondition)) {
          _tmpCondition = null;
        } else {
          _tmpCondition = _cursor.getString(_cursorIndexOfCondition);
        }
        final double _tmpWindSpeed;
        _tmpWindSpeed = _cursor.getDouble(_cursorIndexOfWindSpeed);
        final String _tmpWindDirection;
        if (_cursor.isNull(_cursorIndexOfWindDirection)) {
          _tmpWindDirection = null;
        } else {
          _tmpWindDirection = _cursor.getString(_cursorIndexOfWindDirection);
        }
        _item = new WeatherEntity(_tmpId,_tmpName,_tmpLatitude,_tmpLongitude,_tmpTemperatureActual,_tmpTemperatureFeels,_tmpHumidity,_tmpCondition,_tmpWindSpeed,_tmpWindDirection);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<WeatherEntity> getWeatherAll() {
    final String _sql = "SELECT * FROM weather_entity_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final int _cursorIndexOfTemperatureActual = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureActual");
      final int _cursorIndexOfTemperatureFeels = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureFeels");
      final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
      final int _cursorIndexOfCondition = CursorUtil.getColumnIndexOrThrow(_cursor, "condition");
      final int _cursorIndexOfWindSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "windSpeed");
      final int _cursorIndexOfWindDirection = CursorUtil.getColumnIndexOrThrow(_cursor, "windDirection");
      final List<WeatherEntity> _result = new ArrayList<WeatherEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WeatherEntity _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final double _tmpLatitude;
        _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        final double _tmpLongitude;
        _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
        final int _tmpTemperatureActual;
        _tmpTemperatureActual = _cursor.getInt(_cursorIndexOfTemperatureActual);
        final int _tmpTemperatureFeels;
        _tmpTemperatureFeels = _cursor.getInt(_cursorIndexOfTemperatureFeels);
        final int _tmpHumidity;
        _tmpHumidity = _cursor.getInt(_cursorIndexOfHumidity);
        final String _tmpCondition;
        if (_cursor.isNull(_cursorIndexOfCondition)) {
          _tmpCondition = null;
        } else {
          _tmpCondition = _cursor.getString(_cursorIndexOfCondition);
        }
        final double _tmpWindSpeed;
        _tmpWindSpeed = _cursor.getDouble(_cursorIndexOfWindSpeed);
        final String _tmpWindDirection;
        if (_cursor.isNull(_cursorIndexOfWindDirection)) {
          _tmpWindDirection = null;
        } else {
          _tmpWindDirection = _cursor.getString(_cursorIndexOfWindDirection);
        }
        _item = new WeatherEntity(_tmpId,_tmpName,_tmpLatitude,_tmpLongitude,_tmpTemperatureActual,_tmpTemperatureFeels,_tmpHumidity,_tmpCondition,_tmpWindSpeed,_tmpWindDirection);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
