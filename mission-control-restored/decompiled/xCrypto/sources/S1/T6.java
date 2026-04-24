package S1;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class T6 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f4249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b7 f4250b;

    public T6(b7 b7Var, n7 n7Var) {
        this.f4249a = n7Var;
        Objects.requireNonNull(b7Var);
        this.f4250b = b7Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        n7 n7Var = this.f4249a;
        String str = (String) AbstractC0940s.k(n7Var.f4788a);
        b7 b7Var = this.f4250b;
        C0531a4 c0531a4G = b7Var.g(str);
        Z3 z32 = Z3.ANALYTICS_STORAGE;
        if (c0531a4G.o(z32) && C0531a4.f(n7Var.f4806s, 100).o(z32)) {
            return b7Var.n0(n7Var).p0();
        }
        b7Var.a().w().a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
