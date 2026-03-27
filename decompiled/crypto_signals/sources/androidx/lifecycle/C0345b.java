package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0345b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f4669a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f4670b;

    public C0345b(HashMap map) {
        this.f4670b = map;
        for (Map.Entry entry : map.entrySet()) {
            EnumC0356m enumC0356m = (EnumC0356m) entry.getValue();
            List arrayList = (List) this.f4669a.get(enumC0356m);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f4669a.put(enumC0356m, arrayList);
            }
            arrayList.add((C0346c) entry.getKey());
        }
    }

    public static void a(List list, InterfaceC0362t interfaceC0362t, EnumC0356m enumC0356m, InterfaceC0361s interfaceC0361s) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                C0346c c0346c = (C0346c) list.get(size);
                c0346c.getClass();
                try {
                    int i = c0346c.f4671a;
                    Method method = c0346c.f4672b;
                    if (i == 0) {
                        method.invoke(interfaceC0361s, new Object[0]);
                    } else if (i == 1) {
                        method.invoke(interfaceC0361s, interfaceC0362t);
                    } else if (i == 2) {
                        method.invoke(interfaceC0361s, interfaceC0362t, enumC0356m);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException("Failed to call observer method", e2.getCause());
                }
            }
        }
    }
}
