package l1;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    public static final t a(File file) {
        kotlin.jvm.internal.t.f(file, "file");
        String absolutePath = file.getCanonicalFile().getAbsolutePath();
        kotlin.jvm.internal.t.e(absolutePath, "file.canonicalFile.absolutePath");
        return u.a(absolutePath);
    }
}
