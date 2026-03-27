package a5;

import F5.AbstractC0552j;
import F5.AbstractC0555m;
import F5.AbstractC0556n;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Z f6368a = new Z();

    public final boolean a(Object obj, Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        if ((obj instanceof int[]) && (obj2 instanceof int[])) {
            return Arrays.equals((int[]) obj, (int[]) obj2);
        }
        if ((obj instanceof long[]) && (obj2 instanceof long[])) {
            return Arrays.equals((long[]) obj, (long[]) obj2);
        }
        if ((obj instanceof double[]) && (obj2 instanceof double[])) {
            return Arrays.equals((double[]) obj, (double[]) obj2);
        }
        if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            Object[] objArr2 = (Object[]) obj2;
            if (objArr.length != objArr2.length) {
                return false;
            }
            Iterable iterableV = AbstractC0552j.v(objArr);
            if (!(iterableV instanceof Collection) || !((Collection) iterableV).isEmpty()) {
                Iterator it = iterableV.iterator();
                while (it.hasNext()) {
                    int iC = ((F5.E) it).c();
                    if (!f6368a.a(objArr[iC], objArr2[iC])) {
                        return false;
                    }
                }
            }
            return true;
        }
        if ((obj instanceof List) && (obj2 instanceof List)) {
            List list = (List) obj;
            List list2 = (List) obj2;
            if (list.size() != list2.size()) {
                return false;
            }
            Iterable iterableH = AbstractC0556n.h((Collection) obj);
            if (!(iterableH instanceof Collection) || !((Collection) iterableH).isEmpty()) {
                Iterator it2 = iterableH.iterator();
                while (it2.hasNext()) {
                    int iC2 = ((F5.E) it2).c();
                    if (!f6368a.a(list.get(iC2), list2.get(iC2))) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (!(obj instanceof Map) || !(obj2 instanceof Map)) {
            return kotlin.jvm.internal.r.b(obj, obj2);
        }
        Map map = (Map) obj;
        Map map2 = (Map) obj2;
        if (map.size() != map2.size()) {
            return false;
        }
        if (!map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                if (!map2.containsKey(entry.getKey()) || !f6368a.a(entry.getValue(), map2.get(entry.getKey()))) {
                    return false;
                }
            }
        }
        return true;
    }

    public final List b(Throwable exception) {
        kotlin.jvm.internal.r.f(exception, "exception");
        if (exception instanceof C0928z) {
            C0928z c0928z = (C0928z) exception;
            return AbstractC0556n.j(c0928z.a(), c0928z.getMessage(), c0928z.b());
        }
        return AbstractC0556n.j(exception.getClass().getSimpleName(), exception.toString(), "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }

    public final List c(Object obj) {
        return AbstractC0555m.b(obj);
    }
}
