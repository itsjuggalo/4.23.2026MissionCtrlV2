package z6;

import O5.l;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: z6.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public enum EnumC3021e {
    BOOLEAN(l.f6059g, "boolean", "Z", "java.lang.Boolean"),
    CHAR(l.f6060h, "char", "C", "java.lang.Character"),
    BYTE(l.f6061i, "byte", "B", "java.lang.Byte"),
    SHORT(l.f6062j, "short", "S", "java.lang.Short"),
    INT(l.f6063k, "int", "I", "java.lang.Integer"),
    FLOAT(l.f6064l, "float", "F", "java.lang.Float"),
    LONG(l.f6065m, "long", "J", "java.lang.Long"),
    DOUBLE(l.f6066n, "double", "D", "java.lang.Double");


    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map f24817m = new HashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Map f24818n = new EnumMap(l.class);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Map f24819o = new HashMap();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Set f24820p = new HashSet();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Map f24821q = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f24823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q6.c f24826d;

    static {
        for (EnumC3021e enumC3021e : values()) {
            f24817m.put(enumC3021e.k(), enumC3021e);
            f24818n.put(enumC3021e.l(), enumC3021e);
            f24819o.put(enumC3021e.i(), enumC3021e);
            String strReplace = enumC3021e.f24826d.a().replace(com.amazon.a.a.o.c.a.b.f14112a, '/');
            f24820p.add(strReplace);
            f24821q.put(strReplace, "(" + enumC3021e.f24825c + ")L" + strReplace + ";");
        }
    }

    EnumC3021e(l lVar, String str, String str2, String str3) {
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
        this.f24823a = lVar;
        this.f24824b = str;
        this.f24825c = str2;
        this.f24826d = new q6.c(str3);
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
        throw new UnsupportedOperationException("Method not decompiled: z6.EnumC3021e.a(int):void");
    }

    public static EnumC3021e b(l lVar) {
        if (lVar == null) {
            a(5);
        }
        EnumC3021e enumC3021e = (EnumC3021e) f24818n.get(lVar);
        if (enumC3021e == null) {
            a(6);
        }
        return enumC3021e;
    }

    public static EnumC3021e g(String str) {
        if (str == null) {
            a(3);
        }
        EnumC3021e enumC3021e = (EnumC3021e) f24817m.get(str);
        if (enumC3021e != null) {
            return enumC3021e;
        }
        throw new AssertionError("Non-primitive type name passed: " + str);
    }

    public String i() {
        String str = this.f24825c;
        if (str == null) {
            a(14);
        }
        return str;
    }

    public String k() {
        String str = this.f24824b;
        if (str == null) {
            a(13);
        }
        return str;
    }

    public l l() {
        l lVar = this.f24823a;
        if (lVar == null) {
            a(12);
        }
        return lVar;
    }

    public q6.c m() {
        q6.c cVar = this.f24826d;
        if (cVar == null) {
            a(15);
        }
        return cVar;
    }
}
