package X1;

/* JADX INFO: renamed from: X1.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0752m implements InterfaceC0751l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0752m f5573b = new C0752m(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5574a;

    public C0752m(Object obj) {
        this.f5574a = obj;
    }

    public static InterfaceC0751l b(Object obj) {
        if (obj != null) {
            return new C0752m(obj);
        }
        throw new NullPointerException("instance cannot be null");
    }

    @Override // X1.o
    public final Object a() {
        return this.f5574a;
    }
}
