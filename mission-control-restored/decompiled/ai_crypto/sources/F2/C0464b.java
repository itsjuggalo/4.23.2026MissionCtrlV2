package F2;

import android.os.IBinder;
import android.os.IInterface;
import java.util.Iterator;

/* JADX INFO: renamed from: F2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0464b extends H {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ IBinder f1907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ServiceConnectionC0467e f1908h;

    public C0464b(ServiceConnectionC0467e serviceConnectionC0467e, IBinder iBinder) {
        this.f1908h = serviceConnectionC0467e;
        this.f1907g = iBinder;
    }

    @Override // F2.H
    public final void b() {
        this.f1908h.f1910a.f1925n = (IInterface) this.f1908h.f1910a.f1920i.a(this.f1907g);
        C0468f.r(this.f1908h.f1910a);
        this.f1908h.f1910a.f1918g = false;
        Iterator it = this.f1908h.f1910a.f1915d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f1908h.f1910a.f1915d.clear();
    }
}
