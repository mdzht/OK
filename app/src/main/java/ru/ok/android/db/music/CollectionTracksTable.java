package ru.ok.android.db.music;

import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.Map;
import ru.ok.android.db.base.BaseTable;

public class CollectionTracksTable extends BaseTable {
    protected void fillColumns(Map<String, String> columns) {
        columns.put("_id", "INTEGER PRIMARY KEY AUTOINCREMENT");
        columns.put("collection_id", "INTEGER");
        columns.put("track_id", "INTEGER");
    }

    public String getTableName() {
        return "collection_tracks";
    }

    public void fillUpgradeScript(SQLiteDatabase db, List<String> sqlCommands, int oldVersion, int newVersion) {
        if (oldVersion < 53 && newVersion >= 53) {
            sqlCommands.add(createBaseTableCreateScript());
        }
    }
}
