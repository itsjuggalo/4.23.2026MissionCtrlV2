package X0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f9325a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f9326b = new HashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f9327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f9328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f9329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f9330d;

        public a() {
            this(null);
        }

        public void a(Object obj) {
            if (this.f9328b == null) {
                this.f9328b = new ArrayList();
            }
            this.f9328b.add(obj);
        }

        public Object b() {
            int iC = c();
            if (iC > 0) {
                return this.f9328b.remove(iC - 1);
            }
            return null;
        }

        public int c() {
            List list = this.f9328b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public a(Object obj) {
            this.f9330d = this;
            this.f9329c = this;
            this.f9327a = obj;
        }
    }

    public static void e(a aVar) {
        a aVar2 = aVar.f9330d;
        aVar2.f9329c = aVar.f9329c;
        aVar.f9329c.f9330d = aVar2;
    }

    public static void g(a aVar) {
        aVar.f9329c.f9330d = aVar;
        aVar.f9330d.f9329c = aVar;
    }

    public Object a(m mVar) {
        a aVar = (a) this.f9326b.get(mVar);
        if (aVar == null) {
            aVar = new a(mVar);
            this.f9326b.put(mVar, aVar);
        } else {
            mVar.a();
        }
        b(aVar);
        return aVar.b();
    }

    public final void b(a aVar) {
        e(aVar);
        a aVar2 = this.f9325a;
        aVar.f9330d = aVar2;
        aVar.f9329c = aVar2.f9329c;
        g(aVar);
    }

    public final void c(a aVar) {
        e(aVar);
        a aVar2 = this.f9325a;
        aVar.f9330d = aVar2.f9330d;
        aVar.f9329c = aVar2;
        g(aVar);
    }

    public void d(m mVar, Object obj) {
        a aVar = (a) this.f9326b.get(mVar);
        if (aVar == null) {
            aVar = new a(mVar);
            c(aVar);
            this.f9326b.put(mVar, aVar);
        } else {
            mVar.a();
        }
        aVar.a(obj);
    }

    public Object f() {
        a aVar = this.f9325a;
        while (true) {
            aVar = aVar.f9330d;
            if (aVar.equals(this.f9325a)) {
                return null;
            }
            Object objB = aVar.b();
            if (objB != null) {
                return objB;
            }
            e(aVar);
            this.f9326b.remove(aVar.f9327a);
            ((m) aVar.f9327a).a();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.f9325a.f9329c;
        boolean z7 = false;
        while (!aVar.equals(this.f9325a)) {
            sb.append('{');
            sb.append(aVar.f9327a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
            aVar = aVar.f9329c;
            z7 = true;
        }
        if (z7) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
