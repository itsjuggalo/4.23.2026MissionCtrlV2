package N3;

import D3.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: N3.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0734o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f5716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f5717b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f5718c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f5719d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f5720e = new HashMap();

    public C0734o(Executor executor) {
        this.f5716a = executor;
    }

    public void a(R3.i iVar, r.b bVar) {
        Iterator it = this.f5719d.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
    }

    public void b(R3.i iVar) {
        Iterator it = this.f5720e.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
    }

    public void c(R3.i iVar, R3.a aVar) {
        Iterator it = this.f5717b.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
    }

    public void d(R3.i iVar) {
        Iterator it = this.f5718c.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
    }

    public void e() {
        this.f5717b.clear();
        this.f5720e.clear();
        this.f5719d.clear();
        this.f5718c.clear();
    }
}
