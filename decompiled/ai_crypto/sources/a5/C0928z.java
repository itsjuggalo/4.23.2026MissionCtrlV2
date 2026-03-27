package a5;

/* JADX INFO: renamed from: a5.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0928z extends Throwable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6399c;

    public C0928z(String code, String str, Object obj) {
        kotlin.jvm.internal.r.f(code, "code");
        this.f6397a = code;
        this.f6398b = str;
        this.f6399c = obj;
    }

    public final String a() {
        return this.f6397a;
    }

    public final Object b() {
        return this.f6399c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f6398b;
    }
}
