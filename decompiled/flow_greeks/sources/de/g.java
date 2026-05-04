package de;

import dd.r;
import de.f;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kg.z;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f8073c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f8074d = new g(r.n(f.a.f8069e, f.d.f8072e, f.b.f8070e, f.c.f8071e));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f8076b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public final g a() {
            return g.f8074d;
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f8077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8078b;

        public b(f kind, int i10) {
            t.f(kind, "kind");
            this.f8077a = kind;
            this.f8078b = i10;
        }

        public final f a() {
            return this.f8077a;
        }

        public final int b() {
            return this.f8078b;
        }

        public final f c() {
            return this.f8077a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return t.b(this.f8077a, bVar.f8077a) && this.f8078b == bVar.f8078b;
        }

        public int hashCode() {
            return (this.f8077a.hashCode() * 31) + Integer.hashCode(this.f8078b);
        }

        public String toString() {
            return "KindWithArity(kind=" + this.f8077a + ", arity=" + this.f8078b + ')';
        }
    }

    public g(List kinds) {
        t.f(kinds, "kinds");
        this.f8075a = kinds;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : kinds) {
            ef.c cVarB = ((f) obj).b();
            Object arrayList = linkedHashMap.get(cVarB);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(cVarB, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f8076b = linkedHashMap;
    }

    public final f b(ef.c packageFqName, String className) {
        t.f(packageFqName, "packageFqName");
        t.f(className, "className");
        b bVarC = c(packageFqName, className);
        if (bVarC != null) {
            return bVarC.c();
        }
        return null;
    }

    public final b c(ef.c packageFqName, String className) {
        t.f(packageFqName, "packageFqName");
        t.f(className, "className");
        List<f> list = (List) this.f8076b.get(packageFqName);
        if (list == null) {
            return null;
        }
        for (f fVar : list) {
            if (z.J(className, fVar.a(), false, 2, null)) {
                String strSubstring = className.substring(fVar.a().length());
                t.e(strSubstring, "substring(...)");
                Integer numD = d(strSubstring);
                if (numD != null) {
                    return new b(fVar, numD.intValue());
                }
            }
        }
        return null;
    }

    public final Integer d(String str) {
        if (str.length() == 0) {
            return null;
        }
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            int iCharAt = str.charAt(i11) - '0';
            if (iCharAt < 0 || iCharAt >= 10) {
                return null;
            }
            i10 = (i10 * 10) + iCharAt;
        }
        return Integer.valueOf(i10);
    }
}
