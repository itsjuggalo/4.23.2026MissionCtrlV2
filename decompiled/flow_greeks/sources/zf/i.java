package zf;

import dd.r;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.t;
import xf.c1;
import xf.q1;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends c1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u1 f26490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qf.k f26491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f26492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f26493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f26494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String[] f26495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f26496h;

    public /* synthetic */ i(u1 u1Var, qf.k kVar, k kVar2, List list, boolean z10, String[] strArr, int i10, kotlin.jvm.internal.k kVar3) {
        this(u1Var, kVar, kVar2, (i10 & 8) != 0 ? r.k() : list, (i10 & 16) != 0 ? false : z10, strArr);
    }

    @Override // xf.r0
    public List L0() {
        return this.f26493e;
    }

    @Override // xf.r0
    public q1 M0() {
        return q1.f25042b.k();
    }

    @Override // xf.r0
    public u1 N0() {
        return this.f26490b;
    }

    @Override // xf.r0
    public boolean O0() {
        return this.f26494f;
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: U0 */
    public c1 R0(boolean z10) {
        u1 u1VarN0 = N0();
        qf.k kVarQ = q();
        k kVar = this.f26492d;
        List listL0 = L0();
        String[] strArr = this.f26495g;
        return new i(u1VarN0, kVarQ, kVar, listL0, z10, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: V0 */
    public c1 T0(q1 newAttributes) {
        t.f(newAttributes, "newAttributes");
        return this;
    }

    public final String W0() {
        return this.f26496h;
    }

    public final k X0() {
        return this.f26492d;
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public i X0(yf.g kotlinTypeRefiner) {
        t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public final i Z0(List newArguments) {
        t.f(newArguments, "newArguments");
        u1 u1VarN0 = N0();
        qf.k kVarQ = q();
        k kVar = this.f26492d;
        boolean zO0 = O0();
        String[] strArr = this.f26495g;
        return new i(u1VarN0, kVarQ, kVar, newArguments, zO0, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // xf.r0
    public qf.k q() {
        return this.f26491c;
    }

    public i(u1 constructor, qf.k memberScope, k kind, List arguments, boolean z10, String... formatParams) {
        t.f(constructor, "constructor");
        t.f(memberScope, "memberScope");
        t.f(kind, "kind");
        t.f(arguments, "arguments");
        t.f(formatParams, "formatParams");
        this.f26490b = constructor;
        this.f26491c = memberScope;
        this.f26492d = kind;
        this.f26493e = arguments;
        this.f26494f = z10;
        this.f26495g = formatParams;
        s0 s0Var = s0.f14953a;
        String strB = kind.b();
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        String str = String.format(strB, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        t.e(str, "format(...)");
        this.f26496h = str;
    }
}
