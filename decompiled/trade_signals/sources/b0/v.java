package b0;

import java.io.File;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    public static final t a(File file) {
        AbstractC2304t.f(file, "file");
        String absolutePath = file.getCanonicalFile().getAbsolutePath();
        AbstractC2304t.e(absolutePath, "file.canonicalFile.absolutePath");
        return u.a(absolutePath);
    }
}
