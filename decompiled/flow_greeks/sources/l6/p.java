package l6;

import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBinder f15506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f15507c;

    public p(r rVar, IBinder iBinder) {
        this.f15506b = iBinder;
        this.f15507c = rVar;
    }

    @Override // l6.j
    public final void a() {
        this.f15507c.f15509a.f15523m = e.I(this.f15506b);
        t.q(this.f15507c.f15509a);
        this.f15507c.f15509a.f15517g = false;
        Iterator it = this.f15507c.f15509a.f15514d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f15507c.f15509a.f15514d.clear();
    }
}
