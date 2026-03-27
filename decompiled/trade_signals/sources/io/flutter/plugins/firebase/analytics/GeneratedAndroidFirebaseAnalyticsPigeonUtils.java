package io.flutter.plugins.firebase.analytics;

import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;
import p5.AbstractC2594p;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
final class GeneratedAndroidFirebaseAnalyticsPigeonUtils {
    public static final GeneratedAndroidFirebaseAnalyticsPigeonUtils INSTANCE = new GeneratedAndroidFirebaseAnalyticsPigeonUtils();

    private GeneratedAndroidFirebaseAnalyticsPigeonUtils() {
    }

    public final boolean deepEquals(Object obj, Object obj2) {
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
            Iterable iterableE = AbstractC2592n.E(objArr);
            if (!(iterableE instanceof Collection) || !((Collection) iterableE).isEmpty()) {
                Iterator it = iterableE.iterator();
                while (it.hasNext()) {
                    int iC = ((p5.I) it).c();
                    if (!INSTANCE.deepEquals(objArr[iC], objArr2[iC])) {
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
            Iterable iterableJ = AbstractC2595q.j((Collection) obj);
            if (!(iterableJ instanceof Collection) || !((Collection) iterableJ).isEmpty()) {
                Iterator it2 = iterableJ.iterator();
                while (it2.hasNext()) {
                    int iC2 = ((p5.I) it2).c();
                    if (!INSTANCE.deepEquals(list.get(iC2), list2.get(iC2))) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (!(obj instanceof Map) || !(obj2 instanceof Map)) {
            return AbstractC2304t.b(obj, obj2);
        }
        Map map = (Map) obj;
        Map map2 = (Map) obj2;
        if (map.size() != map2.size()) {
            return false;
        }
        if (!map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                if (!map2.containsKey(entry.getKey()) || !INSTANCE.deepEquals(entry.getValue(), map2.get(entry.getKey()))) {
                    return false;
                }
            }
        }
        return true;
    }

    public final List<Object> wrapError(Throwable exception) {
        AbstractC2304t.f(exception, "exception");
        if (exception instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) exception;
            return AbstractC2595q.l(flutterError.getCode(), flutterError.getMessage(), flutterError.getDetails());
        }
        return AbstractC2595q.l(exception.getClass().getSimpleName(), exception.toString(), "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }

    public final List<Object> wrapResult(Object obj) {
        return AbstractC2594p.e(obj);
    }
}
