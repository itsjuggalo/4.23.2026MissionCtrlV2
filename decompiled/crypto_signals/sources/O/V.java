package O;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class V extends kotlin.jvm.internal.k implements R4.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final V f2162a = new V(1);

    @Override // R4.l
    public final Object invoke(Object obj) {
        File it = (File) obj;
        kotlin.jvm.internal.j.e(it, "it");
        String absolutePath = it.getCanonicalFile().getAbsolutePath();
        kotlin.jvm.internal.j.d(absolutePath, "file.canonicalFile.absolutePath");
        return new A0(absolutePath);
    }
}
