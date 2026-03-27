package P3;

import android.app.Application;

/* JADX INFO: renamed from: P3.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0780p implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0778n f6419a;

    public C0780p(C0778n c0778n) {
        this.f6419a = c0778n;
    }

    public static C0780p a(C0778n c0778n) {
        return new C0780p(c0778n);
    }

    public static Application c(C0778n c0778n) {
        return (Application) E3.d.e(c0778n.b());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Application get() {
        return c(this.f6419a);
    }
}
