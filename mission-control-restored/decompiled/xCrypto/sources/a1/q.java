package a1;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class q implements X0.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f6098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f6099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f6100c;

    public q(Set set, p pVar, t tVar) {
        this.f6098a = set;
        this.f6099b = pVar;
        this.f6100c = tVar;
    }

    @Override // X0.j
    public X0.i a(String str, Class cls, X0.c cVar, X0.h hVar) {
        if (this.f6098a.contains(cVar)) {
            return new s(this.f6099b, str, cVar, hVar, this.f6100c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", cVar, this.f6098a));
    }
}
