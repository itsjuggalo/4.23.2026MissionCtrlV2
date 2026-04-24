package S;

import android.os.Build;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static final boolean a(File file, File toFile) {
        kotlin.jvm.internal.r.f(file, "<this>");
        kotlin.jvm.internal.r.f(toFile, "toFile");
        return Build.VERSION.SDK_INT >= 26 ? C0515a.f3605a.a(file, toFile) : file.renameTo(toFile);
    }
}
