package p5;

/* JADX INFO: renamed from: p5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2379a extends Throwable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f21803c;

    public C2379a(String code, String str, Object obj) {
        kotlin.jvm.internal.r.f(code, "code");
        this.f21801a = code;
        this.f21802b = str;
        this.f21803c = obj;
    }

    public final String a() {
        return this.f21801a;
    }

    public final Object b() {
        return this.f21803c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f21802b;
    }
}
