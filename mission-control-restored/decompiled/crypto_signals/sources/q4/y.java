package q4;

import O.C0197u;

/* JADX INFO: loaded from: classes.dex */
public final class y extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0197u f9394c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(C0197u c0197u, I4.d dVar) {
        super(dVar);
        this.f9394c = c0197u;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f9392a = obj;
        this.f9393b |= Integer.MIN_VALUE;
        return this.f9394c.c(null, this);
    }
}
