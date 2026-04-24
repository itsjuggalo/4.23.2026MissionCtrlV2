package i6;

/* JADX INFO: renamed from: i6.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1961b implements B5.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1994r0 f18854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1973h[] f18855b;

    public C1961b(C1994r0 c1994r0, C1973h[] c1973hArr) {
        this.f18854a = c1994r0;
        this.f18855b = c1973hArr;
    }

    @Override // B5.k
    public Object invoke(Object obj) {
        return AbstractC1965d.e(this.f18854a, this.f18855b, ((Number) obj).intValue());
    }
}
