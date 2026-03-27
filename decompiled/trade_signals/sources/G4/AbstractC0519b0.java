package G4;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import p4.C2568a;
import p4.EnumC2569b;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: G4.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0519b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f2735a = Logger.getLogger(AbstractC0519b0.class.getName());

    /* JADX INFO: renamed from: G4.b0$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2736a;

        static {
            int[] iArr = new int[EnumC2569b.values().length];
            f2736a = iArr;
            try {
                iArr[EnumC2569b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2736a[EnumC2569b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2736a[EnumC2569b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2736a[EnumC2569b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2736a[EnumC2569b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2736a[EnumC2569b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static Object a(String str) {
        C2568a c2568a = new C2568a(new StringReader(str));
        try {
            return e(c2568a);
        } finally {
            try {
                c2568a.close();
            } catch (IOException e8) {
                f2735a.log(Level.WARNING, "Failed to close", (Throwable) e8);
            }
        }
    }

    public static List b(C2568a c2568a) throws IOException {
        c2568a.c();
        ArrayList arrayList = new ArrayList();
        while (c2568a.Q()) {
            arrayList.add(e(c2568a));
        }
        AbstractC2848n.u(c2568a.x0() == EnumC2569b.END_ARRAY, "Bad token: " + c2568a.K());
        c2568a.B();
        return Collections.unmodifiableList(arrayList);
    }

    public static Void c(C2568a c2568a) throws IOException {
        c2568a.r0();
        return null;
    }

    public static Map d(C2568a c2568a) throws IOException {
        c2568a.e();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (c2568a.Q()) {
            linkedHashMap.put(c2568a.i0(), e(c2568a));
        }
        AbstractC2848n.u(c2568a.x0() == EnumC2569b.END_OBJECT, "Bad token: " + c2568a.K());
        c2568a.D();
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static Object e(C2568a c2568a) {
        AbstractC2848n.u(c2568a.Q(), "unexpected end of JSON");
        switch (a.f2736a[c2568a.x0().ordinal()]) {
            case 1:
                return b(c2568a);
            case 2:
                return d(c2568a);
            case 3:
                return c2568a.v0();
            case 4:
                return Double.valueOf(c2568a.W());
            case 5:
                return Boolean.valueOf(c2568a.U());
            case 6:
                return c(c2568a);
            default:
                throw new IllegalStateException("Bad token: " + c2568a.K());
        }
    }
}
