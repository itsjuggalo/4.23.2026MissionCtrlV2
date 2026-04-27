package w6;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: w6.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2801n extends a0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a0 f25135f;

    public C2801n(a0 delegate) {
        kotlin.jvm.internal.r.f(delegate, "delegate");
        this.f25135f = delegate;
    }

    @Override // w6.a0
    public a0 a() {
        return this.f25135f.a();
    }

    @Override // w6.a0
    public a0 b() {
        return this.f25135f.b();
    }

    @Override // w6.a0
    public long c() {
        return this.f25135f.c();
    }

    @Override // w6.a0
    public a0 d(long j7) {
        return this.f25135f.d(j7);
    }

    @Override // w6.a0
    public boolean e() {
        return this.f25135f.e();
    }

    @Override // w6.a0
    public void f() throws InterruptedIOException {
        this.f25135f.f();
    }

    @Override // w6.a0
    public a0 g(long j7, TimeUnit unit) {
        kotlin.jvm.internal.r.f(unit, "unit");
        return this.f25135f.g(j7, unit);
    }

    @Override // w6.a0
    public long h() {
        return this.f25135f.h();
    }

    public final a0 j() {
        return this.f25135f;
    }

    public final C2801n k(a0 delegate) {
        kotlin.jvm.internal.r.f(delegate, "delegate");
        this.f25135f = delegate;
        return this;
    }
}
