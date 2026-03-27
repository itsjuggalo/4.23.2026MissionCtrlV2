package P5;

import P5.f;
import V6.A;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6475c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f6476d = new g(AbstractC2595q.l(f.a.f6471e, f.d.f6474e, f.b.f6472e, f.c.f6473e));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f6477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f6478b;

    public static final class a {
        public a() {
        }

        public final g a() {
            return g.f6476d;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f6479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6480b;

        public b(f kind, int i8) {
            AbstractC2304t.f(kind, "kind");
            this.f6479a = kind;
            this.f6480b = i8;
        }

        public final f a() {
            return this.f6479a;
        }

        public final int b() {
            return this.f6480b;
        }

        public final f c() {
            return this.f6479a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC2304t.b(this.f6479a, bVar.f6479a) && this.f6480b == bVar.f6480b;
        }

        public int hashCode() {
            return (this.f6479a.hashCode() * 31) + Integer.hashCode(this.f6480b);
        }

        public String toString() {
            return "KindWithArity(kind=" + this.f6479a + ", arity=" + this.f6480b + ')';
        }
    }

    public g(List kinds) {
        AbstractC2304t.f(kinds, "kinds");
        this.f6477a = kinds;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : kinds) {
            q6.c cVarB = ((f) obj).b();
            Object arrayList = linkedHashMap.get(cVarB);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(cVarB, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f6478b = linkedHashMap;
    }

    public final f b(q6.c packageFqName, String className) {
        AbstractC2304t.f(packageFqName, "packageFqName");
        AbstractC2304t.f(className, "className");
        b bVarC = c(packageFqName, className);
        if (bVarC != null) {
            return bVarC.c();
        }
        return null;
    }

    public final b c(q6.c packageFqName, String className) {
        AbstractC2304t.f(packageFqName, "packageFqName");
        AbstractC2304t.f(className, "className");
        List<f> list = (List) this.f6478b.get(packageFqName);
        if (list == null) {
            return null;
        }
        for (f fVar : list) {
            if (A.G(className, fVar.a(), false, 2, null)) {
                String strSubstring = className.substring(fVar.a().length());
                AbstractC2304t.e(strSubstring, "substring(...)");
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
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            int iCharAt = str.charAt(i9) - '0';
            if (iCharAt < 0 || iCharAt >= 10) {
                return null;
            }
            i8 = (i8 * 10) + iCharAt;
        }
        return Integer.valueOf(i8);
    }
}
