package l8;

import j8.l;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import m8.m;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15546a = false;

    @Override // l8.e
    public void a() {
        q();
    }

    @Override // l8.e
    public void b(long j10) {
        q();
    }

    @Override // l8.e
    public void c(l lVar, n nVar, long j10) {
        q();
    }

    @Override // l8.e
    public List d() {
        return Collections.EMPTY_LIST;
    }

    @Override // l8.e
    public void e(l lVar, j8.b bVar, long j10) {
        q();
    }

    @Override // l8.e
    public void f(l lVar, j8.b bVar) {
        q();
    }

    @Override // l8.e
    public void g(l lVar, j8.b bVar) {
        q();
    }

    @Override // l8.e
    public void h(o8.i iVar, Set set, Set set2) {
        q();
    }

    @Override // l8.e
    public o8.a i(o8.i iVar) {
        return new o8.a(r8.i.d(r8.g.y(), iVar.c()), false, false);
    }

    @Override // l8.e
    public void j(o8.i iVar, Set set) {
        q();
    }

    @Override // l8.e
    public void k(l lVar, n nVar) {
        q();
    }

    @Override // l8.e
    public void l(o8.i iVar) {
        q();
    }

    @Override // l8.e
    public Object m(Callable callable) {
        m.g(!this.f15546a, "runInTransaction called when an existing transaction is already in progress.");
        this.f15546a = true;
        try {
            return callable.call();
        } finally {
        }
    }

    @Override // l8.e
    public void n(o8.i iVar) {
        q();
    }

    @Override // l8.e
    public void o(o8.i iVar) {
        q();
    }

    @Override // l8.e
    public void p(o8.i iVar, n nVar) {
        q();
    }

    public final void q() {
        m.g(this.f15546a, "Transaction expected to already be in progress.");
    }
}
