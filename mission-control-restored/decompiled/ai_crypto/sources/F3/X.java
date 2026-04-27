package F3;

import F3.InterfaceC0513m;
import G3.p;
import K3.AbstractC0612b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class X implements InterfaceC0513m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2090a = new a();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap f2091a = new HashMap();

        public boolean a(G3.t tVar) {
            AbstractC0612b.d(tVar.q() % 2 == 1, "Expected a collection path.", new Object[0]);
            String strL = tVar.l();
            G3.t tVar2 = (G3.t) tVar.s();
            HashSet hashSet = (HashSet) this.f2091a.get(strL);
            if (hashSet == null) {
                hashSet = new HashSet();
                this.f2091a.put(strL, hashSet);
            }
            return hashSet.add(tVar2);
        }

        public List b(String str) {
            HashSet hashSet = (HashSet) this.f2091a.get(str);
            return hashSet != null ? new ArrayList(hashSet) : Collections.emptyList();
        }
    }

    @Override // F3.InterfaceC0513m
    public InterfaceC0513m.a a(D3.h0 h0Var) {
        return InterfaceC0513m.a.NONE;
    }

    @Override // F3.InterfaceC0513m
    public p.a b(D3.h0 h0Var) {
        return p.a.f2449a;
    }

    @Override // F3.InterfaceC0513m
    public Collection d() {
        return Collections.emptyList();
    }

    @Override // F3.InterfaceC0513m
    public String e() {
        return null;
    }

    @Override // F3.InterfaceC0513m
    public List f(String str) {
        return this.f2090a.b(str);
    }

    @Override // F3.InterfaceC0513m
    public List i(D3.h0 h0Var) {
        return null;
    }

    @Override // F3.InterfaceC0513m
    public p.a l(String str) {
        return p.a.f2449a;
    }

    @Override // F3.InterfaceC0513m
    public void n(G3.t tVar) {
        this.f2090a.a(tVar);
    }

    @Override // F3.InterfaceC0513m
    public void g() {
    }

    @Override // F3.InterfaceC0513m
    public void start() {
    }

    @Override // F3.InterfaceC0513m
    public void c(D3.h0 h0Var) {
    }

    @Override // F3.InterfaceC0513m
    public void h(r3.c cVar) {
    }

    @Override // F3.InterfaceC0513m
    public void k(G3.p pVar) {
    }

    @Override // F3.InterfaceC0513m
    public void m(G3.p pVar) {
    }

    @Override // F3.InterfaceC0513m
    public void j(String str, p.a aVar) {
    }
}
