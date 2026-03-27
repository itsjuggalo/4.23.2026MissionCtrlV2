package r;

/* JADX INFO: loaded from: classes.dex */
public final class j extends h {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ k f9436l;

    public j(k kVar) {
        this.f9436l = kVar;
    }

    @Override // r.h
    public final String h() {
        i iVar = (i) this.f9436l.f9437a.get();
        if (iVar == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return "tag=[" + iVar.f9432a + "]";
    }
}
