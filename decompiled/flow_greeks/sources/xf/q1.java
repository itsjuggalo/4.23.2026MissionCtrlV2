package xf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q1 extends eg.e implements Iterable, qd.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f25042b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q1 f25043c = new q1(dd.r.k());

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends eg.z {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Override // eg.z
        public int c(ConcurrentHashMap concurrentHashMap, String key, pd.k compute) {
            int iIntValue;
            kotlin.jvm.internal.t.f(concurrentHashMap, "<this>");
            kotlin.jvm.internal.t.f(key, "key");
            kotlin.jvm.internal.t.f(compute, "compute");
            Integer num = (Integer) concurrentHashMap.get(key);
            if (num != null) {
                return num.intValue();
            }
            synchronized (concurrentHashMap) {
                try {
                    Integer num2 = (Integer) concurrentHashMap.get(key);
                    if (num2 != null) {
                        iIntValue = num2.intValue();
                    } else {
                        Object objInvoke = compute.invoke(key);
                        concurrentHashMap.putIfAbsent(key, Integer.valueOf(((Number) objInvoke).intValue()));
                        iIntValue = ((Number) objInvoke).intValue();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return iIntValue;
        }

        public final q1 j(List attributes) {
            kotlin.jvm.internal.t.f(attributes, "attributes");
            return attributes.isEmpty() ? k() : new q1(attributes, null);
        }

        public final q1 k() {
            return q1.f25043c;
        }

        public a() {
        }
    }

    public /* synthetic */ q1(List list, kotlin.jvm.internal.k kVar) {
        this(list);
    }

    @Override // eg.a
    public eg.z c() {
        return f25042b;
    }

    public final q1 q(q1 other) {
        kotlin.jvm.internal.t.f(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f25042b.h().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            o1 o1Var = (o1) a().get(iIntValue);
            o1 o1Var2 = (o1) other.a().get(iIntValue);
            hg.a.a(arrayList, o1Var == null ? o1Var2 != null ? o1Var2.a(o1Var) : null : o1Var.a(o1Var2));
        }
        return f25042b.j(arrayList);
    }

    public final boolean r(o1 attribute) {
        kotlin.jvm.internal.t.f(attribute, "attribute");
        return a().get(f25042b.f(attribute.b())) != null;
    }

    public final q1 s(q1 other) {
        kotlin.jvm.internal.t.f(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f25042b.h().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            o1 o1Var = (o1) a().get(iIntValue);
            o1 o1Var2 = (o1) other.a().get(iIntValue);
            hg.a.a(arrayList, o1Var == null ? o1Var2 != null ? o1Var2.c(o1Var) : null : o1Var.c(o1Var2));
        }
        return f25042b.j(arrayList);
    }

    public final q1 u(o1 attribute) {
        kotlin.jvm.internal.t.f(attribute, "attribute");
        if (r(attribute)) {
            return this;
        }
        if (isEmpty()) {
            return new q1(attribute);
        }
        return f25042b.j(dd.a0.t0(dd.a0.I0(this), attribute));
    }

    public final q1 v(o1 attribute) {
        kotlin.jvm.internal.t.f(attribute, "attribute");
        if (!isEmpty()) {
            eg.c cVarA = a();
            ArrayList arrayList = new ArrayList();
            for (Object obj : cVarA) {
                if (!kotlin.jvm.internal.t.b((o1) obj, attribute)) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.size() != a().a()) {
                return f25042b.j(arrayList);
            }
        }
        return this;
    }

    public q1(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            o1 o1Var = (o1) it.next();
            f(o1Var.b(), o1Var);
        }
    }

    public q1(o1 o1Var) {
        this(dd.q.e(o1Var));
    }
}
