package tb;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f20927a = Logger.getLogger(a1.class.getName());

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20928a;

        static {
            int[] iArr = new int[gb.b.values().length];
            f20928a = iArr;
            try {
                iArr[gb.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20928a[gb.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20928a[gb.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20928a[gb.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20928a[gb.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20928a[gb.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static Object a(String str) {
        gb.a aVar = new gb.a(new StringReader(str));
        try {
            Object objE = e(aVar);
            try {
                return objE;
            } catch (IOException e10) {
                return objE;
            }
        } finally {
            try {
                aVar.close();
            } catch (IOException e102) {
                f20927a.log(Level.WARNING, "Failed to close", (Throwable) e102);
            }
        }
    }

    public static List b(gb.a aVar) throws IOException {
        aVar.c();
        ArrayList arrayList = new ArrayList();
        while (aVar.Z()) {
            arrayList.add(e(aVar));
        }
        p6.n.u(aVar.n0() == gb.b.END_ARRAY, "Bad token: " + aVar.K());
        aVar.E();
        return Collections.unmodifiableList(arrayList);
    }

    public static Void c(gb.a aVar) throws IOException {
        aVar.j0();
        return null;
    }

    public static Map d(gb.a aVar) throws IOException {
        aVar.e();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (aVar.Z()) {
            linkedHashMap.put(aVar.h0(), e(aVar));
        }
        p6.n.u(aVar.n0() == gb.b.END_OBJECT, "Bad token: " + aVar.K());
        aVar.G();
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static Object e(gb.a aVar) {
        p6.n.u(aVar.Z(), "unexpected end of JSON");
        switch (a.f20928a[aVar.n0().ordinal()]) {
            case 1:
                return b(aVar);
            case 2:
                return d(aVar);
            case 3:
                return aVar.l0();
            case 4:
                return Double.valueOf(aVar.e0());
            case 5:
                return Boolean.valueOf(aVar.d0());
            case 6:
                return c(aVar);
            default:
                throw new IllegalStateException("Bad token: " + aVar.K());
        }
    }
}
