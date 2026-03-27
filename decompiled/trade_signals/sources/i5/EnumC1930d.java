package i5;

/* JADX INFO: renamed from: i5.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public enum EnumC1930d implements Y4.g {
    INSTANCE;

    public static void a(x7.b bVar) {
        bVar.d(INSTANCE);
        bVar.a();
    }

    public static void b(Throwable th, x7.b bVar) {
        bVar.d(INSTANCE);
        bVar.onError(th);
    }

    @Override // x7.c
    public void i(long j8) {
        EnumC1933g.n(j8);
    }

    @Override // Y4.j
    public boolean isEmpty() {
        return true;
    }

    @Override // Y4.f
    public int k(int i8) {
        return i8 & 2;
    }

    @Override // Y4.j
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // Y4.j
    public Object poll() {
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    @Override // x7.c
    public void cancel() {
    }

    @Override // Y4.j
    public void clear() {
    }
}
