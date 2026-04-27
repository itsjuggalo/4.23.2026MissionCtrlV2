package e6;

/* JADX INFO: renamed from: e6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1699a implements B5.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1700b f17263a;

    public C1699a(C1700b c1700b) {
        this.f17263a = c1700b;
    }

    @Override // B5.k
    public Object invoke(Object obj) {
        return Boolean.valueOf(C1700b.h(this.f17263a, (h6.r) obj));
    }
}
