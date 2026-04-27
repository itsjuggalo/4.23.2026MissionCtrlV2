package i6;

import i6.AbstractC1965d;

/* JADX INFO: renamed from: i6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1959a implements B5.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1965d f18851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC1965d.a f18852b;

    public C1959a(AbstractC1965d abstractC1965d, AbstractC1965d.a aVar) {
        this.f18851a = abstractC1965d;
        this.f18852b = aVar;
    }

    @Override // B5.k
    public Object invoke(Object obj) {
        return Boolean.valueOf(AbstractC1965d.i(this.f18851a, this.f18852b, obj));
    }
}
