package k2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: k2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0771q implements InterfaceC0756b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f7869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f7870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f7871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f7872d;
    public final Set e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f7873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InterfaceC0756b f7874g;

    public C0771q(C0755a c0755a, InterfaceC0756b interfaceC0756b) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (C0761g c0761g : c0755a.f7834c) {
            int i = c0761g.f7852c;
            boolean z6 = i == 0;
            int i6 = c0761g.f7851b;
            C0769o c0769o = c0761g.f7850a;
            if (z6) {
                if (i6 == 2) {
                    hashSet4.add(c0769o);
                } else {
                    hashSet.add(c0769o);
                }
            } else if (i == 2) {
                hashSet3.add(c0769o);
            } else if (i6 == 2) {
                hashSet5.add(c0769o);
            } else {
                hashSet2.add(c0769o);
            }
        }
        Set set = c0755a.f7837g;
        if (!set.isEmpty()) {
            hashSet.add(C0769o.a(J2.c.class));
        }
        this.f7869a = Collections.unmodifiableSet(hashSet);
        this.f7870b = Collections.unmodifiableSet(hashSet2);
        this.f7871c = Collections.unmodifiableSet(hashSet3);
        this.f7872d = Collections.unmodifiableSet(hashSet4);
        this.e = Collections.unmodifiableSet(hashSet5);
        this.f7873f = set;
        this.f7874g = interfaceC0756b;
    }

    @Override // k2.InterfaceC0756b
    public final Object a(C0769o c0769o) {
        if (this.f7869a.contains(c0769o)) {
            return this.f7874g.a(c0769o);
        }
        throw new G4.e("Attempting to request an undeclared dependency " + c0769o + ".");
    }

    @Override // k2.InterfaceC0756b
    public final Object b(Class cls) {
        if (this.f7869a.contains(C0769o.a(cls))) {
            Object objB = this.f7874g.b(cls);
            return !cls.equals(J2.c.class) ? objB : new C0770p(this.f7873f, (J2.c) objB);
        }
        throw new G4.e("Attempting to request an undeclared dependency " + cls + ".");
    }

    @Override // k2.InterfaceC0756b
    public final Set c(C0769o c0769o) {
        if (this.f7872d.contains(c0769o)) {
            return this.f7874g.c(c0769o);
        }
        throw new G4.e("Attempting to request an undeclared dependency Set<" + c0769o + ">.");
    }

    @Override // k2.InterfaceC0756b
    public final X2.b d(C0769o c0769o) {
        if (this.e.contains(c0769o)) {
            return this.f7874g.d(c0769o);
        }
        throw new G4.e("Attempting to request an undeclared dependency Provider<Set<" + c0769o + ">>.");
    }

    @Override // k2.InterfaceC0756b
    public final C0767m e(C0769o c0769o) {
        if (this.f7871c.contains(c0769o)) {
            return this.f7874g.e(c0769o);
        }
        throw new G4.e("Attempting to request an undeclared dependency Deferred<" + c0769o + ">.");
    }

    @Override // k2.InterfaceC0756b
    public final X2.b f(Class cls) {
        return g(C0769o.a(cls));
    }

    @Override // k2.InterfaceC0756b
    public final X2.b g(C0769o c0769o) {
        if (this.f7870b.contains(c0769o)) {
            return this.f7874g.g(c0769o);
        }
        throw new G4.e("Attempting to request an undeclared dependency Provider<" + c0769o + ">.");
    }

    @Override // k2.InterfaceC0756b
    public final C0767m h(Class cls) {
        return e(C0769o.a(cls));
    }
}
