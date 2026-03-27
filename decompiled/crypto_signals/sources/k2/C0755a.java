package k2;

import K2.C0061l;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import t2.u0;

/* JADX INFO: renamed from: k2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0755a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f7833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f7834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7835d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC0757c f7836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set f7837g;

    public C0755a(String str, Set set, Set set2, int i, int i6, InterfaceC0757c interfaceC0757c, Set set3) {
        this.f7832a = str;
        this.f7833b = Collections.unmodifiableSet(set);
        this.f7834c = Collections.unmodifiableSet(set2);
        this.f7835d = i;
        this.e = i6;
        this.f7836f = interfaceC0757c;
        this.f7837g = Collections.unmodifiableSet(set3);
    }

    public static E3.k a(Class cls) {
        return new E3.k(cls, new Class[0]);
    }

    public static E3.k b(C0769o c0769o) {
        return new E3.k(c0769o, new C0769o[0]);
    }

    public static C0755a c(Object obj, Class cls, Class... clsArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(C0769o.a(cls));
        for (Class cls2 : clsArr) {
            u0.h(cls2, "Null interface");
            hashSet.add(C0769o.a(cls2));
        }
        return new C0755a(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new C0061l(obj, 22), hashSet3);
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.f7833b.toArray()) + ">{" + this.f7835d + ", type=" + this.e + ", deps=" + Arrays.toString(this.f7834c.toArray()) + "}";
    }
}
