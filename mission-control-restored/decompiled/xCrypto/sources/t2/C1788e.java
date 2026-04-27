package t2;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import q2.w;
import q2.x;
import r2.InterfaceC1752b;
import s2.u;
import x2.C1925a;

/* JADX INFO: renamed from: t2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1788e implements x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f14763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f14764d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f14765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f14766b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: t2.e$b */
    public static class b implements x {
        private b() {
        }

        @Override // q2.x
        public w create(q2.e eVar, C1925a c1925a) {
            throw new AssertionError("Factory should not be used");
        }
    }

    static {
        f14763c = new b();
        f14764d = new b();
    }

    public C1788e(u uVar) {
        this.f14765a = uVar;
    }

    public static Object a(u uVar, Class cls) {
        return uVar.t(C1925a.a(cls)).a();
    }

    public static InterfaceC1752b b(Class cls) {
        return (InterfaceC1752b) cls.getAnnotation(InterfaceC1752b.class);
    }

    public w c(u uVar, q2.e eVar, C1925a c1925a, InterfaceC1752b interfaceC1752b, boolean z4) {
        w wVarCreate;
        Object objA = a(uVar, interfaceC1752b.value());
        boolean zNullSafe = interfaceC1752b.nullSafe();
        if (objA instanceof w) {
            wVarCreate = (w) objA;
        } else if (objA instanceof x) {
            x xVarE = (x) objA;
            if (z4) {
                xVarE = e(c1925a.c(), xVarE);
            }
            wVarCreate = xVarE.create(eVar, c1925a);
        } else {
            if (!(objA instanceof q2.i)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + c1925a.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            n nVar = new n(null, objA instanceof q2.i ? (q2.i) objA : null, eVar, c1925a, z4 ? f14763c : f14764d, zNullSafe);
            zNullSafe = false;
            wVarCreate = nVar;
        }
        return (wVarCreate == null || !zNullSafe) ? wVarCreate : wVarCreate.b();
    }

    @Override // q2.x
    public w create(q2.e eVar, C1925a c1925a) {
        InterfaceC1752b interfaceC1752bB = b(c1925a.c());
        if (interfaceC1752bB == null) {
            return null;
        }
        return c(this.f14765a, eVar, c1925a, interfaceC1752bB, true);
    }

    public boolean d(C1925a c1925a, x xVar) {
        Objects.requireNonNull(c1925a);
        Objects.requireNonNull(xVar);
        if (xVar == f14763c) {
            return true;
        }
        Class clsC = c1925a.c();
        x xVar2 = (x) this.f14766b.get(clsC);
        if (xVar2 != null) {
            return xVar2 == xVar;
        }
        InterfaceC1752b interfaceC1752bB = b(clsC);
        if (interfaceC1752bB == null) {
            return false;
        }
        Class clsValue = interfaceC1752bB.value();
        return x.class.isAssignableFrom(clsValue) && e(clsC, (x) a(this.f14765a, clsValue)) == xVar;
    }

    public final x e(Class cls, x xVar) {
        x xVar2 = (x) this.f14766b.putIfAbsent(cls, xVar);
        return xVar2 != null ? xVar2 : xVar;
    }
}
