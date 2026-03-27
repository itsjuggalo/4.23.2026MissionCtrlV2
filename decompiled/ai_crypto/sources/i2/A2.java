package i2;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class A2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C2 f14999d;

    public A2(C2 c22, int i7, boolean z7, boolean z8) {
        Objects.requireNonNull(c22);
        this.f14999d = c22;
        this.f14996a = i7;
        this.f14997b = z7;
        this.f14998c = z8;
    }

    public final void a(String str) {
        this.f14999d.y(this.f14996a, this.f14997b, this.f14998c, str, null, null, null);
    }

    public final void b(String str, Object obj) {
        this.f14999d.y(this.f14996a, this.f14997b, this.f14998c, str, obj, null, null);
    }

    public final void c(String str, Object obj, Object obj2) {
        this.f14999d.y(this.f14996a, this.f14997b, this.f14998c, str, obj, obj2, null);
    }

    public final void d(String str, Object obj, Object obj2, Object obj3) {
        this.f14999d.y(this.f14996a, this.f14997b, this.f14998c, str, obj, obj2, obj3);
    }
}
