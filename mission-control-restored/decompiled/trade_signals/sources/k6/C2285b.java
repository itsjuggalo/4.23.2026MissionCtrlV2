package k6;

import R5.h0;
import a6.I;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import j6.InterfaceC2260x;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k6.C2284a;
import p6.AbstractC2598a;
import p6.C2602e;
import q6.f;
import w6.C2938f;

/* JADX INFO: renamed from: k6.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2285b implements InterfaceC2260x.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f20432j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map f20433k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f20434a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20435b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20436c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f20437d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String[] f20438e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String[] f20439f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String[] f20440g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C2284a.EnumC0339a f20441h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String[] f20442i = null;

    /* JADX INFO: renamed from: k6.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0341b implements InterfaceC2260x.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f20443a = new ArrayList();

        private static /* synthetic */ void f(int i8) {
            Object[] objArr = new Object[3];
            if (i8 == 1) {
                objArr[0] = "enumEntryName";
            } else if (i8 == 2) {
                objArr[0] = "classLiteralValue";
            } else if (i8 != 3) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i8 == 2) {
                objArr[2] = "visitClassLiteral";
            } else if (i8 != 3) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // j6.InterfaceC2260x.b
        public void a() {
            g((String[]) this.f20443a.toArray(new String[0]));
        }

        @Override // j6.InterfaceC2260x.b
        public void b(C2938f c2938f) {
            if (c2938f == null) {
                f(2);
            }
        }

        @Override // j6.InterfaceC2260x.b
        public InterfaceC2260x.a c(q6.b bVar) {
            if (bVar != null) {
                return null;
            }
            f(3);
            return null;
        }

        @Override // j6.InterfaceC2260x.b
        public void d(Object obj) {
            if (obj instanceof String) {
                this.f20443a.add((String) obj);
            }
        }

        @Override // j6.InterfaceC2260x.b
        public void e(q6.b bVar, f fVar) {
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
            f20432j = com.amazon.a.a.o.b.af.equals(System.getProperty("kotlin.ignore.old.metadata"));
        } catch (AccessControlException unused) {
            f20432j = false;
        }
        HashMap map = new HashMap();
        f20433k = map;
        map.put(q6.b.k(new q6.c("kotlin.jvm.internal.KotlinClass")), C2284a.EnumC0339a.f20424e);
        map.put(q6.b.k(new q6.c("kotlin.jvm.internal.KotlinFileFacade")), C2284a.EnumC0339a.f20425f);
        map.put(q6.b.k(new q6.c("kotlin.jvm.internal.KotlinMultifileClass")), C2284a.EnumC0339a.f20427h);
        map.put(q6.b.k(new q6.c("kotlin.jvm.internal.KotlinMultifileClassPart")), C2284a.EnumC0339a.f20428i);
        map.put(q6.b.k(new q6.c("kotlin.jvm.internal.KotlinSyntheticClass")), C2284a.EnumC0339a.f20426g);
    }

    public static /* synthetic */ void d(int i8) {
        Object[] objArr = new Object[3];
        if (i8 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = FirebaseAnalytics.Param.SOURCE;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // j6.InterfaceC2260x.c
    public InterfaceC2260x.a b(q6.b bVar, h0 h0Var) {
        C2284a.EnumC0339a enumC0339a;
        if (bVar == null) {
            d(0);
        }
        if (h0Var == null) {
            d(1);
        }
        q6.c cVarA = bVar.a();
        if (cVarA.equals(I.f10025a)) {
            return new c();
        }
        if (cVarA.equals(I.f10044t)) {
            return new d();
        }
        if (f20432j || this.f20441h != null || (enumC0339a = (C2284a.EnumC0339a) f20433k.get(bVar)) == null) {
            return null;
        }
        this.f20441h = enumC0339a;
        return new e();
    }

    public C2284a m(C2602e c2602e) {
        if (this.f20441h == null || this.f20434a == null) {
            return null;
        }
        C2602e c2602e2 = new C2602e(this.f20434a, (this.f20436c & 8) != 0);
        if (!c2602e2.h(c2602e)) {
            this.f20440g = this.f20438e;
            this.f20438e = null;
        } else if (o() && this.f20438e == null) {
            return null;
        }
        String[] strArr = this.f20442i;
        return new C2284a(this.f20441h, c2602e2, this.f20438e, this.f20440g, this.f20439f, this.f20435b, this.f20436c, this.f20437d, strArr != null ? AbstractC2598a.e(strArr) : null);
    }

    public C2284a n() {
        return m(C2602e.f22409i);
    }

    public final boolean o() {
        C2284a.EnumC0339a enumC0339a = this.f20441h;
        return enumC0339a == C2284a.EnumC0339a.f20424e || enumC0339a == C2284a.EnumC0339a.f20425f || enumC0339a == C2284a.EnumC0339a.f20428i;
    }

    /* JADX INFO: renamed from: k6.b$c */
    public class c implements InterfaceC2260x.a {

        /* JADX INFO: renamed from: k6.b$c$a */
        public class a extends AbstractC0341b {
            public a() {
            }

            public static /* synthetic */ void f(int i8) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
            }

            @Override // k6.C2285b.AbstractC0341b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                C2285b.this.f20438e = strArr;
            }
        }

        /* JADX INFO: renamed from: k6.b$c$b, reason: collision with other inner class name */
        public class C0342b extends AbstractC0341b {
            public C0342b() {
            }

            private static /* synthetic */ void f(int i8) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
            }

            @Override // k6.C2285b.AbstractC0341b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                C2285b.this.f20439f = strArr;
            }
        }

        public c() {
        }

        public static /* synthetic */ void g(int i8) {
            Object[] objArr = new Object[3];
            if (i8 == 1) {
                objArr[0] = "enumClassId";
            } else if (i8 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i8 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            if (i8 == 1 || i8 == 2) {
                objArr[2] = "visitEnum";
            } else if (i8 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // j6.InterfaceC2260x.a
        public void b(f fVar, q6.b bVar, f fVar2) {
            if (bVar == null) {
                g(1);
            }
            if (fVar2 == null) {
                g(2);
            }
        }

        @Override // j6.InterfaceC2260x.a
        public InterfaceC2260x.a c(f fVar, q6.b bVar) {
            if (bVar != null) {
                return null;
            }
            g(3);
            return null;
        }

        @Override // j6.InterfaceC2260x.a
        public InterfaceC2260x.b d(f fVar) {
            String strB = fVar != null ? fVar.b() : null;
            if ("d1".equals(strB)) {
                return h();
            }
            if ("d2".equals(strB)) {
                return i();
            }
            return null;
        }

        @Override // j6.InterfaceC2260x.a
        public void e(f fVar, C2938f c2938f) {
            if (c2938f == null) {
                g(0);
            }
        }

        @Override // j6.InterfaceC2260x.a
        public void f(f fVar, Object obj) {
            if (fVar == null) {
                return;
            }
            String strB = fVar.b();
            if ("k".equals(strB)) {
                if (obj instanceof Integer) {
                    C2285b.this.f20441h = C2284a.EnumC0339a.g(((Integer) obj).intValue());
                    return;
                }
                return;
            }
            if ("mv".equals(strB)) {
                if (obj instanceof int[]) {
                    C2285b.this.f20434a = (int[]) obj;
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
                    C2285b.this.f20435b = str;
                    return;
                }
                return;
            }
            if ("xi".equals(strB)) {
                if (obj instanceof Integer) {
                    C2285b.this.f20436c = ((Integer) obj).intValue();
                    return;
                }
                return;
            }
            if ("pn".equals(strB) && (obj instanceof String)) {
                String str2 = (String) obj;
                if (str2.isEmpty()) {
                    return;
                }
                C2285b.this.f20437d = str2;
            }
        }

        public final InterfaceC2260x.b h() {
            return new a();
        }

        public final InterfaceC2260x.b i() {
            return new C0342b();
        }

        @Override // j6.InterfaceC2260x.a
        public void a() {
        }
    }

    /* JADX INFO: renamed from: k6.b$d */
    public class d implements InterfaceC2260x.a {

        /* JADX INFO: renamed from: k6.b$d$a */
        public class a extends AbstractC0341b {
            public a() {
            }

            private static /* synthetic */ void f(int i8) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor$1", "visitEnd"));
            }

            @Override // k6.C2285b.AbstractC0341b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                C2285b.this.f20442i = strArr;
            }
        }

        public d() {
        }

        private static /* synthetic */ void g(int i8) {
            Object[] objArr = new Object[3];
            if (i8 == 1) {
                objArr[0] = "enumClassId";
            } else if (i8 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i8 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor";
            if (i8 == 1 || i8 == 2) {
                objArr[2] = "visitEnum";
            } else if (i8 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // j6.InterfaceC2260x.a
        public void b(f fVar, q6.b bVar, f fVar2) {
            if (bVar == null) {
                g(1);
            }
            if (fVar2 == null) {
                g(2);
            }
        }

        @Override // j6.InterfaceC2260x.a
        public InterfaceC2260x.a c(f fVar, q6.b bVar) {
            if (bVar != null) {
                return null;
            }
            g(3);
            return null;
        }

        @Override // j6.InterfaceC2260x.a
        public InterfaceC2260x.b d(f fVar) {
            if ("b".equals(fVar != null ? fVar.b() : null)) {
                return h();
            }
            return null;
        }

        @Override // j6.InterfaceC2260x.a
        public void e(f fVar, C2938f c2938f) {
            if (c2938f == null) {
                g(0);
            }
        }

        public final InterfaceC2260x.b h() {
            return new a();
        }

        @Override // j6.InterfaceC2260x.a
        public void a() {
        }

        @Override // j6.InterfaceC2260x.a
        public void f(f fVar, Object obj) {
        }
    }

    /* JADX INFO: renamed from: k6.b$e */
    public class e implements InterfaceC2260x.a {

        /* JADX INFO: renamed from: k6.b$e$a */
        public class a extends AbstractC0341b {
            public a() {
            }

            private static /* synthetic */ void f(int i8) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
            }

            @Override // k6.C2285b.AbstractC0341b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                C2285b.this.f20438e = strArr;
            }
        }

        /* JADX INFO: renamed from: k6.b$e$b, reason: collision with other inner class name */
        public class C0343b extends AbstractC0341b {
            public C0343b() {
            }

            private static /* synthetic */ void f(int i8) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
            }

            @Override // k6.C2285b.AbstractC0341b
            public void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                C2285b.this.f20439f = strArr;
            }
        }

        public e() {
        }

        private static /* synthetic */ void g(int i8) {
            Object[] objArr = new Object[3];
            if (i8 == 1) {
                objArr[0] = "enumClassId";
            } else if (i8 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i8 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            if (i8 == 1 || i8 == 2) {
                objArr[2] = "visitEnum";
            } else if (i8 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private InterfaceC2260x.b h() {
            return new a();
        }

        private InterfaceC2260x.b i() {
            return new C0343b();
        }

        @Override // j6.InterfaceC2260x.a
        public void b(f fVar, q6.b bVar, f fVar2) {
            if (bVar == null) {
                g(1);
            }
            if (fVar2 == null) {
                g(2);
            }
        }

        @Override // j6.InterfaceC2260x.a
        public InterfaceC2260x.a c(f fVar, q6.b bVar) {
            if (bVar != null) {
                return null;
            }
            g(3);
            return null;
        }

        @Override // j6.InterfaceC2260x.a
        public InterfaceC2260x.b d(f fVar) {
            String strB = fVar != null ? fVar.b() : null;
            if ("data".equals(strB) || "filePartClassNames".equals(strB)) {
                return h();
            }
            if ("strings".equals(strB)) {
                return i();
            }
            return null;
        }

        @Override // j6.InterfaceC2260x.a
        public void e(f fVar, C2938f c2938f) {
            if (c2938f == null) {
                g(0);
            }
        }

        @Override // j6.InterfaceC2260x.a
        public void f(f fVar, Object obj) {
            if (fVar == null) {
                return;
            }
            String strB = fVar.b();
            if (DiagnosticsEntry.VERSION_KEY.equals(strB)) {
                if (obj instanceof int[]) {
                    C2285b.this.f20434a = (int[]) obj;
                }
            } else if ("multifileClassName".equals(strB)) {
                C2285b.this.f20435b = obj instanceof String ? (String) obj : null;
            }
        }

        @Override // j6.InterfaceC2260x.a
        public void a() {
        }
    }

    @Override // j6.InterfaceC2260x.c
    public void a() {
    }
}
