package S;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    public static final t a(File file) {
        kotlin.jvm.internal.r.f(file, "file");
        String absolutePath = file.getCanonicalFile().getAbsolutePath();
        kotlin.jvm.internal.r.e(absolutePath, "file.canonicalFile.absolutePath");
        return u.a(absolutePath);
    }
}
