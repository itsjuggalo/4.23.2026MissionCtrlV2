package androidx.profileinstaller;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: androidx.profileinstaller.a$a, reason: collision with other inner class name */
    public static class C0112a {
        public static File a(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    public static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z4 = true;
        for (File file2 : fileArrListFiles) {
            z4 = a(file2) && z4;
        }
        return z4;
    }

    public static void b(Context context, ProfileInstallReceiver.a aVar) {
        if (a(C0112a.a(context))) {
            aVar.b(14, null);
        } else {
            aVar.b(15, null);
        }
    }
}
