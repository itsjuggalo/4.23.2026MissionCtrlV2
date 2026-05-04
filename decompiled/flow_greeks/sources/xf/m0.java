package xf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m0 extends d2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fe.l1[] f25007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a2[] f25008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f25009e;

    public /* synthetic */ m0(fe.l1[] l1VarArr, a2[] a2VarArr, boolean z10, int i10, kotlin.jvm.internal.k kVar) {
        this(l1VarArr, a2VarArr, (i10 & 4) != 0 ? false : z10);
    }

    @Override // xf.d2
    public boolean b() {
        return this.f25009e;
    }

    @Override // xf.d2
    public a2 e(r0 key) {
        kotlin.jvm.internal.t.f(key, "key");
        fe.h hVarB = key.N0().b();
        fe.l1 l1Var = hVarB instanceof fe.l1 ? (fe.l1) hVarB : null;
        if (l1Var == null) {
            return null;
        }
        int index = l1Var.getIndex();
        fe.l1[] l1VarArr = this.f25007c;
        if (index >= l1VarArr.length || !kotlin.jvm.internal.t.b(l1VarArr[index].k(), l1Var.k())) {
            return null;
        }
        return this.f25008d[index];
    }

    @Override // xf.d2
    public boolean f() {
        return this.f25008d.length == 0;
    }

    public final a2[] i() {
        return this.f25008d;
    }

    public final fe.l1[] j() {
        return this.f25007c;
    }

    public m0(fe.l1[] parameters, a2[] arguments, boolean z10) {
        kotlin.jvm.internal.t.f(parameters, "parameters");
        kotlin.jvm.internal.t.f(arguments, "arguments");
        this.f25007c = parameters;
        this.f25008d = arguments;
        this.f25009e = z10;
        int length = parameters.length;
        int length2 = arguments.length;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m0(List parameters, List argumentsList) {
        this((fe.l1[]) parameters.toArray(new fe.l1[0]), (a2[]) argumentsList.toArray(new a2[0]), false, 4, null);
        kotlin.jvm.internal.t.f(parameters, "parameters");
        kotlin.jvm.internal.t.f(argumentsList, "argumentsList");
    }
}
