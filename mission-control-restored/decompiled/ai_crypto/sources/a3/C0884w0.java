package a3;

/* JADX INFO: renamed from: a3.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0884w0 extends AbstractC0876s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6290c;

    @Override // a3.AbstractC0876s0
    public final AbstractC0876s0 a(String str) {
        this.f6289b = str;
        return this;
    }

    @Override // a3.AbstractC0876s0
    public final AbstractC0878t0 b() {
        return new C0886x0(this.f6288a, this.f6289b, this.f6290c);
    }

    @Override // a3.AbstractC0876s0
    public final AbstractC0876s0 c(String str) {
        this.f6290c = str;
        return this;
    }

    @Override // a3.AbstractC0876s0
    public final AbstractC0876s0 d(String str) {
        this.f6288a = str;
        return this;
    }
}
