package t2;

import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class p extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBinder f23303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f23304c;

    public p(r rVar, IBinder iBinder) {
        this.f23303b = iBinder;
        this.f23304c = rVar;
    }

    @Override // t2.j
    public final void a() {
        this.f23304c.f23306a.f23320m = AbstractBinderC2738e.E(this.f23303b);
        t.q(this.f23304c.f23306a);
        this.f23304c.f23306a.f23314g = false;
        Iterator it = this.f23304c.f23306a.f23311d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f23304c.f23306a.f23311d.clear();
    }
}
