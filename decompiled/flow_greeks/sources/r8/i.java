package r8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i implements Iterable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g8.e f19414d = new g8.e(Collections.EMPTY_LIST, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f19415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g8.e f19416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f19417c;

    public i(n nVar, h hVar) {
        this.f19417c = hVar;
        this.f19415a = nVar;
        this.f19416b = null;
    }

    public static i c(n nVar) {
        return new i(nVar, q.j());
    }

    public static i d(n nVar, h hVar) {
        return new i(nVar, hVar);
    }

    public Iterator P() {
        a();
        return com.google.android.gms.common.internal.q.b(this.f19416b, f19414d) ? this.f19415a.P() : this.f19416b.P();
    }

    public final void a() {
        if (this.f19416b == null) {
            if (this.f19417c.equals(j.j())) {
                this.f19416b = f19414d;
                return;
            }
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            for (m mVar : this.f19415a) {
                z10 = z10 || this.f19417c.e(mVar.d());
                arrayList.add(new m(mVar.c(), mVar.d()));
            }
            if (z10) {
                this.f19416b = new g8.e(arrayList, this.f19417c);
            } else {
                this.f19416b = f19414d;
            }
        }
    }

    public m e() {
        if (!(this.f19415a instanceof c)) {
            return null;
        }
        a();
        if (!com.google.android.gms.common.internal.q.b(this.f19416b, f19414d)) {
            return (m) this.f19416b.c();
        }
        b bVarU = ((c) this.f19415a).u();
        return new m(bVarU, this.f19415a.z(bVarU));
    }

    public m f() {
        if (!(this.f19415a instanceof c)) {
            return null;
        }
        a();
        if (!com.google.android.gms.common.internal.q.b(this.f19416b, f19414d)) {
            return (m) this.f19416b.a();
        }
        b bVarV = ((c) this.f19415a).v();
        return new m(bVarV, this.f19415a.z(bVarV));
    }

    public n g() {
        return this.f19415a;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a();
        return com.google.android.gms.common.internal.q.b(this.f19416b, f19414d) ? this.f19415a.iterator() : this.f19416b.iterator();
    }

    public b p(b bVar, n nVar, h hVar) {
        if (!this.f19417c.equals(j.j()) && !this.f19417c.equals(hVar)) {
            throw new IllegalArgumentException("Index not available in IndexedNode!");
        }
        a();
        if (com.google.android.gms.common.internal.q.b(this.f19416b, f19414d)) {
            return this.f19415a.x(bVar);
        }
        m mVar = (m) this.f19416b.d(new m(bVar, nVar));
        if (mVar != null) {
            return mVar.c();
        }
        return null;
    }

    public boolean q(h hVar) {
        return this.f19417c == hVar;
    }

    public i r(b bVar, n nVar) {
        n nVarT = this.f19415a.t(bVar, nVar);
        g8.e eVar = this.f19416b;
        g8.e eVar2 = f19414d;
        if (com.google.android.gms.common.internal.q.b(eVar, eVar2) && !this.f19417c.e(nVar)) {
            return new i(nVarT, this.f19417c, eVar2);
        }
        g8.e eVar3 = this.f19416b;
        if (eVar3 == null || com.google.android.gms.common.internal.q.b(eVar3, eVar2)) {
            return new i(nVarT, this.f19417c, null);
        }
        g8.e eVarG = this.f19416b.g(new m(bVar, this.f19415a.z(bVar)));
        if (!nVar.isEmpty()) {
            eVarG = eVarG.e(new m(bVar, nVar));
        }
        return new i(nVarT, this.f19417c, eVarG);
    }

    public i s(n nVar) {
        return new i(this.f19415a.D(nVar), this.f19417c, this.f19416b);
    }

    public i(n nVar, h hVar, g8.e eVar) {
        this.f19417c = hVar;
        this.f19415a = nVar;
        this.f19416b = eVar;
    }
}
