package r;

/* JADX INFO: renamed from: r.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0959b extends Throwable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9412a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0959b(String str, int i) {
        super(str);
        this.f9412a = i;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        int i = this.f9412a;
        synchronized (this) {
            switch (i) {
            }
            return this;
        }
    }
}
