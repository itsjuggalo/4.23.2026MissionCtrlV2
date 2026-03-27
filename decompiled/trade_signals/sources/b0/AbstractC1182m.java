package b0;

import android.os.Build;
import java.io.File;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: b0.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1182m {
    public static final boolean a(File file, File toFile) {
        AbstractC2304t.f(file, "<this>");
        AbstractC2304t.f(toFile, "toFile");
        return Build.VERSION.SDK_INT >= 26 ? C1170a.f12595a.a(file, toFile) : file.renameTo(toFile);
    }
}
