package P3;

/* JADX INFO: loaded from: classes.dex */
public final class T implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6384a;

    public T(S s8) {
        this.f6384a = s8;
    }

    public static T a(S s8) {
        return new T(s8);
    }

    public static Q3.a c(S s8) {
        return (Q3.a) E3.d.e(s8.a());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Q3.a get() {
        return c(this.f6384a);
    }
}
