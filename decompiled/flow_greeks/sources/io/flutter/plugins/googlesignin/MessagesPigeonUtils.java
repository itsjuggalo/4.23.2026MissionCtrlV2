package io.flutter.plugins.googlesignin;

import android.util.Log;
import dd.j0;
import dd.r;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001J\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0001¨\u0006\u000e"}, d2 = {"Lio/flutter/plugins/googlesignin/MessagesPigeonUtils;", "", "<init>", "()V", "wrapResult", "", "result", "wrapError", "exception", "", "deepEquals", "", "a", "b", "google_sign_in_android_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class MessagesPigeonUtils {
    public static final MessagesPigeonUtils INSTANCE = new MessagesPigeonUtils();

    private MessagesPigeonUtils() {
    }

    public final boolean deepEquals(Object a10, Object b10) {
        if ((a10 instanceof byte[]) && (b10 instanceof byte[])) {
            return Arrays.equals((byte[]) a10, (byte[]) b10);
        }
        if ((a10 instanceof int[]) && (b10 instanceof int[])) {
            return Arrays.equals((int[]) a10, (int[]) b10);
        }
        if ((a10 instanceof long[]) && (b10 instanceof long[])) {
            return Arrays.equals((long[]) a10, (long[]) b10);
        }
        if ((a10 instanceof double[]) && (b10 instanceof double[])) {
            return Arrays.equals((double[]) a10, (double[]) b10);
        }
        if ((a10 instanceof Object[]) && (b10 instanceof Object[])) {
            Object[] objArr = (Object[]) a10;
            Object[] objArr2 = (Object[]) b10;
            if (objArr.length == objArr2.length) {
                Iterable iterableE = dd.n.E(objArr);
                if (!(iterableE instanceof Collection) || !((Collection) iterableE).isEmpty()) {
                    Iterator it = iterableE.iterator();
                    while (it.hasNext()) {
                        int iNextInt = ((j0) it).nextInt();
                        if (!INSTANCE.deepEquals(objArr[iNextInt], objArr2[iNextInt])) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        if ((a10 instanceof List) && (b10 instanceof List)) {
            List list = (List) a10;
            List list2 = (List) b10;
            if (list.size() == list2.size()) {
                Iterable iterableL = r.l((Collection) a10);
                if (!(iterableL instanceof Collection) || !((Collection) iterableL).isEmpty()) {
                    Iterator it2 = iterableL.iterator();
                    while (it2.hasNext()) {
                        int iNextInt2 = ((j0) it2).nextInt();
                        if (!INSTANCE.deepEquals(list.get(iNextInt2), list2.get(iNextInt2))) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        if (!(a10 instanceof Map) || !(b10 instanceof Map)) {
            return kotlin.jvm.internal.t.b(a10, b10);
        }
        Map map = (Map) a10;
        Map map2 = (Map) b10;
        if (map.size() == map2.size()) {
            if (!map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    if (!map2.containsKey(entry.getKey()) || !INSTANCE.deepEquals(entry.getValue(), map2.get(entry.getKey()))) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final List<Object> wrapError(Throwable exception) {
        kotlin.jvm.internal.t.f(exception, "exception");
        if (exception instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) exception;
            return r.n(flutterError.getCode(), flutterError.getMessage(), flutterError.getDetails());
        }
        return r.n(exception.getClass().getSimpleName(), exception.toString(), "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }

    public final List<Object> wrapResult(Object result) {
        return dd.q.e(result);
    }
}
