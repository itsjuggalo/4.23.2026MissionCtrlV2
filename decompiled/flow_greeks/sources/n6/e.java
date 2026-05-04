package n6;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f16646a;

    public /* synthetic */ e(f fVar, d dVar) {
        this.f16646a = fVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f16646a.f16649b.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f16646a.c().post(new b(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f16646a.f16649b.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f16646a.c().post(new c(this));
    }
}
