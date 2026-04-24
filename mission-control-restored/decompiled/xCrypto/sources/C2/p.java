package C2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class p implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList f219d = new LinkedList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f220e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f221f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f222g = new HashMap();

    public p(String str, int i4, int i5) {
        this.f216a = str;
        this.f217b = i4;
        this.f218c = i5;
    }

    @Override // C2.n
    public synchronized void c() {
        try {
            Iterator it = this.f220e.iterator();
            while (it.hasNext()) {
                ((m) it.next()).f();
            }
            Iterator it2 = this.f221f.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).f();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // C2.n
    public synchronized void d(k kVar) {
        this.f219d.add(kVar);
        Iterator it = new HashSet(this.f220e).iterator();
        while (it.hasNext()) {
            j((m) it.next());
        }
    }

    public m f(String str, int i4) {
        return new m(str, i4);
    }

    public final synchronized k g(m mVar) {
        k kVar;
        m mVar2;
        try {
            ListIterator listIterator = this.f219d.listIterator();
            do {
                if (!listIterator.hasNext()) {
                    return null;
                }
                kVar = (k) listIterator.next();
                mVar2 = kVar.a() != null ? (m) this.f222g.get(kVar.a()) : null;
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
            HashSet hashSet = new HashSet(this.f220e);
            this.f221f.remove(mVar);
            this.f220e.add(mVar);
            if (!mVar.b() && mVar.d() != null) {
                this.f222g.remove(mVar.d());
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
                this.f221f.add(mVar);
                this.f220e.remove(mVar);
                if (kVarG.a() != null) {
                    this.f222g.put(kVarG.a(), mVar);
                }
                mVar.e(kVarG);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // C2.n
    public synchronized void start() {
        for (int i4 = 0; i4 < this.f217b; i4++) {
            final m mVarF = f(this.f216a + i4, this.f218c);
            mVarF.g(new Runnable() { // from class: C2.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f214a.h(mVarF);
                }
            });
            this.f220e.add(mVarF);
        }
    }
}
