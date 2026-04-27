package O5;

import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import p5.S;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f6057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f6058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l f6059g = new l("BOOLEAN", 0, "Boolean");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l f6060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final l f6061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final l f6062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final l f6063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final l f6064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final l f6065m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final l f6066n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ l[] f6067o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f6068p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q6.f f6069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q6.f f6070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2483k f6071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2483k f6072d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        l lVar = new l("CHAR", 1, "Char");
        f6060h = lVar;
        l lVar2 = new l("BYTE", 2, "Byte");
        f6061i = lVar2;
        l lVar3 = new l("SHORT", 3, "Short");
        f6062j = lVar3;
        l lVar4 = new l("INT", 4, "Int");
        f6063k = lVar4;
        l lVar5 = new l("FLOAT", 5, "Float");
        f6064l = lVar5;
        l lVar6 = new l("LONG", 6, "Long");
        f6065m = lVar6;
        l lVar7 = new l("DOUBLE", 7, "Double");
        f6066n = lVar7;
        l[] lVarArrA = a();
        f6067o = lVarArrA;
        f6068p = AbstractC2875b.a(lVarArrA);
        f6057e = new a(null);
        f6058f = S.h(lVar, lVar2, lVar3, lVar4, lVar5, lVar6, lVar7);
    }

    public l(String str, int i8, String str2) {
        q6.f fVarL = q6.f.l(str2);
        AbstractC2304t.e(fVarL, "identifier(...)");
        this.f6069a = fVarL;
        q6.f fVarL2 = q6.f.l(str2 + "Array");
        AbstractC2304t.e(fVarL2, "identifier(...)");
        this.f6070b = fVarL2;
        EnumC2486n enumC2486n = EnumC2486n.f21975b;
        this.f6071c = AbstractC2484l.b(enumC2486n, new j(this));
        this.f6072d = AbstractC2484l.b(enumC2486n, new k(this));
    }

    public static final /* synthetic */ l[] a() {
        return new l[]{f6059g, f6060h, f6061i, f6062j, f6063k, f6064l, f6065m, f6066n};
    }

    public static final q6.c i(l lVar) {
        return o.f6087A.b(lVar.f6070b);
    }

    public static final q6.c q(l lVar) {
        return o.f6087A.b(lVar.f6069a);
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f6067o.clone();
    }

    public final q6.c k() {
        return (q6.c) this.f6072d.getValue();
    }

    public final q6.f l() {
        return this.f6070b;
    }

    public final q6.c m() {
        return (q6.c) this.f6071c.getValue();
    }

    public final q6.f n() {
        return this.f6069a;
    }
}
