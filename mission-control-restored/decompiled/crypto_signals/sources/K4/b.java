package K4;

/* JADX INFO: loaded from: classes.dex */
public final class b implements I4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1011a = new b();

    @Override // I4.d
    public final I4.i getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // I4.d
    public final void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}
