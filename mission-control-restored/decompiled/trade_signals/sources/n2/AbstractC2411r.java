package n2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import r2.InterfaceC2673a;

/* JADX INFO: renamed from: n2.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2411r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2412s f21588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IntentFilter f21589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f21590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f21591d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C2410q f21592e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f21593f = false;

    public AbstractC2411r(C2412s c2412s, IntentFilter intentFilter, Context context) {
        this.f21588a = c2412s;
        this.f21589b = intentFilter;
        this.f21590c = AbstractC2393F.a(context);
    }

    public abstract void a(Context context, Intent intent);

    public final synchronized void b(InterfaceC2673a interfaceC2673a) {
        this.f21588a.d("registerListener", new Object[0]);
        AbstractC2397d.a(interfaceC2673a, "Registered Play Core listener should not be null.");
        this.f21591d.add(interfaceC2673a);
        e();
    }

    public final synchronized void c(InterfaceC2673a interfaceC2673a) {
        this.f21588a.d("unregisterListener", new Object[0]);
        AbstractC2397d.a(interfaceC2673a, "Unregistered Play Core listener should not be null.");
        this.f21591d.remove(interfaceC2673a);
        e();
    }

    public final synchronized void d(Object obj) {
        Iterator it = new HashSet(this.f21591d).iterator();
        while (it.hasNext()) {
            ((InterfaceC2673a) it.next()).a(obj);
        }
    }

    public final void e() {
        C2410q c2410q;
        if (!this.f21591d.isEmpty() && this.f21592e == null) {
            C2410q c2410q2 = new C2410q(this, null);
            this.f21592e = c2410q2;
            if (Build.VERSION.SDK_INT >= 33) {
                this.f21590c.registerReceiver(c2410q2, this.f21589b, 2);
            } else {
                this.f21590c.registerReceiver(c2410q2, this.f21589b);
            }
        }
        if (!this.f21591d.isEmpty() || (c2410q = this.f21592e) == null) {
            return;
        }
        this.f21590c.unregisterReceiver(c2410q);
        this.f21592e = null;
    }
}
