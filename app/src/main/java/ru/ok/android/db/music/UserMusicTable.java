package ru.ok.android.db.music;

import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.Map;
import ru.ok.android.db.base.BaseTable;

public class UserMusicTable extends BaseTable {
    protected void fillColumns(Map<String, String> columns) {
        columns.put("_id", "INTEGER PRIMARY KEY AUTOINCREMENT");
        columns.put("track_id", "INTEGER");
        columns.put("user_id", "TEXT");
        columns.put("_index", "INTEGER");
    }

    public String getTableName() {
        return "user_music";
    }

    public void fillUpgradeScript(SQLiteDatabase db, List<String> sqlCommands, int oldVersion, int newVersion) {
        if (oldVersion < 53 && newVersion >= 53) {
            sqlCommands.add(createBaseTableCreateScript());
        }
        if (oldVersion <= 53 && newVersion >= 54) {
            sqlCommands.add("ALTER TABLE user_music ADD COLUMN _index INTEGER");
        }
    }
}
