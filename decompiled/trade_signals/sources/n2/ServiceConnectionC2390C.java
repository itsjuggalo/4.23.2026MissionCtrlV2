package n2;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: renamed from: n2.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC2390C implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2391D f21560a;

    public /* synthetic */ ServiceConnectionC2390C(C2391D c2391d, AbstractC2389B abstractC2389B) {
        this.f21560a = c2391d;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f21560a.f21563b.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        C2391D c2391d = this.f21560a;
        c2391d.c().post(new C2419z(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f21560a.f21563b.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        C2391D c2391d = this.f21560a;
        c2391d.c().post(new C2388A(this));
    }
}
