package e1;

import java.io.ByteArrayInputStream;
import java.io.File;
import k0.C2063a;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: e1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1469a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1469a f13559a = new C1469a();

    public final int a(byte[] bArr) {
        return new C2063a(new ByteArrayInputStream(bArr)).n();
    }

    public final int b(File file) {
        r.f(file, "file");
        try {
            return new C2063a(file.getAbsolutePath()).n();
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
