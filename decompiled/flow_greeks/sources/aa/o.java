package aa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import q9.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f536b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f537c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f538d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f539e = new HashMap();

    public o(Executor executor) {
        this.f535a = executor;
    }

    public void a(ea.i iVar, r.b bVar) {
        Iterator it = this.f538d.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
    }

    public void b(ea.i iVar) {
        Iterator it = this.f539e.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
    }

    public void c(ea.i iVar, ea.a aVar) {
        Iterator it = this.f536b.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
    }

    public void d(ea.i iVar) {
        Iterator it = this.f537c.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
    }

    public void e() {
        this.f536b.clear();
        this.f539e.clear();
        this.f538d.clear();
        this.f537c.clear();
    }
}
