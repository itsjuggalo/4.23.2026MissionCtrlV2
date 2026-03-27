package i6;

import i6.AbstractC1965d;

/* JADX INFO: renamed from: i6.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1963c implements B5.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1965d f18857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final M6.p f18858b;

    public C1963c(AbstractC1965d abstractC1965d, M6.p pVar) {
        this.f18857a = abstractC1965d;
        this.f18858b = pVar;
    }

    @Override // B5.k
    public Object invoke(Object obj) {
        return AbstractC1965d.I(this.f18857a, this.f18858b, (AbstractC1965d.a) obj);
    }
}
