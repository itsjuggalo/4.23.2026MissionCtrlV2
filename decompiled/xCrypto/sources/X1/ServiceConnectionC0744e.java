package X1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: renamed from: X1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC0744e implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0745f f5553a;

    public /* synthetic */ ServiceConnectionC0744e(C0745f c0745f, AbstractC0743d abstractC0743d) {
        this.f5553a = c0745f;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f5553a.f5556b.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f5553a.c().post(new C0741b(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f5553a.f5556b.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f5553a.c().post(new C0742c(this));
    }
}
