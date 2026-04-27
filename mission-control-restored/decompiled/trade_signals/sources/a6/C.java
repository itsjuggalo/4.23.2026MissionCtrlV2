package a6;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2481i;

/* JADX INFO: loaded from: classes2.dex */
public final class C {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f10002d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C f10003e = new C(O.f10083e, null, null, 6, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O f10004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2481i f10005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final O f10006c;

    public static final class a {
        public a() {
        }

        public final C a() {
            return C.f10003e;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public C(O reportLevelBefore, C2481i c2481i, O reportLevelAfter) {
        AbstractC2304t.f(reportLevelBefore, "reportLevelBefore");
        AbstractC2304t.f(reportLevelAfter, "reportLevelAfter");
        this.f10004a = reportLevelBefore;
        this.f10005b = c2481i;
        this.f10006c = reportLevelAfter;
    }

    public final O b() {
        return this.f10006c;
    }

    public final O c() {
        return this.f10004a;
    }

    public final C2481i d() {
        return this.f10005b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C)) {
            return false;
        }
        C c8 = (C) obj;
        return this.f10004a == c8.f10004a && AbstractC2304t.b(this.f10005b, c8.f10005b) && this.f10006c == c8.f10006c;
    }

    public int hashCode() {
        int iHashCode = this.f10004a.hashCode() * 31;
        C2481i c2481i = this.f10005b;
        return ((iHashCode + (c2481i == null ? 0 : c2481i.hashCode())) * 31) + this.f10006c.hashCode();
    }

    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.f10004a + ", sinceVersion=" + this.f10005b + ", reportLevelAfter=" + this.f10006c + ')';
    }

    public /* synthetic */ C(O o8, C2481i c2481i, O o9, int i8, AbstractC2296k abstractC2296k) {
        this(o8, (i8 & 2) != 0 ? new C2481i(1, 0) : c2481i, (i8 & 4) != 0 ? o8 : o9);
    }
}
