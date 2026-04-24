package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class A2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C2 f3840d;

    public A2(C2 c22, int i4, boolean z4, boolean z5) {
        Objects.requireNonNull(c22);
        this.f3840d = c22;
        this.f3837a = i4;
        this.f3838b = z4;
        this.f3839c = z5;
    }

    public final void a(String str) {
        this.f3840d.y(this.f3837a, this.f3838b, this.f3839c, str, null, null, null);
    }

    public final void b(String str, Object obj) {
        this.f3840d.y(this.f3837a, this.f3838b, this.f3839c, str, obj, null, null);
    }

    public final void c(String str, Object obj, Object obj2) {
        this.f3840d.y(this.f3837a, this.f3838b, this.f3839c, str, obj, obj2, null);
    }

    public final void d(String str, Object obj, Object obj2, Object obj3) {
        this.f3840d.y(this.f3837a, this.f3838b, this.f3839c, str, obj, obj2, obj3);
    }
}
