package l2;

/* JADX INFO: renamed from: l2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2320d extends IllegalStateException {
    public C2320d(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException a(AbstractC2328l abstractC2328l) {
        if (!abstractC2328l.n()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception excJ = abstractC2328l.j();
        return new C2320d("Complete with: ".concat(excJ != null ? "failure" : abstractC2328l.o() ? "result ".concat(String.valueOf(abstractC2328l.k())) : abstractC2328l.m() ? "cancellation" : "unknown issue"), excJ);
    }
}
