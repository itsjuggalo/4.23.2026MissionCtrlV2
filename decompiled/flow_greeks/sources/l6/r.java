package l6;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f15509a;

    public /* synthetic */ r(t tVar, s sVar) {
        this.f15509a = tVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f15509a.f15512b.c("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f15509a.c().post(new p(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f15509a.f15512b.c("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f15509a.c().post(new q(this));
    }
}
