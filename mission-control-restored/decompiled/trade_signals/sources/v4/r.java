package v4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class r implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList f23867d = new LinkedList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f23868e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f23869f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f23870g = new HashMap();

    public r(String str, int i8, int i9) {
        this.f23864a = str;
        this.f23865b = i8;
        this.f23866c = i9;
    }

    @Override // v4.p
    public synchronized void b(m mVar) {
        this.f23867d.add(mVar);
        Iterator it = new HashSet(this.f23868e).iterator();
        while (it.hasNext()) {
            j((o) it.next());
        }
    }

    @Override // v4.p
    public synchronized void c() {
        try {
            Iterator it = this.f23868e.iterator();
            while (it.hasNext()) {
                ((o) it.next()).f();
            }
            Iterator it2 = this.f23869f.iterator();
            while (it2.hasNext()) {
                ((o) it2.next()).f();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public o f(String str, int i8) {
        return new o(str, i8);
    }

    public final synchronized m g(o oVar) {
        m mVar;
        o oVar2;
        try {
            ListIterator listIterator = this.f23867d.listIterator();
            do {
                if (!listIterator.hasNext()) {
                    return null;
                }
                mVar = (m) listIterator.next();
                oVar2 = mVar.a() != null ? (o) this.f23870g.get(mVar.a()) : null;
                if (oVar2 == null) {
                    break;
                }
            } while (oVar2 != oVar);
            listIterator.remove();
            return mVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final synchronized void h(o oVar) {
        try {
            HashSet hashSet = new HashSet(this.f23868e);
            this.f23869f.remove(oVar);
            this.f23868e.add(oVar);
            if (!oVar.b() && oVar.d() != null) {
                this.f23870g.remove(oVar.d());
            }
            j(oVar);
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                j((o) it.next());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void j(o oVar) {
        try {
            m mVarG = g(oVar);
            if (mVarG != null) {
                this.f23869f.add(oVar);
                this.f23868e.remove(oVar);
                if (mVarG.a() != null) {
                    this.f23870g.put(mVarG.a(), oVar);
                }
                oVar.e(mVarG);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // v4.p
    public synchronized void start() {
        for (int i8 = 0; i8 < this.f23865b; i8++) {
            final o oVarF = f(this.f23864a + i8, this.f23866c);
            oVarF.g(new Runnable() { // from class: v4.q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f23862a.h(oVarF);
                }
            });
            this.f23868e.add(oVarF);
        }
    }
}
