package I6;

import I6.u0;
import java.util.Collection;

/* JADX INFO: renamed from: I6.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0614e implements B5.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Collection f4409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u0 f4410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final M6.p f4411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final M6.j f4412d;

    public C0614e(Collection collection, u0 u0Var, M6.p pVar, M6.j jVar) {
        this.f4409a = collection;
        this.f4410b = u0Var;
        this.f4411c = pVar;
        this.f4412d = jVar;
    }

    @Override // B5.k
    public Object invoke(Object obj) {
        return C0618g.x(this.f4409a, this.f4410b, this.f4411c, this.f4412d, (u0.a) obj);
    }
}
