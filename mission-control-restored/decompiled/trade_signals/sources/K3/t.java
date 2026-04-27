package K3;

import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes.dex */
public final class t implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f4767a;

    public t(q qVar) {
        this.f4767a = qVar;
    }

    public static t a(q qVar) {
        return new t(qVar);
    }

    public static LayoutInflater c(q qVar) {
        return (LayoutInflater) G3.d.d(qVar.c());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutInflater get() {
        return c(this.f4767a);
    }
}
