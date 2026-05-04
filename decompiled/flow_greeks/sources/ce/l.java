package ce;

import dd.u0;
import java.util.Set;
import kotlin.jvm.internal.t;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f3917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f3918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l f3919g = new l("BOOLEAN", 0, "Boolean");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l f3920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final l f3921i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final l f3922j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final l f3923k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final l f3924l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final l f3925m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final l f3926n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ l[] f3927o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ jd.a f3928p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ef.f f3929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ef.f f3930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cd.k f3931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final cd.k f3932d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    static {
        l lVar = new l("CHAR", 1, "Char");
        f3920h = lVar;
        l lVar2 = new l("BYTE", 2, "Byte");
        f3921i = lVar2;
        l lVar3 = new l("SHORT", 3, "Short");
        f3922j = lVar3;
        l lVar4 = new l("INT", 4, "Int");
        f3923k = lVar4;
        l lVar5 = new l("FLOAT", 5, "Float");
        f3924l = lVar5;
        l lVar6 = new l("LONG", 6, "Long");
        f3925m = lVar6;
        l lVar7 = new l("DOUBLE", 7, "Double");
        f3926n = lVar7;
        l[] lVarArrA = a();
        f3927o = lVarArrA;
        f3928p = jd.b.a(lVarArrA);
        f3917e = new a(null);
        f3918f = u0.h(lVar, lVar2, lVar3, lVar4, lVar5, lVar6, lVar7);
    }

    public l(String str, int i10, String str2) {
        ef.f fVarK = ef.f.k(str2);
        t.e(fVarK, "identifier(...)");
        this.f3929a = fVarK;
        ef.f fVarK2 = ef.f.k(str2 + "Array");
        t.e(fVarK2, "identifier(...)");
        this.f3930b = fVarK2;
        cd.n nVar = cd.n.f3864b;
        this.f3931c = cd.l.a(nVar, new j(this));
        this.f3932d = cd.l.a(nVar, new k(this));
    }

    public static final /* synthetic */ l[] a() {
        return new l[]{f3919g, f3920h, f3921i, f3922j, f3923k, f3924l, f3925m, f3926n};
    }

    public static final ef.c h(l lVar) {
        return o.A.b(lVar.f3930b);
    }

    public static final ef.c o(l lVar) {
        return o.A.b(lVar.f3929a);
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f3927o.clone();
    }

    public final ef.c i() {
        return (ef.c) this.f3932d.getValue();
    }

    public final ef.f k() {
        return this.f3930b;
    }

    public final ef.c l() {
        return (ef.c) this.f3931c.getValue();
    }

    public final ef.f m() {
        return this.f3929a;
    }
}
