package n2;

import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: renamed from: n2.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2419z extends AbstractRunnableC2413t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBinder f21603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ServiceConnectionC2390C f21604c;

    public C2419z(ServiceConnectionC2390C serviceConnectionC2390C, IBinder iBinder) {
        this.f21604c = serviceConnectionC2390C;
        this.f21603b = iBinder;
    }

    @Override // n2.AbstractRunnableC2413t
    public final void a() {
        this.f21604c.f21560a.f21574m = AbstractBinderC2404k.E(this.f21603b);
        C2391D.q(this.f21604c.f21560a);
        this.f21604c.f21560a.f21568g = false;
        Iterator it = this.f21604c.f21560a.f21565d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f21604c.f21560a.f21565d.clear();
    }
}
