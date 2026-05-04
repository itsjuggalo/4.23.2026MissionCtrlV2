package zd;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public class s2 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t2 f25829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f25830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cd.k f25831c;

    public s2(t2 t2Var, int i10, cd.k kVar) {
        this.f25829a = t2Var;
        this.f25830b = i10;
        this.f25831c = kVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return t2.u(this.f25829a, this.f25830b, this.f25831c);
    }
}
