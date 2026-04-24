package j3;

import h3.C1866b;
import h3.C1875k;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import k3.AbstractC2279m;
import m3.C2374a;
import p3.C2553g;
import p3.C2555i;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: j3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2211d implements InterfaceC2212e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20005a = false;

    @Override // j3.InterfaceC2212e
    public void a() {
        q();
    }

    @Override // j3.InterfaceC2212e
    public void b(long j8) {
        q();
    }

    @Override // j3.InterfaceC2212e
    public void c(C1875k c1875k, InterfaceC2560n interfaceC2560n, long j8) {
        q();
    }

    @Override // j3.InterfaceC2212e
    public void d(C1875k c1875k, C1866b c1866b, long j8) {
        q();
    }

    @Override // j3.InterfaceC2212e
    public List e() {
        return Collections.emptyList();
    }

    @Override // j3.InterfaceC2212e
    public void f(m3.i iVar, Set set) {
        q();
    }

    @Override // j3.InterfaceC2212e
    public void g(m3.i iVar, InterfaceC2560n interfaceC2560n) {
        q();
    }

    @Override // j3.InterfaceC2212e
    public void h(m3.i iVar) {
        q();
    }

    @Override // j3.InterfaceC2212e
    public C2374a i(m3.i iVar) {
        return new C2374a(C2555i.e(C2553g.M(), iVar.c()), false, false);
    }

    @Override // j3.InterfaceC2212e
    public Object j(Callable callable) {
        AbstractC2279m.g(!this.f20005a, "runInTransaction called when an existing transaction is already in progress.");
        this.f20005a = true;
        try {
            return callable.call();
        } finally {
        }
    }

    @Override // j3.InterfaceC2212e
    public void k(m3.i iVar) {
        q();
    }

    @Override // j3.InterfaceC2212e
    public void l(C1875k c1875k, InterfaceC2560n interfaceC2560n) {
        q();
    }

    @Override // j3.InterfaceC2212e
    public void m(C1875k c1875k, C1866b c1866b) {
        q();
    }

    @Override // j3.InterfaceC2212e
    public void n(C1875k c1875k, C1866b c1866b) {
        q();
    }

    @Override // j3.InterfaceC2212e
    public void o(m3.i iVar, Set set, Set set2) {
        q();
    }

    @Override // j3.InterfaceC2212e
    public void p(m3.i iVar) {
        q();
    }

    public final void q() {
        AbstractC2279m.g(this.f20005a, "Transaction expected to already be in progress.");
    }
}
