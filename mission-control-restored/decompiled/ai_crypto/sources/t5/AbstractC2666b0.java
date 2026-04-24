package t5;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import t4.C2657a;

/* JADX INFO: renamed from: t5.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2666b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f23698a = Logger.getLogger(AbstractC2666b0.class.getName());

    /* JADX INFO: renamed from: t5.b0$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23699a;

        static {
            int[] iArr = new int[t4.b.values().length];
            f23699a = iArr;
            try {
                iArr[t4.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23699a[t4.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23699a[t4.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23699a[t4.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23699a[t4.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23699a[t4.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static Object a(String str) {
        C2657a c2657a = new C2657a(new StringReader(str));
        try {
            return e(c2657a);
        } finally {
            try {
                c2657a.close();
            } catch (IOException e7) {
                f23698a.log(Level.WARNING, "Failed to close", (Throwable) e7);
            }
        }
    }

    public static List b(C2657a c2657a) throws IOException {
        c2657a.i();
        ArrayList arrayList = new ArrayList();
        while (c2657a.y0()) {
            arrayList.add(e(c2657a));
        }
        H2.m.u(c2657a.M0() == t4.b.END_ARRAY, "Bad token: " + c2657a.V());
        c2657a.M();
        return Collections.unmodifiableList(arrayList);
    }

    public static Void c(C2657a c2657a) throws IOException {
        c2657a.I0();
        return null;
    }

    public static Map d(C2657a c2657a) throws IOException {
        c2657a.A();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (c2657a.y0()) {
            linkedHashMap.put(c2657a.G0(), e(c2657a));
        }
        H2.m.u(c2657a.M0() == t4.b.END_OBJECT, "Bad token: " + c2657a.V());
        c2657a.O();
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static Object e(C2657a c2657a) {
        H2.m.u(c2657a.y0(), "unexpected end of JSON");
        switch (a.f23699a[c2657a.M0().ordinal()]) {
            case 1:
                return b(c2657a);
            case 2:
                return d(c2657a);
            case 3:
                return c2657a.K0();
            case 4:
                return Double.valueOf(c2657a.D0());
            case 5:
                return Boolean.valueOf(c2657a.C0());
            case 6:
                return c(c2657a);
            default:
                throw new IllegalStateException("Bad token: " + c2657a.V());
        }
    }
}
