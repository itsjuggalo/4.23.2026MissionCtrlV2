package l1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends i0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f15000b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(Throwable readException, int i10) {
        super(i10, null);
        kotlin.jvm.internal.t.f(readException, "readException");
        this.f15000b = readException;
    }

    public final Throwable b() {
        return this.f15000b;
    }
}
