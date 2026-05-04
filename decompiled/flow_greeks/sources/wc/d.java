package wc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public enum d implements lc.f {
    INSTANCE;

    public static void a(kh.b bVar) {
        bVar.b(INSTANCE);
        bVar.onComplete();
    }

    public static void b(Throwable th, kh.b bVar) {
        bVar.b(INSTANCE);
        bVar.onError(th);
    }

    @Override // lc.e
    public int h(int i10) {
        return i10 & 2;
    }

    @Override // lc.i
    public boolean isEmpty() {
        return true;
    }

    @Override // lc.i
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // lc.i
    public Object poll() {
        return null;
    }

    @Override // kh.c
    public void request(long j10) {
        g.l(j10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    @Override // kh.c
    public void cancel() {
    }

    @Override // lc.i
    public void clear() {
    }
}
