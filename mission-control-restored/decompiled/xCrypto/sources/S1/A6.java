package S1;

import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class A6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G1.d f3853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3854b;

    public A6(G1.d dVar) {
        AbstractC0940s.k(dVar);
        this.f3853a = dVar;
    }

    public final void a() {
        this.f3854b = this.f3853a.a();
    }

    public final void b() {
        this.f3854b = 0L;
    }

    public final boolean c(long j4) {
        return this.f3854b == 0 || this.f3853a.a() - this.f3854b >= 3600000;
    }
}
