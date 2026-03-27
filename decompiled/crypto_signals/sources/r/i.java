package r;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f9432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f9433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f9434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9435d;

    public final void finalize() {
        l lVar;
        k kVar = this.f9433b;
        if (kVar != null) {
            j jVar = kVar.f9438b;
            if (!jVar.isDone()) {
                jVar.k(new C0959b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f9432a, 1));
            }
        }
        if (this.f9435d || (lVar = this.f9434c) == null) {
            return;
        }
        lVar.j(null);
    }
}
