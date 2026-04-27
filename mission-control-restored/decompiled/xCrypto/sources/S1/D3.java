package S1;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class D3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f3904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ S3 f3905b;

    public D3(S3 s32, n7 n7Var) {
        this.f3904a = n7Var;
        Objects.requireNonNull(s32);
        this.f3905b = s32;
    }

    @Override // java.lang.Runnable
    public final void run() {
        S3 s32 = this.f3905b;
        s32.e0().D();
        b7 b7VarE0 = s32.e0();
        b7VarE0.b().h();
        b7VarE0.O0();
        n7 n7Var = this.f3904a;
        AbstractC0940s.e(n7Var.f4788a);
        b7VarE0.P0(n7Var);
        b7VarE0.Q0(n7Var);
    }
}
