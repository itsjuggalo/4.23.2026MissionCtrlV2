package xf;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public class f implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1 f24956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bg.p f24957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bg.j f24958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bg.j f24959d;

    public f(t1 t1Var, bg.p pVar, bg.j jVar, bg.j jVar2) {
        this.f24956a = t1Var;
        this.f24957b = pVar;
        this.f24958c = jVar;
        this.f24959d = jVar2;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return Boolean.valueOf(g.y(this.f24956a, this.f24957b, this.f24958c, this.f24959d));
    }
}
