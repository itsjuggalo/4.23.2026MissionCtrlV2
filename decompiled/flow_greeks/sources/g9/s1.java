package g9;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j9.s f10365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k9.d f10366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f10367c;

    public s1(j9.s sVar, k9.d dVar, List list) {
        this.f10365a = sVar;
        this.f10366b = dVar;
        this.f10367c = list;
    }

    public k9.f a(j9.k kVar, k9.m mVar) {
        k9.d dVar = this.f10366b;
        return dVar != null ? new k9.l(kVar, this.f10365a, dVar, mVar, this.f10367c) : new k9.o(kVar, this.f10365a, mVar, this.f10367c);
    }
}
