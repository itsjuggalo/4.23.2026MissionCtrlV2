package m3;

import h3.AbstractC1872h;
import h3.C1875k;

/* JADX INFO: renamed from: m3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2375b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1875k f21401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC1872h f21402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c3.c f21403c;

    public C2375b(AbstractC1872h abstractC1872h, c3.c cVar, C1875k c1875k) {
        this.f21402b = abstractC1872h;
        this.f21401a = c1875k;
        this.f21403c = cVar;
    }

    @Override // m3.e
    public void a() {
        this.f21402b.c(this.f21403c);
    }

    public C1875k b() {
        return this.f21401a;
    }

    @Override // m3.e
    public String toString() {
        return b() + ":CANCEL";
    }
}
