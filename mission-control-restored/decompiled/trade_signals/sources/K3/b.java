package K3;

import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public final class b implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f4735a;

    public b(a aVar) {
        this.f4735a = aVar;
    }

    public static b a(a aVar) {
        return new b(aVar);
    }

    public static Application c(a aVar) {
        return (Application) G3.d.d(aVar.a());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Application get() {
        return c(this.f4735a);
    }
}
