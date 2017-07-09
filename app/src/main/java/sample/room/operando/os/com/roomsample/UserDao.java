package sample.room.operando.os.com.roomsample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select * from users")
    List<User> getAll();

    @Query("select * from users")
    Cursor getCursor();

    @Query("select * from users where id in (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("select first_name,last_name from users")
    List<NameTuple> loadFullName();

    @Insert
    long insert(User user);

    @Insert
    List<Long> insertAll(User... users);

    // 戻り値をList<Long>にはできない
    @Insert
    void insertBothUsers(User user1, User user2);

    // 戻り値をList<Long>にはできない
    @Insert
    void insertUsersAndFriends(User user, List<User> friends);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}