package S6;

import io.flutter.Build;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    public static class a extends AbstractC0110b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ B5.k f7748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean[] f7749b;

        public a(B5.k kVar, boolean[] zArr) {
            this.f7748a = kVar;
            this.f7749b = zArr;
        }

        @Override // S6.b.d
        public boolean c(Object obj) {
            if (((Boolean) this.f7748a.invoke(obj)).booleanValue()) {
                this.f7749b[0] = true;
            }
            return !this.f7749b[0];
        }

        @Override // S6.b.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean a() {
            return Boolean.valueOf(this.f7749b[0]);
        }
    }

    public interface c {
        Iterable a(Object obj);
    }

    public interface d {
        Object a();

        void b(Object obj);

        boolean c(Object obj);
    }

    public interface e {
        boolean a(Object obj);
    }

    public static class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f7750a;

        public f() {
            this(new HashSet());
        }

        public static /* synthetic */ void b(int i8) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"));
        }

        @Override // S6.b.e
        public boolean a(Object obj) {
            return this.f7750a.add(obj);
        }

        public f(Set set) {
            if (set == null) {
                b(0);
            }
            this.f7750a = set;
        }
    }

    public static /* synthetic */ void a(int i8) {
        Object[] objArr = new Object[3];
        switch (i8) {
            case 1:
            case 5:
            case 8:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 15:
            case 18:
            case 21:
            case Build.API_LEVELS.API_23 /* 23 */:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case com.amazon.c.a.a.c.f14230g /* 16 */:
            case 19:
            case Build.API_LEVELS.API_24 /* 24 */:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case Build.API_LEVELS.API_25 /* 25 */:
                objArr[0] = "handler";
                break;
            case 4:
            case 7:
            case 17:
            case 20:
            default:
                objArr[0] = "nodes";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case Build.API_LEVELS.API_22 /* 22 */:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i8) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 12:
            case 13:
            case 14:
            case 15:
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                objArr[2] = "topologicalOrder";
                break;
            case Build.API_LEVELS.API_22 /* 22 */:
            case Build.API_LEVELS.API_23 /* 23 */:
            case Build.API_LEVELS.API_24 /* 24 */:
            case Build.API_LEVELS.API_25 /* 25 */:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static Object b(Collection collection, c cVar, d dVar) {
        if (collection == null) {
            a(4);
        }
        if (cVar == null) {
            a(5);
        }
        if (dVar == null) {
            a(6);
        }
        return c(collection, cVar, new f(), dVar);
    }

    public static Object c(Collection collection, c cVar, e eVar, d dVar) {
        if (collection == null) {
            a(0);
        }
        if (cVar == null) {
            a(1);
        }
        if (eVar == null) {
            a(2);
        }
        if (dVar == null) {
            a(3);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            d(it.next(), cVar, eVar, dVar);
        }
        return dVar.a();
    }

    public static void d(Object obj, c cVar, e eVar, d dVar) {
        if (obj == null) {
            a(22);
        }
        if (cVar == null) {
            a(23);
        }
        if (eVar == null) {
            a(24);
        }
        if (dVar == null) {
            a(25);
        }
        if (eVar.a(obj) && dVar.c(obj)) {
            Iterator it = cVar.a(obj).iterator();
            while (it.hasNext()) {
                d(it.next(), cVar, eVar, dVar);
            }
            dVar.b(obj);
        }
    }

    public static Boolean e(Collection collection, c cVar, B5.k kVar) {
        if (collection == null) {
            a(7);
        }
        if (cVar == null) {
            a(8);
        }
        if (kVar == null) {
            a(9);
        }
        return (Boolean) b(collection, cVar, new a(kVar, new boolean[1]));
    }

    /* JADX INFO: renamed from: S6.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0110b implements d {
        @Override // S6.b.d
        public void b(Object obj) {
        }
    }
}
