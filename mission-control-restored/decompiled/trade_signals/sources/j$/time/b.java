package j$.time;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    protected b() {
    }

    public static b c() {
        return new a(ZoneId.systemDefault());
    }

    public static b d() {
        return a.f19664b;
    }

    public abstract ZoneId a();

    public abstract long b();
}
