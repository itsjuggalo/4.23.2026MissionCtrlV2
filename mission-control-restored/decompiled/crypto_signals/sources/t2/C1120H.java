package t2;

import java.util.Arrays;

/* JADX INFO: renamed from: t2.H, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1120H extends s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f9958b;

    public C1120H(String str, byte[] bArr) {
        this.f9957a = str;
        this.f9958b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s0) {
            s0 s0Var = (s0) obj;
            if (this.f9957a.equals(((C1120H) s0Var).f9957a)) {
                if (Arrays.equals(this.f9958b, (s0Var instanceof C1120H ? (C1120H) s0Var : (C1120H) s0Var).f9958b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f9957a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f9958b);
    }

    public final String toString() {
        return "File{filename=" + this.f9957a + ", contents=" + Arrays.toString(this.f9958b) + "}";
    }
}
