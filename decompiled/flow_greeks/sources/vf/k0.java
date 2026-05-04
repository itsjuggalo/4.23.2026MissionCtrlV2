package vf;

import kotlin.jvm.functions.Function0;
import vf.w;

/* JADX INFO: loaded from: classes3.dex */
public class k0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w.c f23432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f23433b;

    public k0(w.c cVar, w wVar) {
        this.f23432a = cVar;
        this.f23433b = wVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return w.c.p(this.f23432a, this.f23433b);
    }
}
