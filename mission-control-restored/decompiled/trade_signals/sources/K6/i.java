package K6;

import I6.AbstractC0613d0;
import I6.r0;
import I6.v0;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.U;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends AbstractC0613d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v0 f4815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B6.k f4816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f4817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f4818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String[] f4820g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f4821h;

    public i(v0 constructor, B6.k memberScope, k kind, List arguments, boolean z7, String... formatParams) {
        AbstractC2304t.f(constructor, "constructor");
        AbstractC2304t.f(memberScope, "memberScope");
        AbstractC2304t.f(kind, "kind");
        AbstractC2304t.f(arguments, "arguments");
        AbstractC2304t.f(formatParams, "formatParams");
        this.f4815b = constructor;
        this.f4816c = memberScope;
        this.f4817d = kind;
        this.f4818e = arguments;
        this.f4819f = z7;
        this.f4820g = formatParams;
        U u8 = U.f20474a;
        String strB = kind.b();
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        String str = String.format(strB, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        AbstractC2304t.e(str, "format(...)");
        this.f4821h = str;
    }

    @Override // I6.S
    public List M0() {
        return this.f4818e;
    }

    @Override // I6.S
    public r0 N0() {
        return r0.f4460b.k();
    }

    @Override // I6.S
    public v0 O0() {
        return this.f4815b;
    }

    @Override // I6.S
    public boolean P0() {
        return this.f4819f;
    }

    @Override // I6.M0
    /* JADX INFO: renamed from: V0 */
    public AbstractC0613d0 S0(boolean z7) {
        v0 v0VarO0 = O0();
        B6.k kVarR = r();
        k kVar = this.f4817d;
        List listM0 = M0();
        String[] strArr = this.f4820g;
        return new i(v0VarO0, kVarR, kVar, listM0, z7, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // I6.M0
    /* JADX INFO: renamed from: W0 */
    public AbstractC0613d0 U0(r0 newAttributes) {
        AbstractC2304t.f(newAttributes, "newAttributes");
        return this;
    }

    public final String X0() {
        return this.f4821h;
    }

    public final k Y0() {
        return this.f4817d;
    }

    @Override // I6.M0
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public i Y0(J6.g kotlinTypeRefiner) {
        AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public final i a1(List newArguments) {
        AbstractC2304t.f(newArguments, "newArguments");
        v0 v0VarO0 = O0();
        B6.k kVarR = r();
        k kVar = this.f4817d;
        boolean zP0 = P0();
        String[] strArr = this.f4820g;
        return new i(v0VarO0, kVarR, kVar, newArguments, zP0, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // I6.S
    public B6.k r() {
        return this.f4816c;
    }

    public /* synthetic */ i(v0 v0Var, B6.k kVar, k kVar2, List list, boolean z7, String[] strArr, int i8, AbstractC2296k abstractC2296k) {
        this(v0Var, kVar, kVar2, (i8 & 8) != 0 ? AbstractC2595q.i() : list, (i8 & 16) != 0 ? false : z7, strArr);
    }
}
