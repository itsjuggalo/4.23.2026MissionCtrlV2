package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class S {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final S f4509c = new S();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f4511b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f4510a = new E();

    public final V a(Class cls) {
        V vX;
        Class cls2;
        AbstractC0341x.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f4511b;
        V v2 = (V) concurrentHashMap.get(cls);
        if (v2 != null) {
            return v2;
        }
        E e = this.f4510a;
        e.getClass();
        Class cls3 = W.f4519a;
        if (!AbstractC0339v.class.isAssignableFrom(cls) && (cls2 = W.f4519a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        U uA = ((D) e.f4481a).a(cls);
        if ((uA.f4518d & 2) == 2) {
            boolean zIsAssignableFrom = AbstractC0339v.class.isAssignableFrom(cls);
            AbstractC0339v abstractC0339v = uA.f4515a;
            if (zIsAssignableFrom) {
                vX = new N(W.f4521c, AbstractC0334p.f4589a, abstractC0339v);
            } else {
                d0 d0Var = W.f4520b;
                C0333o c0333o = AbstractC0334p.f4590b;
                if (c0333o == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                vX = new N(d0Var, c0333o, abstractC0339v);
            }
        } else if (AbstractC0339v.class.isAssignableFrom(cls)) {
            C0333o c0333o2 = null;
            O o3 = P.f4508b;
            B b3 = C.f4478b;
            d0 d0Var2 = W.f4521c;
            if (S.i.c(uA.a()) != 1) {
                c0333o2 = AbstractC0334p.f4589a;
            }
            C0333o c0333o3 = c0333o2;
            I i = J.f4489b;
            int[] iArr = M.f4491n;
            if (!(uA instanceof U)) {
                uA.getClass();
                throw new ClassCastException();
            }
            vX = M.x(uA, o3, b3, d0Var2, c0333o3, i);
        } else {
            C0333o c0333o4 = null;
            O o5 = P.f4507a;
            B b6 = C.f4477a;
            d0 d0Var3 = W.f4520b;
            if (S.i.c(uA.a()) != 1 && (c0333o4 = AbstractC0334p.f4590b) == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            C0333o c0333o5 = c0333o4;
            I i6 = J.f4488a;
            int[] iArr2 = M.f4491n;
            if (!(uA instanceof U)) {
                uA.getClass();
                throw new ClassCastException();
            }
            vX = M.x(uA, o5, b6, d0Var3, c0333o5, i6);
        }
        V v6 = (V) concurrentHashMap.putIfAbsent(cls, vX);
        return v6 != null ? v6 : vX;
    }
}
