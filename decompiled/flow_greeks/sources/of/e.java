package of;

import ce.l;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public enum e {
    BOOLEAN(l.f3919g, "boolean", "Z", "java.lang.Boolean"),
    CHAR(l.f3920h, "char", "C", "java.lang.Character"),
    BYTE(l.f3921i, "byte", "B", "java.lang.Byte"),
    SHORT(l.f3922j, "short", "S", "java.lang.Short"),
    INT(l.f3923k, "int", "I", "java.lang.Integer"),
    FLOAT(l.f3924l, "float", "F", "java.lang.Float"),
    LONG(l.f3925m, "long", "J", "java.lang.Long"),
    DOUBLE(l.f3926n, "double", "D", "java.lang.Double");


    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map f18123m = new HashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Map f18124n = new EnumMap(l.class);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Map f18125o = new HashMap();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Set f18126p = new HashSet();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Map f18127q = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f18129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ef.c f18132d;

    static {
        for (e eVar : values()) {
            f18123m.put(eVar.i(), eVar);
            f18124n.put(eVar.k(), eVar);
            f18125o.put(eVar.h(), eVar);
            String strReplace = eVar.f18132d.a().replace(com.amazon.a.a.o.c.a.b.f4610a, '/');
            f18126p.add(strReplace);
            f18127q.put(strReplace, "(" + eVar.f18131c + ")L" + strReplace + ";");
        }
    }

    e(l lVar, String str, String str2, String str3) {
        if (lVar == null) {
            a(8);
        }
        if (str == null) {
            a(9);
        }
        if (str2 == null) {
            a(10);
        }
        if (str3 == null) {
            a(11);
        }
        this.f18129a = lVar;
        this.f18130b = str;
        this.f18131c = str2;
        this.f18132d = new ef.c(str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r8) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: of.e.a(int):void");
    }

    public static e b(l lVar) {
        if (lVar == null) {
            a(5);
        }
        e eVar = (e) f18124n.get(lVar);
        if (eVar == null) {
            a(6);
        }
        return eVar;
    }

    public static e c(String str) {
        if (str == null) {
            a(3);
        }
        e eVar = (e) f18123m.get(str);
        if (eVar != null) {
            return eVar;
        }
        throw new AssertionError("Non-primitive type name passed: " + str);
    }

    public String h() {
        String str = this.f18131c;
        if (str == null) {
            a(14);
        }
        return str;
    }

    public String i() {
        String str = this.f18130b;
        if (str == null) {
            a(13);
        }
        return str;
    }

    public l k() {
        l lVar = this.f18129a;
        if (lVar == null) {
            a(12);
        }
        return lVar;
    }

    public ef.c l() {
        ef.c cVar = this.f18132d;
        if (cVar == null) {
            a(15);
        }
        return cVar;
    }
}
