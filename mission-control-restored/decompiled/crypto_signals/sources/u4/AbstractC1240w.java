package u4;

import com.google.protobuf.AbstractC0450a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* JADX INFO: renamed from: u4.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1240w {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.ArrayList] */
    public static List f(Class cls, List list, ClassLoader classLoader, h0 h0Var) {
        ?? Load;
        Object objNewInstance;
        try {
            Class.forName("android.app.Application", false, classLoader);
            Load = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Class cls2 = (Class) it.next();
                try {
                    objNewInstance = cls2.asSubclass(cls).getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (ClassCastException unused) {
                    objNewInstance = null;
                } catch (Throwable th) {
                    throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", cls2.getName(), th), th);
                }
                if (objNewInstance != null) {
                    Load.add(objNewInstance);
                }
            }
        } catch (Exception unused2) {
            ServiceLoader serviceLoaderLoad = ServiceLoader.load(cls, classLoader);
            Load = !serviceLoaderLoad.iterator().hasNext() ? ServiceLoader.load(cls) : serviceLoaderLoad;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : Load) {
            if (h0Var.e(obj)) {
                arrayList.add(obj);
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder(new N2.D(h0Var)));
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public u4.C1236s a() {
        /*
            r4 = this;
            java.util.List r0 = r4.b()
            r1 = 0
            if (r0 == 0) goto Lf
            int r2 = r0.size()
            r3 = 1
            if (r2 != r3) goto Lf
            goto L10
        Lf:
            r3 = r1
        L10:
            java.lang.String r2 = "%s does not have exactly one group"
            s3.D.o(r0, r2, r3)
            java.lang.Object r0 = r0.get(r1)
            u4.s r0 = (u4.C1236s) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.AbstractC1240w.a():u4.s");
    }

    public abstract List b();

    public abstract C1220b c();

    public abstract AbstractC1222d d();

    public abstract Object e();

    public abstract void g(j0 j0Var, Z z6);

    public abstract void h(j0 j0Var);

    public abstract void j(AbstractC0450a abstractC0450a);

    public abstract void l(d0 d0Var);

    public abstract void m();

    public abstract void n();

    public abstract void o(L l6);

    public abstract void p(List list);

    public void k() {
    }

    public void i(Z z6) {
    }
}
