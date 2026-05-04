package v3;

import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f23115a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f23116b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23117c;

    public boolean a(y3.c cVar) {
        boolean z10 = true;
        if (cVar == null) {
            return true;
        }
        boolean zRemove = this.f23115a.remove(cVar);
        if (!this.f23116b.remove(cVar) && !zRemove) {
            z10 = false;
        }
        if (z10) {
            cVar.clear();
        }
        return z10;
    }

    public void b() {
        Iterator it = c4.l.j(this.f23115a).iterator();
        while (it.hasNext()) {
            a((y3.c) it.next());
        }
        this.f23116b.clear();
    }

    public void c() {
        this.f23117c = true;
        for (y3.c cVar : c4.l.j(this.f23115a)) {
            if (cVar.isRunning() || cVar.i()) {
                cVar.clear();
                this.f23116b.add(cVar);
            }
        }
    }

    public void d() {
        this.f23117c = true;
        for (y3.c cVar : c4.l.j(this.f23115a)) {
            if (cVar.isRunning()) {
                cVar.pause();
                this.f23116b.add(cVar);
            }
        }
    }

    public void e() {
        for (y3.c cVar : c4.l.j(this.f23115a)) {
            if (!cVar.i() && !cVar.g()) {
                cVar.clear();
                if (this.f23117c) {
                    this.f23116b.add(cVar);
                } else {
                    cVar.h();
                }
            }
        }
    }

    public void f() {
        this.f23117c = false;
        for (y3.c cVar : c4.l.j(this.f23115a)) {
            if (!cVar.i() && !cVar.isRunning()) {
                cVar.h();
            }
        }
        this.f23116b.clear();
    }

    public void g(y3.c cVar) {
        this.f23115a.add(cVar);
        if (!this.f23117c) {
            cVar.h();
            return;
        }
        cVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f23116b.add(cVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f23115a.size() + ", isPaused=" + this.f23117c + "}";
    }
}
