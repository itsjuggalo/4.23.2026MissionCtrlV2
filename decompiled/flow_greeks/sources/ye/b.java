package ye;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import fe.g1;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lf.f;
import oe.i0;
import xe.x;
import ye.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class b implements x.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f25380j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map f25381k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f25382a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25383b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25384c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f25385d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String[] f25386e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String[] f25387f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String[] f25388g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a.EnumC0469a f25389h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String[] f25390i = null;

    /* JADX INFO: renamed from: ye.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class AbstractC0471b implements x.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f25391a = new ArrayList();

        private static /* synthetic */ void f(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "enumEntryName";
            } else if (i10 == 2) {
                objArr[0] = "classLiteralValue";
            } else if (i10 != 3) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i10 == 2) {
                objArr[2] = "visitClassLiteral";
            } else if (i10 != 3) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // xe.x.b
        public void a() {
            g((String[]) this.f25391a.toArray(new String[0]));
        }

        @Override // xe.x.b
        public x.a b(ef.b bVar) {
            if (bVar != null) {
                return null;
            }
            f(3);
            return null;
        }

        @Override // xe.x.b
        public void c(Object obj) {
            if (obj instanceof String) {
                this.f25391a.add((String) obj);
            }
        }

        @Override // xe.x.b
        public void d(f fVar) {
            if (fVar == null) {
                f(2);
            }
        }

        @Override // xe.x.b
        public void e(ef.b bVar, ef.f fVar) {
            if (bVar == null) {
                f(0);
            }
            if (fVar == null) {
                f(1);
            }
        }

        public abstract void g(String[] strArr);
    }

    static {
        try {
            f25380j = com.amazon.a.a.o.b.f4545af.equals(System.getProperty("kotlin.ignore.old.metadata"));
        } catch (AccessControlException unused) {
            f25380j = false;
        }
        HashMap map = new HashMap();
        f25381k = map;
        map.put(ef.b.k(new ef.c("kotlin.jvm.internal.KotlinClass")), a.EnumC0469a.f25372e);
        map.put(ef.b.k(new ef.c("kotlin.jvm.internal.KotlinFileFacade")), a.EnumC0469a.f25373f);
        map.put(ef.b.k(new ef.c("kotlin.jvm.internal.KotlinMultifileClass")), a.EnumC0469a.f25375h);
        map.put(ef.b.k(new ef.c("kotlin.jvm.internal.KotlinMultifileClassPart")), a.EnumC0469a.f25376i);
        map.put(ef.b.k(new ef.c("kotlin.jvm.internal.KotlinSyntheticClass")), a.EnumC0469a.f25374g);
    }

    public static /* synthetic */ void d(int i10) {
        Object[] objArr = new Object[3];
        if (i10 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = FirebaseAnalytics.Param.SOURCE;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // xe.x.c
    public x.a b(ef.b bVar, g1 g1Var) {
        a.EnumC0469a enumC0469a;
        if (bVar == null) {
            d(0);
        }
        if (g1Var == null) {
            d(1);
        }
        ef.c cVarA = bVar.a();
        if (cVarA.equals(i0.f17981a)) {
            return new c();
        }
        if (cVarA.equals(i0.f18000t)) {
            return new d();
        }
        if (f25380j || this.f25389h != null || (enumC0469a = (a.EnumC0469a) f25381k.get(bVar)) == null) {
            return null;
        }
        this.f25389h = enumC0469a;
        return new e();
    }

    public ye.a m(df.e eVar) {
        if (this.f25389h == null || this.f25382a == null) {
            return null;
        }
        df.e eVar2 = new df.e(this.f25382a, (this.f25384c & 8) != 0);
        if (!eVar2.h(eVar)) {
            this.f25388g = this.f25386e;
            this.f25386e = null;
        } else if (o() && this.f25386e == null) {
            return null;
        }
        String[] strArr = this.f25390i;
        return new ye.a(this.f25389h, eVar2, this.f25386e, this.f25388g, this.f25387f, this.f25383b, this.f25384c, this.f25385d, strArr != null ? df.a.e(strArr) : null);
    }

    public ye.a n() {
        return m(df.e.f8098i);
    }

    public final boolean o() {
        a.EnumC0469a enumC0469a = this.f25389h;
        return enumC0469a == a.EnumC0469a.f25372e || enumC0469a == a.EnumC0469a.f25373f || enumC0469a == a.EnumC0469a.f25376i;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements x.a {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a extends AbstractC0471b {
            public a() {
            }

            public static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
            }

            @Override // ye.b.AbstractC0471b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f25386e = strArr;
            }
        }

        /* JADX INFO: renamed from: ye.b$c$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0472b extends AbstractC0471b {
            public C0472b() {
            }

            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
            }

            @Override // ye.b.AbstractC0471b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f25387f = strArr;
            }
        }

        public c() {
        }

        public static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "enumClassId";
            } else if (i10 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i10 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "visitEnum";
            } else if (i10 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // xe.x.a
        public x.a b(ef.f fVar, ef.b bVar) {
            if (bVar != null) {
                return null;
            }
            g(3);
            return null;
        }

        @Override // xe.x.a
        public void c(ef.f fVar, ef.b bVar, ef.f fVar2) {
            if (bVar == null) {
                g(1);
            }
            if (fVar2 == null) {
                g(2);
            }
        }

        @Override // xe.x.a
        public void d(ef.f fVar, f fVar2) {
            if (fVar2 == null) {
                g(0);
            }
        }

        @Override // xe.x.a
        public x.b e(ef.f fVar) {
            String strB = fVar != null ? fVar.b() : null;
            if ("d1".equals(strB)) {
                return h();
            }
            if ("d2".equals(strB)) {
                return i();
            }
            return null;
        }

        @Override // xe.x.a
        public void f(ef.f fVar, Object obj) {
            if (fVar == null) {
                return;
            }
            String strB = fVar.b();
            if ("k".equals(strB)) {
                if (obj instanceof Integer) {
                    b.this.f25389h = a.EnumC0469a.c(((Integer) obj).intValue());
                    return;
                }
                return;
            }
            if ("mv".equals(strB)) {
                if (obj instanceof int[]) {
                    b.this.f25382a = (int[]) obj;
                    return;
                }
                return;
            }
            if ("xs".equals(strB)) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.isEmpty()) {
                        return;
                    }
                    b.this.f25383b = str;
                    return;
                }
                return;
            }
            if ("xi".equals(strB)) {
                if (obj instanceof Integer) {
                    b.this.f25384c = ((Integer) obj).intValue();
                    return;
                }
                return;
            }
            if ("pn".equals(strB) && (obj instanceof String)) {
                String str2 = (String) obj;
                if (str2.isEmpty()) {
                    return;
                }
                b.this.f25385d = str2;
            }
        }

        public final x.b h() {
            return new a();
        }

        public final x.b i() {
            return new C0472b();
        }

        @Override // xe.x.a
        public void a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements x.a {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a extends AbstractC0471b {
            public a() {
            }

            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor$1", "visitEnd"));
            }

            @Override // ye.b.AbstractC0471b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f25390i = strArr;
            }
        }

        public d() {
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "enumClassId";
            } else if (i10 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i10 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "visitEnum";
            } else if (i10 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // xe.x.a
        public x.a b(ef.f fVar, ef.b bVar) {
            if (bVar != null) {
                return null;
            }
            g(3);
            return null;
        }

        @Override // xe.x.a
        public void c(ef.f fVar, ef.b bVar, ef.f fVar2) {
            if (bVar == null) {
                g(1);
            }
            if (fVar2 == null) {
                g(2);
            }
        }

        @Override // xe.x.a
        public void d(ef.f fVar, f fVar2) {
            if (fVar2 == null) {
                g(0);
            }
        }

        @Override // xe.x.a
        public x.b e(ef.f fVar) {
            if ("b".equals(fVar != null ? fVar.b() : null)) {
                return h();
            }
            return null;
        }

        public final x.b h() {
            return new a();
        }

        @Override // xe.x.a
        public void a() {
        }

        @Override // xe.x.a
        public void f(ef.f fVar, Object obj) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements x.a {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a extends AbstractC0471b {
            public a() {
            }

            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
            }

            @Override // ye.b.AbstractC0471b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f25386e = strArr;
            }
        }

        /* JADX INFO: renamed from: ye.b$e$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0473b extends AbstractC0471b {
            public C0473b() {
            }

            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
            }

            @Override // ye.b.AbstractC0471b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f25387f = strArr;
            }
        }

        public e() {
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "enumClassId";
            } else if (i10 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i10 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "visitEnum";
            } else if (i10 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private x.b h() {
            return new a();
        }

        private x.b i() {
            return new C0473b();
        }

        @Override // xe.x.a
        public x.a b(ef.f fVar, ef.b bVar) {
            if (bVar != null) {
                return null;
            }
            g(3);
            return null;
        }

        @Override // xe.x.a
        public void c(ef.f fVar, ef.b bVar, ef.f fVar2) {
            if (bVar == null) {
                g(1);
            }
            if (fVar2 == null) {
                g(2);
            }
        }

        @Override // xe.x.a
        public void d(ef.f fVar, f fVar2) {
            if (fVar2 == null) {
                g(0);
            }
        }

        @Override // xe.x.a
        public x.b e(ef.f fVar) {
            String strB = fVar != null ? fVar.b() : null;
            if ("data".equals(strB) || "filePartClassNames".equals(strB)) {
                return h();
            }
            if ("strings".equals(strB)) {
                return i();
            }
            return null;
        }

        @Override // xe.x.a
        public void f(ef.f fVar, Object obj) {
            if (fVar == null) {
                return;
            }
            String strB = fVar.b();
            if (DiagnosticsEntry.VERSION_KEY.equals(strB)) {
                if (obj instanceof int[]) {
                    b.this.f25382a = (int[]) obj;
                }
            } else if ("multifileClassName".equals(strB)) {
                b.this.f25383b = obj instanceof String ? (String) obj : null;
            }
        }

        @Override // xe.x.a
        public void a() {
        }
    }

    @Override // xe.x.c
    public void a() {
    }
}
