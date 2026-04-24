package com.google.android.recaptcha.internal;

import X2.AbstractC0768o;
import X2.AbstractC0769p;
import X2.x;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class zzei extends SQLiteOpenHelper {
    public static final zzeg zza = new zzeg(null);
    private static final int zzb = zzeg.zzc("18.6.1");
    private static final String zzc = zzeg.zzd("18.6.1");
    private static zzei zzd;

    public /* synthetic */ zzei(Context context, AbstractC1585j abstractC1585j) {
        super(context, zzc, (SQLiteDatabase.CursorFactory) null, zzb);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ce");
        sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ce");
        sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
    }

    public final int zza(List list) {
        if (list.isEmpty()) {
            return 0;
        }
        return getWritableDatabase().delete("ce", "id IN ".concat(String.valueOf(x.Q(list, ", ", "(", ")", 0, null, zzeh.zza, 24, null))), null);
    }

    public final int zzb() {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT COUNT(*) FROM ce", null);
        int i4 = -1;
        try {
            if (cursorRawQuery.moveToNext()) {
                i4 = cursorRawQuery.getInt(0);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
        cursorRawQuery.close();
        return i4;
    }

    public final List zzd() {
        Cursor cursorQuery = getReadableDatabase().query("ce", null, null, null, null, null, "ts ASC");
        List arrayList = new ArrayList();
        while (cursorQuery.moveToNext()) {
            try {
                try {
                    int i4 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow(DiagnosticsEntry.ID_KEY));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("ss"));
                    long j4 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("ts"));
                    r.c(string);
                    arrayList.add(new zzej(string, j4, i4));
                } catch (Exception unused) {
                    arrayList = AbstractC0769p.g();
                }
            } finally {
                cursorQuery.close();
            }
        }
        return arrayList;
    }

    public final boolean zzf(zzej zzejVar) {
        return zza(AbstractC0768o.b(zzejVar)) == 1;
    }
}
