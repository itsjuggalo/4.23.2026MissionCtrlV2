package i2;

import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class A6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W1.d f15012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15013b;

    public A6(W1.d dVar) {
        AbstractC1207s.k(dVar);
        this.f15012a = dVar;
    }

    public final void a() {
        this.f15013b = this.f15012a.b();
    }

    public final void b() {
        this.f15013b = 0L;
    }

    public final boolean c(long j7) {
        return this.f15013b == 0 || this.f15012a.b() - this.f15013b >= 3600000;
    }
}
