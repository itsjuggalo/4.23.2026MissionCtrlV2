package b3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import z3.C2889a;
import z3.InterfaceC2891c;

/* JADX INFO: renamed from: b3.F, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0983F implements InterfaceC0987d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f8509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f8510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f8511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f8512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f8513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f8514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InterfaceC0987d f8515g;

    /* JADX INFO: renamed from: b3.F$a */
    public static class a implements InterfaceC2891c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f8516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC2891c f8517b;

        public a(Set set, InterfaceC2891c interfaceC2891c) {
            this.f8516a = set;
            this.f8517b = interfaceC2891c;
        }

        @Override // z3.InterfaceC2891c
        public void c(C2889a c2889a) {
            if (!this.f8516a.contains(c2889a.b())) {
                throw new s(String.format("Attempting to publish an undeclared event %s.", c2889a));
            }
            this.f8517b.c(c2889a);
        }
    }

    public C0983F(C0986c c0986c, InterfaceC0987d interfaceC0987d) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (q qVar : c0986c.g()) {
            if (qVar.e()) {
                if (qVar.g()) {
                    hashSet4.add(qVar.c());
                } else {
                    hashSet.add(qVar.c());
                }
            } else if (qVar.d()) {
                hashSet3.add(qVar.c());
            } else if (qVar.g()) {
                hashSet5.add(qVar.c());
            } else {
                hashSet2.add(qVar.c());
            }
        }
        if (!c0986c.k().isEmpty()) {
            hashSet.add(C0982E.b(InterfaceC2891c.class));
        }
        this.f8509a = Collections.unmodifiableSet(hashSet);
        this.f8510b = Collections.unmodifiableSet(hashSet2);
        this.f8511c = Collections.unmodifiableSet(hashSet3);
        this.f8512d = Collections.unmodifiableSet(hashSet4);
        this.f8513e = Collections.unmodifiableSet(hashSet5);
        this.f8514f = c0986c.k();
        this.f8515g = interfaceC0987d;
    }

    @Override // b3.InterfaceC0987d
    public Object a(Class cls) {
        if (!this.f8509a.contains(C0982E.b(cls))) {
            throw new s(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        Object objA = this.f8515g.a(cls);
        return !cls.equals(InterfaceC2891c.class) ? objA : new a(this.f8514f, (InterfaceC2891c) objA);
    }

    @Override // b3.InterfaceC0987d
    public N3.a b(C0982E c0982e) {
        if (this.f8511c.contains(c0982e)) {
            return this.f8515g.b(c0982e);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Deferred<%s>.", c0982e));
    }

    @Override // b3.InterfaceC0987d
    public Set c(C0982E c0982e) {
        if (this.f8512d.contains(c0982e)) {
            return this.f8515g.c(c0982e);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Set<%s>.", c0982e));
    }

    @Override // b3.InterfaceC0987d
    public N3.b d(Class cls) {
        return h(C0982E.b(cls));
    }

    @Override // b3.InterfaceC0987d
    public Object e(C0982E c0982e) {
        if (this.f8509a.contains(c0982e)) {
            return this.f8515g.e(c0982e);
        }
        throw new s(String.format("Attempting to request an undeclared dependency %s.", c0982e));
    }

    @Override // b3.InterfaceC0987d
    public N3.b g(C0982E c0982e) {
        if (this.f8513e.contains(c0982e)) {
            return this.f8515g.g(c0982e);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", c0982e));
    }

    @Override // b3.InterfaceC0987d
    public N3.b h(C0982E c0982e) {
        if (this.f8510b.contains(c0982e)) {
            return this.f8515g.h(c0982e);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Provider<%s>.", c0982e));
    }

    @Override // b3.InterfaceC0987d
    public N3.a i(Class cls) {
        return b(C0982E.b(cls));
    }
}
