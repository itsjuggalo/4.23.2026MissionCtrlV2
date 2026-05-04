package o7;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f17552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f17553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f17554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f17555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f17556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f17557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f17558g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements c9.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f17559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c9.c f17560b;

        public a(Set set, c9.c cVar) {
            this.f17559a = set;
            this.f17560b = cVar;
        }

        @Override // c9.c
        public void a(c9.a aVar) {
            if (!this.f17559a.contains(aVar.b())) {
                throw new s(String.format("Attempting to publish an undeclared event %s.", aVar));
            }
            this.f17560b.a(aVar);
        }
    }

    public f0(c cVar, d dVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (q qVar : cVar.g()) {
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
        if (!cVar.k().isEmpty()) {
            hashSet.add(e0.b(c9.c.class));
        }
        this.f17552a = Collections.unmodifiableSet(hashSet);
        this.f17553b = Collections.unmodifiableSet(hashSet2);
        this.f17554c = Collections.unmodifiableSet(hashSet3);
        this.f17555d = Collections.unmodifiableSet(hashSet4);
        this.f17556e = Collections.unmodifiableSet(hashSet5);
        this.f17557f = cVar.k();
        this.f17558g = dVar;
    }

    @Override // o7.d
    public fa.a a(e0 e0Var) {
        if (this.f17554c.contains(e0Var)) {
            return this.f17558g.a(e0Var);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Deferred<%s>.", e0Var));
    }

    @Override // o7.d
    public fa.b b(Class cls) {
        return d(e0.b(cls));
    }

    @Override // o7.d
    public fa.b d(e0 e0Var) {
        if (this.f17553b.contains(e0Var)) {
            return this.f17558g.d(e0Var);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Provider<%s>.", e0Var));
    }

    @Override // o7.d
    public Set e(e0 e0Var) {
        if (this.f17555d.contains(e0Var)) {
            return this.f17558g.e(e0Var);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Set<%s>.", e0Var));
    }

    @Override // o7.d
    public Object f(e0 e0Var) {
        if (this.f17552a.contains(e0Var)) {
            return this.f17558g.f(e0Var);
        }
        throw new s(String.format("Attempting to request an undeclared dependency %s.", e0Var));
    }

    @Override // o7.d
    public fa.b g(e0 e0Var) {
        if (this.f17556e.contains(e0Var)) {
            return this.f17558g.g(e0Var);
        }
        throw new s(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", e0Var));
    }

    @Override // o7.d
    public Object get(Class cls) {
        if (!this.f17552a.contains(e0.b(cls))) {
            throw new s(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        Object obj = this.f17558g.get(cls);
        return !cls.equals(c9.c.class) ? obj : new a(this.f17557f, (c9.c) obj);
    }

    @Override // o7.d
    public fa.a h(Class cls) {
        return a(e0.b(cls));
    }
}
