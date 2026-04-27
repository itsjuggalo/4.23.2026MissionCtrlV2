package X1;

import android.os.IBinder;
import android.os.IInterface;
import java.util.Iterator;

/* JADX INFO: renamed from: X1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0741b extends H {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ IBinder f5550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ServiceConnectionC0744e f5551h;

    public C0741b(ServiceConnectionC0744e serviceConnectionC0744e, IBinder iBinder) {
        this.f5551h = serviceConnectionC0744e;
        this.f5550g = iBinder;
    }

    @Override // X1.H
    public final void b() {
        this.f5551h.f5553a.f5568n = (IInterface) this.f5551h.f5553a.f5563i.a(this.f5550g);
        C0745f.r(this.f5551h.f5553a);
        this.f5551h.f5553a.f5561g = false;
        Iterator it = this.f5551h.f5553a.f5558d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f5551h.f5553a.f5558d.clear();
    }
}
