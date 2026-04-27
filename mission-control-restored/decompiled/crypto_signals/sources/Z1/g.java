package Z1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import q.C0918j;

/* JADX INFO: loaded from: classes.dex */
public final class g extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference f3958b = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3959a;

    public g(Context context) {
        this.f3959a = context;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        synchronized (h.f3960k) {
            try {
                Iterator it = ((C0918j) h.f3961l.values()).iterator();
                while (it.hasNext()) {
                    ((h) it.next()).h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f3959a.unregisterReceiver(this);
    }
}
