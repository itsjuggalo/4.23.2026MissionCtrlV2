package vf;

import kotlin.jvm.functions.Function0;
import vf.w;

/* JADX INFO: loaded from: classes3.dex */
public class g0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w.b f23423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f23424b;

    public g0(w.b bVar, w wVar) {
        this.f23423a = bVar;
        this.f23424b = wVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return w.b.P(this.f23423a, this.f23424b);
    }
}
