package M2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class F implements InterfaceC0701d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f5276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f5277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f5278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f5279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f5280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f5281f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InterfaceC0701d f5282g;

    public static class a implements A3.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f5283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final A3.c f5284b;

        public a(Set set, A3.c cVar) {
            this.f5283a = set;
            this.f5284b = cVar;
        }

        @Override // A3.c
        public void d(A3.a aVar) {
            if (!this.f5283a.contains(aVar.b())) {
                throw new s(String.format("Attempting to publish an undeclared event %s.", aVar));
            }
            this.f5284b.d(aVar);
        }
    }

    public F(C0700c c0700c, InterfaceC0701d interfaceC0701d) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (q qVar : c0700c.g()) {
            if (qVar.e()) {
                boolean zG = qVar.g();
                E eC = qVar.c();
                if (zG) {
                    hashSet4.add(eC);
                } else {
                    hashSet.add(eC);
                }
            } else if (qVar.d()) {
                hashSet3.add(qVar.c());
            } else {
                boolean zG2 = qVar.g();
                E eC2 = qVar.c();
                if (zG2) {
                    hashSet5.add(eC2);
                } else {
                    hashSet2.add(eC2);
                }
            }
        }
        if (!c0700c.k().isEmpty()) {
            hashSet.add(E.b(A3.c.class));
        }
        this.f5276a = Collections.unmodifiableSet(hashSet);
        this.f5277b = Collections.unmodifiableSet(hashSet2);
        this.f5278c = Collections.unmodifiableSet(hashSet3);
        this.f5279d = Collections.unmodifiableSet(hashSet4);
        this.f5280e = Collections.unmodifiableSet(hashSet5);
        this.f5281f = c0700c.k();
        this.f5282g = interfaceC0701d;
    }

    @Override // M2.InterfaceC0701d
    public S3.a a(E e8) {
        if (this.f5278c.contains(e8)) {
            return this.f5282g.a(e8);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Deferred<%s>.", e8));
    }

    @Override // M2.InterfaceC0701d
    public Set b(E e8) {
        if (this.f5279d.contains(e8)) {
            return this.f5282g.b(e8);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Set<%s>.", e8));
    }

    @Override // M2.InterfaceC0701d
    public S3.b c(Class cls) {
        return f(E.b(cls));
    }

    @Override // M2.InterfaceC0701d
    public Object d(E e8) {
        if (this.f5276a.contains(e8)) {
            return this.f5282g.d(e8);
        }
        throw new s(String.format("Attempting to request an undeclared dependency %s.", e8));
    }

    @Override // M2.InterfaceC0701d
    public S3.b e(E e8) {
        if (this.f5280e.contains(e8)) {
            return this.f5282g.e(e8);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", e8));
    }

    @Override // M2.InterfaceC0701d
    public S3.b f(E e8) {
        if (this.f5277b.contains(e8)) {
            return this.f5282g.f(e8);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Provider<%s>.", e8));
    }

    @Override // M2.InterfaceC0701d
    public Object get(Class cls) {
        if (!this.f5276a.contains(E.b(cls))) {
            throw new s(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        Object obj = this.f5282g.get(cls);
        return !cls.equals(A3.c.class) ? obj : new a(this.f5281f, (A3.c) obj);
    }

    @Override // M2.InterfaceC0701d
    public S3.a h(Class cls) {
        return a(E.b(cls));
    }
}
