package i2;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzca;
import java.io.File;

/* JADX INFO: renamed from: i2.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1958y {
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(i2.C2 r9, android.database.sqlite.SQLiteDatabase r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String[] r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.AbstractC1958y.a(i2.C2, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public static void b(C2 c22, SQLiteDatabase sQLiteDatabase) {
        if (c22 == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        zzbv.zza();
        String path = sQLiteDatabase.getPath();
        int i7 = zzca.zzb;
        File file = new File(path);
        if (!file.setReadable(false, false)) {
            c22.r().a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            c22.r().a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            c22.r().a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        c22.r().a("Failed to turn on database write permission for owner");
    }
}
