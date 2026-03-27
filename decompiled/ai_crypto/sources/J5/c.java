package J5;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements H5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f3330a = new c();

    @Override // H5.d
    public H5.g getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // H5.d
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
