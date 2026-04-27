package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Y6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4310b;

    public /* synthetic */ Y6(b7 b7Var, String str, byte[] bArr) {
        this(b7Var, str);
    }

    public Y6(b7 b7Var, String str) {
        Objects.requireNonNull(b7Var);
        this.f4309a = str;
        this.f4310b = b7Var.f().a();
    }

    public /* synthetic */ Y6(b7 b7Var, byte[] bArr) {
        this(b7Var, b7Var.N0().l0());
    }
}
