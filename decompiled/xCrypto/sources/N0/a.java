package N0;

import java.io.ByteArrayInputStream;
import java.io.File;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2708a = new a();

    public final int a(byte[] bArr) {
        return new W.a(new ByteArrayInputStream(bArr)).n();
    }

    public final int b(File file) {
        r.f(file, "file");
        try {
            return new W.a(file.getAbsolutePath()).n();
        } catch (Exception unused) {
            return 0;
        }
    }

    public final int c(byte[] _bytes) {
        r.f(_bytes, "_bytes");
        try {
            return a(_bytes);
        } catch (Exception unused) {
            return 0;
        }
    }
}
