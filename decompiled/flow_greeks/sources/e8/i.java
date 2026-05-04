package e8;

import j8.b0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f8494a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.g f8495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f8496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0 f8497d;

    public i(a7.g gVar, fa.a aVar, fa.a aVar2) {
        this.f8495b = gVar;
        this.f8496c = new f8.n(aVar);
        this.f8497d = new f8.g(aVar2);
    }

    public synchronized h a(j8.q qVar) {
        h hVar;
        try {
            hVar = (h) this.f8494a.get(qVar);
            if (hVar == null) {
                j8.h hVar2 = new j8.h();
                if (!this.f8495b.y()) {
                    hVar2.N(this.f8495b.q());
                }
                hVar2.J(this.f8495b);
                hVar2.I(this.f8496c);
                hVar2.H(this.f8497d);
                h hVar3 = new h(this.f8495b, qVar, hVar2);
                this.f8494a.put(qVar, hVar3);
                hVar = hVar3;
            }
        } catch (Throwable th) {
            throw th;
        }
        return hVar;
    }
}
