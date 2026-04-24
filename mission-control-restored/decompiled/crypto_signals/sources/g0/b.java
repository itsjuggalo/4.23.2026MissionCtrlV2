package g0;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IntentFilter f6546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BroadcastReceiver f6547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6549d;

    public b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.f6546a = intentFilter;
        this.f6547b = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.f6547b);
        sb.append(" filter=");
        sb.append(this.f6546a);
        if (this.f6549d) {
            sb.append(" DEAD");
        }
        sb.append("}");
        return sb.toString();
    }
}
