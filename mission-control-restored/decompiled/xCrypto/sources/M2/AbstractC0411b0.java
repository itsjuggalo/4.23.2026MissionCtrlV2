package M2;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import y2.C1946a;

/* JADX INFO: renamed from: M2.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0411b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f2147a = Logger.getLogger(AbstractC0411b0.class.getName());

    /* JADX INFO: renamed from: M2.b0$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2148a;

        static {
            int[] iArr = new int[y2.b.values().length];
            f2148a = iArr;
            try {
                iArr[y2.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2148a[y2.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2148a[y2.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2148a[y2.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2148a[y2.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2148a[y2.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static Object a(String str) {
        C1946a c1946a = new C1946a(new StringReader(str));
        try {
            Object objE = e(c1946a);
            try {
                return objE;
            } catch (IOException e4) {
                return objE;
            }
        } finally {
            try {
                c1946a.close();
            } catch (IOException e42) {
                f2147a.log(Level.WARNING, "Failed to close", (Throwable) e42);
            }
        }
    }

    public static List b(C1946a c1946a) throws IOException {
        c1946a.f();
        ArrayList arrayList = new ArrayList();
        while (c1946a.d0()) {
            arrayList.add(e(c1946a));
        }
        Z1.m.u(c1946a.r0() == y2.b.END_ARRAY, "Bad token: " + c1946a.K());
        c1946a.E();
        return Collections.unmodifiableList(arrayList);
    }

    public static Void c(C1946a c1946a) throws IOException {
        c1946a.n0();
        return null;
    }

    public static Map d(C1946a c1946a) throws IOException {
        c1946a.g();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (c1946a.d0()) {
            linkedHashMap.put(c1946a.l0(), e(c1946a));
        }
        Z1.m.u(c1946a.r0() == y2.b.END_OBJECT, "Bad token: " + c1946a.K());
        c1946a.G();
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static Object e(C1946a c1946a) {
        Z1.m.u(c1946a.d0(), "unexpected end of JSON");
        switch (a.f2148a[c1946a.r0().ordinal()]) {
            case 1:
                return b(c1946a);
            case 2:
                return d(c1946a);
            case 3:
                return c1946a.p0();
            case 4:
                return Double.valueOf(c1946a.i0());
            case 5:
                return Boolean.valueOf(c1946a.h0());
            case 6:
                return c(c1946a);
            default:
                throw new IllegalStateException("Bad token: " + c1946a.K());
        }
    }
}
