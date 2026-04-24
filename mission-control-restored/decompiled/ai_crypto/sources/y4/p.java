package y4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class p implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f25738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f25739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList f25740d = new LinkedList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f25741e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f25742f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f25743g = new HashMap();

    public p(String str, int i7, int i8) {
        this.f25737a = str;
        this.f25738b = i7;
        this.f25739c = i8;
    }

    @Override // y4.n
    public synchronized void a(k kVar) {
        this.f25740d.add(kVar);
        Iterator it = new HashSet(this.f25741e).iterator();
        while (it.hasNext()) {
            j((m) it.next());
        }
    }

    @Override // y4.n
    public synchronized void c() {
        try {
            Iterator it = this.f25741e.iterator();
            while (it.hasNext()) {
                ((m) it.next()).f();
            }
            Iterator it2 = this.f25742f.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).f();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public m f(String str, int i7) {
        return new m(str, i7);
    }

    public final synchronized k g(m mVar) {
        k kVar;
        m mVar2;
        try {
            ListIterator listIterator = this.f25740d.listIterator();
            do {
                if (!listIterator.hasNext()) {
                    return null;
                }
                kVar = (k) listIterator.next();
                mVar2 = kVar.a() != null ? (m) this.f25743g.get(kVar.a()) : null;
                if (mVar2 == null) {
                    break;
                }
            } while (mVar2 != mVar);
            listIterator.remove();
            return kVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final synchronized void h(m mVar) {
        try {
            HashSet hashSet = new HashSet(this.f25741e);
            this.f25742f.remove(mVar);
            this.f25741e.add(mVar);
            if (!mVar.b() && mVar.d() != null) {
                this.f25743g.remove(mVar.d());
            }
            j(mVar);
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                j((m) it.next());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void j(m mVar) {
        try {
            k kVarG = g(mVar);
            if (kVarG != null) {
                this.f25742f.add(mVar);
                this.f25741e.remove(mVar);
                if (kVarG.a() != null) {
                    this.f25743g.put(kVarG.a(), mVar);
                }
                mVar.e(kVarG);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // y4.n
    public synchronized void start() {
        for (int i7 = 0; i7 < this.f25738b; i7++) {
            final m mVarF = f(this.f25737a + i7, this.f25739c);
            mVarF.g(new Runnable() { // from class: y4.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f25735a.h(mVarF);
                }
            });
            this.f25741e.add(mVarF);
        }
    }
}
