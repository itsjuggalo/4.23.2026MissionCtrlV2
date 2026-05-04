package o8;

import o8.e;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e.a f17607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r8.i f17608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r8.i f17609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r8.b f17610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r8.b f17611e;

    public c(e.a aVar, r8.i iVar, r8.b bVar, r8.b bVar2, r8.i iVar2) {
        this.f17607a = aVar;
        this.f17608b = iVar;
        this.f17610d = bVar;
        this.f17611e = bVar2;
        this.f17609c = iVar2;
    }

    public static c b(r8.b bVar, r8.i iVar) {
        return new c(e.a.CHILD_ADDED, iVar, bVar, null, null);
    }

    public static c c(r8.b bVar, n nVar) {
        return b(bVar, r8.i.c(nVar));
    }

    public static c d(r8.b bVar, r8.i iVar, r8.i iVar2) {
        return new c(e.a.CHILD_CHANGED, iVar, bVar, null, iVar2);
    }

    public static c e(r8.b bVar, n nVar, n nVar2) {
        return d(bVar, r8.i.c(nVar), r8.i.c(nVar2));
    }

    public static c f(r8.b bVar, r8.i iVar) {
        return new c(e.a.CHILD_MOVED, iVar, bVar, null, null);
    }

    public static c g(r8.b bVar, r8.i iVar) {
        return new c(e.a.CHILD_REMOVED, iVar, bVar, null, null);
    }

    public static c h(r8.b bVar, n nVar) {
        return g(bVar, r8.i.c(nVar));
    }

    public static c n(r8.i iVar) {
        return new c(e.a.VALUE, iVar, null, null, null);
    }

    public c a(r8.b bVar) {
        return new c(this.f17607a, this.f17608b, this.f17610d, bVar, this.f17609c);
    }

    public r8.b i() {
        return this.f17610d;
    }

    public e.a j() {
        return this.f17607a;
    }

    public r8.i k() {
        return this.f17608b;
    }

    public r8.i l() {
        return this.f17609c;
    }

    public r8.b m() {
        return this.f17611e;
    }

    public String toString() {
        return "Change: " + this.f17607a + " " + this.f17610d;
    }
}
