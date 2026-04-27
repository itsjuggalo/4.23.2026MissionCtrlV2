package E3;

import P2.P;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements SQLiteDatabase.CursorFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f396b;

    public /* synthetic */ c(Object obj, int i) {
        this.f395a = i;
        this.f396b = obj;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        switch (this.f395a) {
            case 0:
                List list = ((q) this.f396b).f457b;
                if (list != null) {
                    int size = list.size();
                    int i = 0;
                    while (i < size) {
                        Object objA = q.a(list.get(i));
                        int i6 = i + 1;
                        if (objA == null) {
                            sQLiteQuery.bindNull(i6);
                        } else if (objA instanceof byte[]) {
                            sQLiteQuery.bindBlob(i6, (byte[]) objA);
                        } else if (objA instanceof Double) {
                            sQLiteQuery.bindDouble(i6, ((Double) objA).doubleValue());
                        } else if (objA instanceof Integer) {
                            sQLiteQuery.bindLong(i6, ((Integer) objA).intValue());
                        } else if (objA instanceof Long) {
                            sQLiteQuery.bindLong(i6, ((Long) objA).longValue());
                        } else if (objA instanceof String) {
                            sQLiteQuery.bindString(i6, (String) objA);
                        } else {
                            if (!(objA instanceof Boolean)) {
                                throw new IllegalArgumentException("Could not bind " + objA + " from index " + i + ": Supported types are null, byte[], double, long, boolean and String");
                            }
                            sQLiteQuery.bindLong(i6, ((Boolean) objA).booleanValue() ? 1L : 0L);
                        }
                        i = i6;
                    }
                }
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            default:
                P.b0(sQLiteQuery, (Object[]) this.f396b);
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }
}
