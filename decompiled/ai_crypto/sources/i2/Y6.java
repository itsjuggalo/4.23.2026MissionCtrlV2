package i2;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Y6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15469b;

    public /* synthetic */ Y6(b7 b7Var, String str, byte[] bArr) {
        this(b7Var, str);
    }

    public Y6(b7 b7Var, String str) {
        Objects.requireNonNull(b7Var);
        this.f15468a = str;
        this.f15469b = b7Var.f().b();
    }

    public /* synthetic */ Y6(b7 b7Var, byte[] bArr) {
        this(b7Var, b7Var.N0().l0());
    }
}
