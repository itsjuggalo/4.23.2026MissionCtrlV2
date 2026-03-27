package S1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.internal.measurement.zzby;
import java.util.Objects;

/* JADX INFO: renamed from: S1.r2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0664r2 extends zzby {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0680t2 f4897a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0664r2(C0680t2 c0680t2, Context context, String str) {
        super(context, "google_app_measurement_local.db", null, 1);
        Objects.requireNonNull(c0680t2);
        this.f4897a = c0680t2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e4) {
            throw e4;
        } catch (SQLiteException unused) {
            C0658q3 c0658q3 = this.f4897a.f4245a;
            c0658q3.a().o().a("Opening the local database failed, dropping and recreating it");
            c0658q3.w();
            if (!c0658q3.e().getDatabasePath("google_app_measurement_local.db").delete()) {
                c0658q3.a().o().b("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e5) {
                this.f4897a.f4245a.a().o().b("Failed to open local database. Events will bypass local storage", e5);
                return null;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        AbstractC0717y.b(this.f4897a.f4245a.a(), sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) throws Throwable {
        AbstractC0717y.a(this.f4897a.f4245a.a(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", C0680t2.f4939e);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
    }
}
