package j1;

import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import q1.AbstractC2629l;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f19966a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f19967b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f19968c;

    public boolean a(m1.c cVar) {
        boolean z7 = true;
        if (cVar == null) {
            return true;
        }
        boolean zRemove = this.f19966a.remove(cVar);
        if (!this.f19967b.remove(cVar) && !zRemove) {
            z7 = false;
        }
        if (z7) {
            cVar.clear();
        }
        return z7;
    }

    public void b() {
        Iterator it = AbstractC2629l.j(this.f19966a).iterator();
        while (it.hasNext()) {
            a((m1.c) it.next());
        }
        this.f19967b.clear();
    }

    public void c() {
        this.f19968c = true;
        for (m1.c cVar : AbstractC2629l.j(this.f19966a)) {
            if (cVar.isRunning() || cVar.j()) {
                cVar.clear();
                this.f19967b.add(cVar);
            }
        }
    }

    public void d() {
        this.f19968c = true;
        for (m1.c cVar : AbstractC2629l.j(this.f19966a)) {
            if (cVar.isRunning()) {
                cVar.pause();
                this.f19967b.add(cVar);
            }
        }
    }

    public void e() {
        for (m1.c cVar : AbstractC2629l.j(this.f19966a)) {
            if (!cVar.j() && !cVar.g()) {
                cVar.clear();
                if (this.f19968c) {
                    this.f19967b.add(cVar);
                } else {
                    cVar.i();
                }
            }
        }
    }

    public void f() {
        this.f19968c = false;
        for (m1.c cVar : AbstractC2629l.j(this.f19966a)) {
            if (!cVar.j() && !cVar.isRunning()) {
                cVar.i();
            }
        }
        this.f19967b.clear();
    }

    public void g(m1.c cVar) {
        this.f19966a.add(cVar);
        if (!this.f19968c) {
            cVar.i();
            return;
        }
        cVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f19967b.add(cVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f19966a.size() + ", isPaused=" + this.f19968c + "}";
    }
}
