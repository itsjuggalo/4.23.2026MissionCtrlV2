package Q;

import u5.r;
import u5.w;

/* JADX INFO: loaded from: classes.dex */
public final class i extends K4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f2636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f2637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f2638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f2639d;
    public final /* synthetic */ j e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2640f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, K4.c cVar) {
        super(cVar);
        this.e = jVar;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.f2639d = obj;
        this.f2640f |= Integer.MIN_VALUE;
        return this.e.a(null, this);
    }
}
