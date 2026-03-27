package F2;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: renamed from: F2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC0467e implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0468f f1910a;

    public /* synthetic */ ServiceConnectionC0467e(C0468f c0468f, AbstractC0466d abstractC0466d) {
        this.f1910a = c0468f;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f1910a.f1913b.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f1910a.c().post(new C0464b(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f1910a.f1913b.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f1910a.c().post(new C0465c(this));
    }
}
