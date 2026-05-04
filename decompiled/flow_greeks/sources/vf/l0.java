package vf;

import kotlin.jvm.functions.Function0;
import vf.w;

/* JADX INFO: loaded from: classes3.dex */
public class l0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w.c f23435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f23436b;

    public l0(w.c cVar, w wVar) {
        this.f23435a = cVar;
        this.f23436b = wVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return w.c.u(this.f23435a, this.f23436b);
    }
}
