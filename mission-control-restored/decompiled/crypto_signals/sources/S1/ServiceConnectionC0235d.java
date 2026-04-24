package S1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: renamed from: S1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC0235d implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0236e f2858a;

    public /* synthetic */ ServiceConnectionC0235d(C0236e c0236e) {
        this.f2858a = c0236e;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C0236e c0236e = this.f2858a;
        c0236e.f2861b.b("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        c0236e.a().post(new C0233b(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        C0236e c0236e = this.f2858a;
        c0236e.f2861b.b("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        c0236e.a().post(new C0234c(this, 0));
    }
}
