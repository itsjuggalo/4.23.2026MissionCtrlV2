package S1;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class R6 implements E2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e7 f4226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b7 f4227c;

    public R6(b7 b7Var, String str, e7 e7Var) {
        this.f4225a = str;
        this.f4226b = e7Var;
        Objects.requireNonNull(b7Var);
        this.f4227c = b7Var;
    }

    @Override // S1.E2
    public final void a(String str, int i4, Throwable th, byte[] bArr, Map map) {
        this.f4227c.v(this.f4225a, i4, th, bArr, this.f4226b);
    }
}
