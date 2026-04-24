package G4;

import F4.AbstractC0493g;
import F4.C0489c;
import v2.AbstractC2842h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class M extends F4.T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F4.T f2531a;

    public M(F4.T t8) {
        this.f2531a = t8;
    }

    @Override // F4.AbstractC0490d
    public String a() {
        return this.f2531a.a();
    }

    @Override // F4.AbstractC0490d
    public AbstractC0493g g(F4.Y y7, C0489c c0489c) {
        return this.f2531a.g(y7, c0489c);
    }

    public String toString() {
        return AbstractC2842h.b(this).d("delegate", this.f2531a).toString();
    }
}
