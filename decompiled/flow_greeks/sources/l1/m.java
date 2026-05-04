package l1;

import android.os.Build;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static final boolean a(File file, File toFile) {
        kotlin.jvm.internal.t.f(file, "<this>");
        kotlin.jvm.internal.t.f(toFile, "toFile");
        return Build.VERSION.SDK_INT >= 26 ? a.f14986a.a(file, toFile) : file.renameTo(toFile);
    }
}
