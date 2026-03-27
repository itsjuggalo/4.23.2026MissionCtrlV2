package S;

/* JADX INFO: loaded from: classes.dex */
public final class r extends D {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f3818b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Throwable finalException) {
        super(Integer.MAX_VALUE, null);
        kotlin.jvm.internal.r.f(finalException, "finalException");
        this.f3818b = finalException;
    }

    public final Throwable b() {
        return this.f3818b;
    }
}
