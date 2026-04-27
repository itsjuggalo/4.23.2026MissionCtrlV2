package S1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;

/* JADX INFO: renamed from: S1.t2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0680t2 extends AbstractC0593i2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f4939e = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0664r2 f4940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4941d;

    public C0680t2(C0658q3 c0658q3) {
        super(c0658q3);
        Context contextE = this.f4245a.e();
        this.f4245a.w();
        this.f4940c = new C0664r2(this, contextE, "google_app_measurement_local.db");
    }

    @Override // S1.AbstractC0593i2
    public final boolean m() {
        return false;
    }

    public final void o() {
        int iDelete;
        h();
        try {
            SQLiteDatabase sQLiteDatabaseW = w();
            if (sQLiteDatabaseW == null || (iDelete = sQLiteDatabaseW.delete("messages", null, null)) <= 0) {
                return;
            }
            this.f4245a.a().w().b("Reset local analytics data. records", Integer.valueOf(iDelete));
        } catch (SQLiteException e4) {
            this.f4245a.a().o().b("Error resetting local analytics data. error", e4);
        }
    }

    public final boolean p(J j4) {
        Parcel parcelObtain = Parcel.obtain();
        K.a(j4, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return z(0, bArrMarshall);
        }
        this.f4245a.a().p().a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean q(h7 h7Var) {
        Parcel parcelObtain = Parcel.obtain();
        i7.a(h7Var, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return z(1, bArrMarshall);
        }
        this.f4245a.a().p().a("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean r(C0590i c0590i) {
        C0658q3 c0658q3 = this.f4245a;
        byte[] bArrT = c0658q3.C().T(c0590i);
        if (bArrT.length <= 131072) {
            return z(2, bArrT);
        }
        c0658q3.a().p().a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean s(H h4) {
        C0658q3 c0658q3 = this.f4245a;
        byte[] bArrT = c0658q3.C().T(h4);
        if (bArrT == null) {
            c0658q3.a().p().a("Null default event parameters; not writing to database");
            return false;
        }
        if (bArrT.length <= 131072) {
            return z(4, bArrT);
        }
        c0658q3.a().p().a("Default event parameters too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:188:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0369 A[PHI: r6 r11 r13 r17 r19 r21
      0x0369: PHI (r6v14 int) = (r6v7 int), (r6v10 int), (r6v15 int) binds: [B:189:0x0350, B:204:0x038c, B:197:0x0367] A[DONT_GENERATE, DONT_INLINE]
      0x0369: PHI (r11v3 int) = (r11v1 int), (r11v1 int), (r11v4 int) binds: [B:189:0x0350, B:204:0x038c, B:197:0x0367] A[DONT_GENERATE, DONT_INLINE]
      0x0369: PHI (r13v9 ??) = (r13v5 ??), (r13v7 ??), (r13v10 ??) binds: [B:189:0x0350, B:204:0x038c, B:197:0x0367] A[DONT_GENERATE, DONT_INLINE]
      0x0369: PHI (r17v8 java.lang.String) = (r17v3 java.lang.String), (r17v5 java.lang.String), (r17v9 java.lang.String) binds: [B:189:0x0350, B:204:0x038c, B:197:0x0367] A[DONT_GENERATE, DONT_INLINE]
      0x0369: PHI (r19v8 java.lang.String) = (r19v3 java.lang.String), (r19v5 java.lang.String), (r19v9 java.lang.String) binds: [B:189:0x0350, B:204:0x038c, B:197:0x0367] A[DONT_GENERATE, DONT_INLINE]
      0x0369: PHI (r21v8 java.lang.String) = (r21v3 java.lang.String), (r21v5 java.lang.String), (r21v9 java.lang.String) binds: [B:189:0x0350, B:204:0x038c, B:197:0x0367] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0332 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x038f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x038f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x038f A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12, types: [android.database.sqlite.SQLiteClosable, android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARN: Type inference failed for: r13v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARN: Type inference failed for: r15v5, types: [S1.m] */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r17v15 */
    /* JADX WARN: Type inference failed for: r17v16, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r17v43 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List t(int r30) {
        /*
            Method dump skipped, instruction units count: 954
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0680t2.t(int):java.util.List");
    }

    public final boolean u() {
        return z(3, new byte[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006b A[PHI: r4
      0x006b: PHI (r4v4 int) = (r4v1 int), (r4v2 int), (r4v1 int) binds: [B:34:0x007e, B:31:0x0069, B:28:0x0062] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean v() {
        /*
            r10 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r10.h()
            boolean r1 = r10.f4941d
            r2 = 0
            if (r1 == 0) goto Lc
            goto L99
        Lc:
            boolean r1 = r10.x()
            if (r1 == 0) goto L99
            r1 = 5
            r4 = r1
            r3 = r2
        L15:
            if (r3 >= r1) goto L8a
            r5 = 0
            r6 = 1
            android.database.sqlite.SQLiteDatabase r5 = r10.w()     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteException -> L25 android.database.sqlite.SQLiteFullException -> L27 android.database.sqlite.SQLiteDatabaseLockedException -> L63
            if (r5 != 0) goto L29
            r10.f4941d = r6     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteException -> L25 android.database.sqlite.SQLiteFullException -> L27 android.database.sqlite.SQLiteDatabaseLockedException -> L63
            goto L99
        L23:
            r0 = move-exception
            goto L84
        L25:
            r7 = move-exception
            goto L46
        L27:
            r7 = move-exception
            goto L6f
        L29:
            r5.beginTransaction()     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteException -> L25 android.database.sqlite.SQLiteFullException -> L27 android.database.sqlite.SQLiteDatabaseLockedException -> L63
            java.lang.String r7 = "messages"
            java.lang.String r8 = "type == ?"
            r9 = 3
            java.lang.String r9 = java.lang.Integer.toString(r9)     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteException -> L25 android.database.sqlite.SQLiteFullException -> L27 android.database.sqlite.SQLiteDatabaseLockedException -> L63
            java.lang.String[] r9 = new java.lang.String[]{r9}     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteException -> L25 android.database.sqlite.SQLiteFullException -> L27 android.database.sqlite.SQLiteDatabaseLockedException -> L63
            r5.delete(r7, r8, r9)     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteException -> L25 android.database.sqlite.SQLiteFullException -> L27 android.database.sqlite.SQLiteDatabaseLockedException -> L63
            r5.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteException -> L25 android.database.sqlite.SQLiteFullException -> L27 android.database.sqlite.SQLiteDatabaseLockedException -> L63
            r5.endTransaction()     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteException -> L25 android.database.sqlite.SQLiteFullException -> L27 android.database.sqlite.SQLiteDatabaseLockedException -> L63
            r5.close()
            return r6
        L46:
            if (r5 == 0) goto L51
            boolean r8 = r5.inTransaction()     // Catch: java.lang.Throwable -> L23
            if (r8 == 0) goto L51
            r5.endTransaction()     // Catch: java.lang.Throwable -> L23
        L51:
            S1.q3 r8 = r10.f4245a     // Catch: java.lang.Throwable -> L23
            S1.C2 r8 = r8.a()     // Catch: java.lang.Throwable -> L23
            S1.A2 r8 = r8.o()     // Catch: java.lang.Throwable -> L23
            r8.b(r0, r7)     // Catch: java.lang.Throwable -> L23
            r10.f4941d = r6     // Catch: java.lang.Throwable -> L23
            if (r5 == 0) goto L81
            goto L6b
        L63:
            long r6 = (long) r4     // Catch: java.lang.Throwable -> L23
            android.os.SystemClock.sleep(r6)     // Catch: java.lang.Throwable -> L23
            int r4 = r4 + 20
            if (r5 == 0) goto L81
        L6b:
            r5.close()
            goto L81
        L6f:
            S1.q3 r8 = r10.f4245a     // Catch: java.lang.Throwable -> L23
            S1.C2 r8 = r8.a()     // Catch: java.lang.Throwable -> L23
            S1.A2 r8 = r8.o()     // Catch: java.lang.Throwable -> L23
            r8.b(r0, r7)     // Catch: java.lang.Throwable -> L23
            r10.f4941d = r6     // Catch: java.lang.Throwable -> L23
            if (r5 == 0) goto L81
            goto L6b
        L81:
            int r3 = r3 + 1
            goto L15
        L84:
            if (r5 == 0) goto L89
            r5.close()
        L89:
            throw r0
        L8a:
            S1.q3 r0 = r10.f4245a
            S1.C2 r0 = r0.a()
            S1.A2 r0 = r0.r()
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.a(r1)
        L99:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0680t2.v():boolean");
    }

    public final SQLiteDatabase w() {
        if (this.f4941d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f4940c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f4941d = true;
        return null;
    }

    public final boolean x() {
        C0658q3 c0658q3 = this.f4245a;
        Context contextE = c0658q3.e();
        c0658q3.w();
        return contextE.getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0186 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0186 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0186 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b6 A[Catch: all -> 0x0098, SQLiteException -> 0x009b, SQLiteDatabaseLockedException -> 0x00a2, SQLiteFullException -> 0x00a6, TRY_ENTER, TryCatch #11 {all -> 0x0098, blocks: (B:30:0x008d, B:32:0x0093, B:45:0x00b6, B:47:0x00da, B:49:0x00e4, B:51:0x00ec, B:61:0x0106, B:75:0x012e, B:77:0x0134, B:78:0x0137, B:93:0x016c, B:85:0x0157), top: B:109:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012e A[Catch: all -> 0x0098, TRY_ENTER, TryCatch #11 {all -> 0x0098, blocks: (B:30:0x008d, B:32:0x0093, B:45:0x00b6, B:47:0x00da, B:49:0x00e4, B:51:0x00ec, B:61:0x0106, B:75:0x012e, B:77:0x0134, B:78:0x0137, B:93:0x016c, B:85:0x0157), top: B:109:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0163 A[PHI: r8 r10 r17
      0x0163: PHI (r8v5 int) = (r8v3 int), (r8v3 int), (r8v6 int) binds: [B:81:0x014f, B:96:0x0183, B:89:0x0161] A[DONT_GENERATE, DONT_INLINE]
      0x0163: PHI (r10v7 android.database.sqlite.SQLiteDatabase) = 
      (r10v5 android.database.sqlite.SQLiteDatabase)
      (r10v6 android.database.sqlite.SQLiteDatabase)
      (r10v8 android.database.sqlite.SQLiteDatabase)
     binds: [B:81:0x014f, B:96:0x0183, B:89:0x0161] A[DONT_GENERATE, DONT_INLINE]
      0x0163: PHI (r17v7 boolean) = (r17v4 boolean), (r17v5 boolean), (r17v8 boolean) binds: [B:81:0x014f, B:96:0x0183, B:89:0x0161] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0180  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean z(int r19, byte[] r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0680t2.z(int, byte[]):boolean");
    }
}
