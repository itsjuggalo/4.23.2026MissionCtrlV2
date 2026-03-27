package K3;

import android.app.Application;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class d implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f4737b;

    public d(c cVar, InterfaceC2426a interfaceC2426a) {
        this.f4736a = cVar;
        this.f4737b = interfaceC2426a;
    }

    public static d a(c cVar, InterfaceC2426a interfaceC2426a) {
        return new d(cVar, interfaceC2426a);
    }

    public static com.bumptech.glide.k c(c cVar, Application application) {
        return (com.bumptech.glide.k) G3.d.d(cVar.a(application));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.k get() {
        return c(this.f4736a, (Application) this.f4737b.get());
    }
}
