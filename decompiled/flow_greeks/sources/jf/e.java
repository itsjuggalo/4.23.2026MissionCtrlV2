package jf;

import xf.u1;
import yf.e;

/* JADX INFO: loaded from: classes3.dex */
public class e implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fe.a f14319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fe.a f14320c;

    public e(boolean z10, fe.a aVar, fe.a aVar2) {
        this.f14318a = z10;
        this.f14319b = aVar;
        this.f14320c = aVar2;
    }

    @Override // yf.e.a
    public boolean a(u1 u1Var, u1 u1Var2) {
        return g.h(this.f14318a, this.f14319b, this.f14320c, u1Var, u1Var2);
    }
}
