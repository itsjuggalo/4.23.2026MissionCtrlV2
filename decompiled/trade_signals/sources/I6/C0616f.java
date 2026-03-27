package I6;

import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: I6.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0616f implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0 f4418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final M6.p f4419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final M6.j f4420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final M6.j f4421d;

    public C0616f(u0 u0Var, M6.p pVar, M6.j jVar, M6.j jVar2) {
        this.f4418a = u0Var;
        this.f4419b = pVar;
        this.f4420c = jVar;
        this.f4421d = jVar2;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return Boolean.valueOf(C0618g.y(this.f4418a, this.f4419b, this.f4420c, this.f4421d));
    }
}
