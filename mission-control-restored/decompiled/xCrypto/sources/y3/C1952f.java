package y3;

/* JADX INFO: renamed from: y3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1952f implements t3.L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z2.i f15980a;

    public C1952f(Z2.i iVar) {
        this.f15980a = iVar;
    }

    @Override // t3.L
    public Z2.i l() {
        return this.f15980a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + l() + ')';
    }
}
