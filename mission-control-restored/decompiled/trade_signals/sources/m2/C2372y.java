package m2;

import android.content.Context;
import java.io.File;

/* JADX INFO: renamed from: m2.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2372y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21396a;

    public C2372y(Context context) {
        this.f21396a = context;
    }

    public static long b(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        long jB = 0;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                jB += b(file2);
            }
        }
        return jB;
    }

    public final long a() {
        return b(new File(this.f21396a.getFilesDir(), "assetpacks"));
    }
}
