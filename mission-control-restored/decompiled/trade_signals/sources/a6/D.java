package a6;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class D {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f10007d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final D f10008e = new D(AbstractC1077B.b(null, 1, null), a.f10012a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G f10009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B5.k f10010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10011c;

    public /* synthetic */ class a extends AbstractC2302q implements B5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10012a = new a();

        public a() {
            super(1, AbstractC1077B.class, "getDefaultReportLevelForAnnotation", "getDefaultReportLevelForAnnotation(Lorg/jetbrains/kotlin/name/FqName;)Lorg/jetbrains/kotlin/load/java/ReportLevel;", 1);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final O invoke(q6.c p02) {
            AbstractC2304t.f(p02, "p0");
            return AbstractC1077B.d(p02);
        }
    }

    public static final class b {
        public b() {
        }

        public final D a() {
            return D.f10008e;
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public D(G jsr305, B5.k getReportLevelForAnnotation) {
        AbstractC2304t.f(jsr305, "jsr305");
        AbstractC2304t.f(getReportLevelForAnnotation, "getReportLevelForAnnotation");
        this.f10009a = jsr305;
        this.f10010b = getReportLevelForAnnotation;
        this.f10011c = jsr305.f() || getReportLevelForAnnotation.invoke(AbstractC1077B.e()) == O.f10081c;
    }

    public final boolean b() {
        return this.f10011c;
    }

    public final B5.k c() {
        return this.f10010b;
    }

    public final G d() {
        return this.f10009a;
    }

    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.f10009a + ", getReportLevelForAnnotation=" + this.f10010b + ')';
    }
}
