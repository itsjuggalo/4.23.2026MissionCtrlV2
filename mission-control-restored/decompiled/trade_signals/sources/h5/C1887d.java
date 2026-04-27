package h5;

import P4.i;
import i5.EnumC1933g;
import j5.C2226c;
import j5.h;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: h5.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1887d extends AtomicInteger implements i, x7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x7.b f18704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2226c f18705b = new C2226c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f18706c = new AtomicLong();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f18707d = new AtomicReference();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f18708e = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f18709f;

    public C1887d(x7.b bVar) {
        this.f18704a = bVar;
    }

    @Override // x7.b
    public void a() {
        this.f18709f = true;
        h.a(this.f18704a, this, this.f18705b);
    }

    @Override // x7.b
    public void c(Object obj) {
        h.c(this.f18704a, obj, this, this.f18705b);
    }

    @Override // x7.c
    public void cancel() {
        if (this.f18709f) {
            return;
        }
        EnumC1933g.a(this.f18707d);
    }

    @Override // P4.i, x7.b
    public void d(x7.c cVar) {
        if (this.f18708e.compareAndSet(false, true)) {
            this.f18704a.d(this);
            EnumC1933g.g(this.f18707d, this.f18706c, cVar);
        } else {
            cVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // x7.c
    public void i(long j8) {
        if (j8 > 0) {
            EnumC1933g.b(this.f18707d, this.f18706c, j8);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j8));
    }

    @Override // x7.b
    public void onError(Throwable th) {
        this.f18709f = true;
        h.b(this.f18704a, th, this, this.f18705b);
    }
}
