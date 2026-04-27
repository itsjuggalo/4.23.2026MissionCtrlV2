package S;

/* JADX INFO: loaded from: classes.dex */
public final class x extends D {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f3823b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Throwable readException, int i4) {
        super(i4, null);
        kotlin.jvm.internal.r.f(readException, "readException");
        this.f3823b = readException;
    }

    public final Throwable b() {
        return this.f3823b;
    }
}
