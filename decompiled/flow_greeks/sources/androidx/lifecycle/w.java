package androidx.lifecycle;

import androidx.lifecycle.b;
import androidx.lifecycle.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class w implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.a f2485b;

    public w(Object obj) {
        this.f2484a = obj;
        this.f2485b = b.f2385c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.k
    public void b(m mVar, i.a aVar) {
        this.f2485b.a(mVar, aVar, this.f2484a);
    }
}
