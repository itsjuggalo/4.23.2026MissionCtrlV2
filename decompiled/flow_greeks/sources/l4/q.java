package l4;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements i4.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f15412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f15413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f15414c;

    public q(Set set, p pVar, t tVar) {
        this.f15412a = set;
        this.f15413b = pVar;
        this.f15414c = tVar;
    }

    @Override // i4.j
    public i4.i a(String str, Class cls, i4.h hVar) {
        return b(str, cls, i4.c.b("proto"), hVar);
    }

    @Override // i4.j
    public i4.i b(String str, Class cls, i4.c cVar, i4.h hVar) {
        if (this.f15412a.contains(cVar)) {
            return new s(this.f15413b, str, cVar, hVar, this.f15414c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", cVar, this.f15412a));
    }
}
