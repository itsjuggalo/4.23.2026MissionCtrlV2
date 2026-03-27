package I6;

import R5.InterfaceC0851h;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class M extends E0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final R5.m0[] f4366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final B0[] f4367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f4368e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public M(List parameters, List argumentsList) {
        this((R5.m0[]) parameters.toArray(new R5.m0[0]), (B0[]) argumentsList.toArray(new B0[0]), false, 4, null);
        AbstractC2304t.f(parameters, "parameters");
        AbstractC2304t.f(argumentsList, "argumentsList");
    }

    @Override // I6.E0
    public boolean b() {
        return this.f4368e;
    }

    @Override // I6.E0
    public B0 e(S key) {
        AbstractC2304t.f(key, "key");
        InterfaceC0851h interfaceC0851hS = key.O0().s();
        R5.m0 m0Var = interfaceC0851hS instanceof R5.m0 ? (R5.m0) interfaceC0851hS : null;
        if (m0Var == null) {
            return null;
        }
        int iG = m0Var.g();
        R5.m0[] m0VarArr = this.f4366c;
        if (iG >= m0VarArr.length || !AbstractC2304t.b(m0VarArr[iG].l(), m0Var.l())) {
            return null;
        }
        return this.f4367d[iG];
    }

    @Override // I6.E0
    public boolean f() {
        return this.f4367d.length == 0;
    }

    public final B0[] i() {
        return this.f4367d;
    }

    public final R5.m0[] j() {
        return this.f4366c;
    }

    public M(R5.m0[] parameters, B0[] arguments, boolean z7) {
        AbstractC2304t.f(parameters, "parameters");
        AbstractC2304t.f(arguments, "arguments");
        this.f4366c = parameters;
        this.f4367d = arguments;
        this.f4368e = z7;
        int length = parameters.length;
        int length2 = arguments.length;
    }

    public /* synthetic */ M(R5.m0[] m0VarArr, B0[] b0Arr, boolean z7, int i8, AbstractC2296k abstractC2296k) {
        this(m0VarArr, b0Arr, (i8 & 4) != 0 ? false : z7);
    }
}
