package T2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import v4.C1260a;

/* JADX INFO: renamed from: T2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0243g extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2960b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2961c;

    public /* synthetic */ C0243g(Object obj, int i) {
        this.f2959a = i;
        this.f2961c = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.f2959a) {
            case 0:
                e3.w wVar = (e3.w) this.f2961c;
                boolean zX = wVar.x();
                if (wVar.x() && !this.f2960b) {
                    wVar.F(true);
                } else if (!zX && this.f2960b) {
                    wVar.F(false);
                }
                this.f2960b = zX;
                break;
            default:
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                boolean z6 = this.f2960b;
                boolean z7 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
                this.f2960b = z7;
                if (z7 && !z6) {
                    ((C1260a) this.f2961c).f10649d.v();
                    break;
                }
                break;
        }
    }
}
