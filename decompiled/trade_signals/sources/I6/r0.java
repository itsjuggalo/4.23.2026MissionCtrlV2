package I6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2594p;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 extends P6.e implements Iterable, C5.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f4460b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r0 f4461c = new r0(AbstractC2595q.i());

    public static final class a extends P6.z {
        public a() {
        }

        @Override // P6.z
        public int c(ConcurrentHashMap concurrentHashMap, String key, B5.k compute) {
            int iIntValue;
            AbstractC2304t.f(concurrentHashMap, "<this>");
            AbstractC2304t.f(key, "key");
            AbstractC2304t.f(compute, "compute");
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

        public final r0 j(List attributes) {
            AbstractC2304t.f(attributes, "attributes");
            return attributes.isEmpty() ? k() : new r0(attributes, null);
        }

        public final r0 k() {
            return r0.f4461c;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public r0(p0 p0Var) {
        this(AbstractC2594p.e(p0Var));
    }

    public final r0 C(r0 other) {
        AbstractC2304t.f(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f4460b.h().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            p0 p0Var = (p0) a().get(iIntValue);
            p0 p0Var2 = (p0) other.a().get(iIntValue);
            S6.a.a(arrayList, p0Var == null ? p0Var2 != null ? p0Var2.a(p0Var) : null : p0Var.a(p0Var2));
        }
        return f4460b.j(arrayList);
    }

    public final boolean F(p0 attribute) {
        AbstractC2304t.f(attribute, "attribute");
        return a().get(f4460b.e(attribute.b())) != null;
    }

    public final r0 H(r0 other) {
        AbstractC2304t.f(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f4460b.h().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            p0 p0Var = (p0) a().get(iIntValue);
            p0 p0Var2 = (p0) other.a().get(iIntValue);
            S6.a.a(arrayList, p0Var == null ? p0Var2 != null ? p0Var2.c(p0Var) : null : p0Var.c(p0Var2));
        }
        return f4460b.j(arrayList);
    }

    public final r0 I(p0 attribute) {
        AbstractC2304t.f(attribute, "attribute");
        if (F(attribute)) {
            return this;
        }
        if (isEmpty()) {
            return new r0(attribute);
        }
        return f4460b.j(p5.z.s0(p5.z.G0(this), attribute));
    }

    public final r0 J(p0 attribute) {
        AbstractC2304t.f(attribute, "attribute");
        if (isEmpty()) {
            return this;
        }
        P6.c cVarA = a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : cVarA) {
            if (!AbstractC2304t.b((p0) obj, attribute)) {
                arrayList.add(obj);
            }
        }
        return arrayList.size() == a().a() ? this : f4460b.j(arrayList);
    }

    @Override // P6.AbstractC0788a
    public P6.z d() {
        return f4460b;
    }

    public r0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p0 p0Var = (p0) it.next();
            e(p0Var.b(), p0Var);
        }
    }

    public /* synthetic */ r0(List list, AbstractC2296k abstractC2296k) {
        this(list);
    }
}
