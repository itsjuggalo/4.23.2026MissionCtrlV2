package i9;

import i9.m;
import j9.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class w0 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f12189a = new a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap f12190a = new HashMap();

        public boolean a(j9.t tVar) {
            n9.b.d(tVar.u() % 2 == 1, "Expected a collection path.", new Object[0]);
            String strM = tVar.m();
            j9.t tVar2 = (j9.t) tVar.w();
            HashSet hashSet = (HashSet) this.f12190a.get(strM);
            if (hashSet == null) {
                hashSet = new HashSet();
                this.f12190a.put(strM, hashSet);
            }
            return hashSet.add(tVar2);
        }

        public List b(String str) {
            HashSet hashSet = (HashSet) this.f12190a.get(str);
            return hashSet != null ? new ArrayList(hashSet) : Collections.EMPTY_LIST;
        }
    }

    @Override // i9.m
    public m.a a(g9.g1 g1Var) {
        return m.a.NONE;
    }

    @Override // i9.m
    public p.a c(g9.g1 g1Var) {
        return p.a.f14250a;
    }

    @Override // i9.m
    public Collection e() {
        return Collections.EMPTY_LIST;
    }

    @Override // i9.m
    public String f() {
        return null;
    }

    @Override // i9.m
    public List g(String str) {
        return this.f12189a.b(str);
    }

    @Override // i9.m
    public p.a k(String str) {
        return p.a.f14250a;
    }

    @Override // i9.m
    public void l(j9.t tVar) {
        this.f12189a.a(tVar);
    }

    @Override // i9.m
    public List m(g9.g1 g1Var) {
        return null;
    }

    @Override // i9.m
    public void i() {
    }

    @Override // i9.m
    public void start() {
    }

    @Override // i9.m
    public void b(j9.p pVar) {
    }

    @Override // i9.m
    public void d(j9.p pVar) {
    }

    @Override // i9.m
    public void h(g8.c cVar) {
    }

    @Override // i9.m
    public void n(g9.g1 g1Var) {
    }

    @Override // i9.m
    public void j(String str, p.a aVar) {
    }
}
