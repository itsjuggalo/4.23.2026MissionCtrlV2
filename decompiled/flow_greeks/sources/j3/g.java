package j3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f13838a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f13839b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f13840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f13841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f13842c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f13843d;

        public a() {
            this(null);
        }

        public void a(Object obj) {
            if (this.f13841b == null) {
                this.f13841b = new ArrayList();
            }
            this.f13841b.add(obj);
        }

        public Object b() {
            int iC = c();
            if (iC > 0) {
                return this.f13841b.remove(iC - 1);
            }
            return null;
        }

        public int c() {
            List list = this.f13841b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public a(Object obj) {
            this.f13843d = this;
            this.f13842c = this;
            this.f13840a = obj;
        }
    }

    public static void e(a aVar) {
        a aVar2 = aVar.f13843d;
        aVar2.f13842c = aVar.f13842c;
        aVar.f13842c.f13843d = aVar2;
    }

    public static void g(a aVar) {
        aVar.f13842c.f13843d = aVar;
        aVar.f13843d.f13842c = aVar;
    }

    public Object a(m mVar) {
        a aVar = (a) this.f13839b.get(mVar);
        if (aVar == null) {
            aVar = new a(mVar);
            this.f13839b.put(mVar, aVar);
        } else {
            mVar.a();
        }
        b(aVar);
        return aVar.b();
    }

    public final void b(a aVar) {
        e(aVar);
        a aVar2 = this.f13838a;
        aVar.f13843d = aVar2;
        aVar.f13842c = aVar2.f13842c;
        g(aVar);
    }

    public final void c(a aVar) {
        e(aVar);
        a aVar2 = this.f13838a;
        aVar.f13843d = aVar2.f13843d;
        aVar.f13842c = aVar2;
        g(aVar);
    }

    public void d(m mVar, Object obj) {
        a aVar = (a) this.f13839b.get(mVar);
        if (aVar == null) {
            aVar = new a(mVar);
            c(aVar);
            this.f13839b.put(mVar, aVar);
        } else {
            mVar.a();
        }
        aVar.a(obj);
    }

    public Object f() {
        for (a aVar = this.f13838a.f13843d; !aVar.equals(this.f13838a); aVar = aVar.f13843d) {
            Object objB = aVar.b();
            if (objB != null) {
                return objB;
            }
            e(aVar);
            this.f13839b.remove(aVar.f13840a);
            ((m) aVar.f13840a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.f13838a.f13842c;
        boolean z10 = false;
        while (!aVar.equals(this.f13838a)) {
            sb2.append('{');
            sb2.append(aVar.f13840a);
            sb2.append(':');
            sb2.append(aVar.c());
            sb2.append("}, ");
            aVar = aVar.f13842c;
            z10 = true;
        }
        if (z10) {
            sb2.delete(sb2.length() - 2, sb2.length());
        }
        sb2.append(" )");
        return sb2.toString();
    }
}
