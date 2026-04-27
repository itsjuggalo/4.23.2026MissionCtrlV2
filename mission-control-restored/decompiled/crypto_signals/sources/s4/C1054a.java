package s4;

/* JADX INFO: renamed from: s4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1054a extends Throwable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9699c;

    public C1054a(String str, String str2, String str3) {
        this.f9697a = str;
        this.f9698b = str2;
        this.f9699c = str3;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f9698b;
    }
}
