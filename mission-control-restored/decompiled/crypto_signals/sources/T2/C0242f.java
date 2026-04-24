package T2;

import android.net.ConnectivityManager;
import android.net.Network;
import v4.C1260a;

/* JADX INFO: renamed from: T2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0242f extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2958b;

    public /* synthetic */ C0242f(Object obj, int i) {
        this.f2957a = i;
        this.f2958b = obj;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        switch (this.f2957a) {
            case 0:
                ((e3.w) this.f2958b).F(true);
                break;
            default:
                ((C1260a) this.f2958b).f10649d.v();
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onBlockedStatusChanged(Network network, boolean z6) {
        switch (this.f2957a) {
            case 1:
                if (!z6) {
                    ((C1260a) this.f2958b).f10649d.v();
                }
                break;
            default:
                super.onBlockedStatusChanged(network, z6);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        switch (this.f2957a) {
            case 0:
                ((e3.w) this.f2958b).F(false);
                break;
            default:
                super.onLost(network);
                break;
        }
    }
}
