package S1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Iterator;

/* JADX INFO: renamed from: S1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0233b extends A {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ IBinder f2854k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ServiceConnectionC0235d f2855l;

    public C0233b(ServiceConnectionC0235d serviceConnectionC0235d, IBinder iBinder) {
        this.f2855l = serviceConnectionC0235d;
        this.f2854k = iBinder;
    }

    @Override // S1.A
    public final void b() {
        C0236e c0236e = this.f2855l.f2858a;
        c0236e.f2871n = (IInterface) c0236e.i.a(this.f2854k);
        z zVar = c0236e.f2861b;
        zVar.b("linkToDeath", new Object[0]);
        try {
            c0236e.f2871n.asBinder().linkToDeath(c0236e.f2868k, 0);
        } catch (RemoteException e) {
            zVar.a(e, "linkToDeath failed", new Object[0]);
        }
        c0236e.f2865g = false;
        Iterator it = c0236e.f2863d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        c0236e.f2863d.clear();
    }
}
