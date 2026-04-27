package S1;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class E3 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f3919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ S3 f3920b;

    public E3(S3 s32, n7 n7Var) {
        this.f3919a = n7Var;
        Objects.requireNonNull(s32);
        this.f3920b = s32;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        S3 s32 = this.f3920b;
        s32.e0().D();
        return new C0646p(s32.e0().S0(this.f3919a.f4788a));
    }
}
