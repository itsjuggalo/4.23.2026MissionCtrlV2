package i6;

import kotlin.jvm.internal.AbstractC2296k;

/* JADX INFO: renamed from: i6.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1973h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f18881e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C1973h f18882f = new C1973h(null, null, false, false, 8, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC1979k f18883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EnumC1975i f18884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18886d;

    /* JADX INFO: renamed from: i6.h$a */
    public static final class a {
        public a() {
        }

        public final C1973h a() {
            return C1973h.f18882f;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public C1973h(EnumC1979k enumC1979k, EnumC1975i enumC1975i, boolean z7, boolean z8) {
        this.f18883a = enumC1979k;
        this.f18884b = enumC1975i;
        this.f18885c = z7;
        this.f18886d = z8;
    }

    public static /* synthetic */ C1973h c(C1973h c1973h, EnumC1979k enumC1979k, EnumC1975i enumC1975i, boolean z7, boolean z8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            enumC1979k = c1973h.f18883a;
        }
        if ((i8 & 2) != 0) {
            enumC1975i = c1973h.f18884b;
        }
        if ((i8 & 4) != 0) {
            z7 = c1973h.f18885c;
        }
        if ((i8 & 8) != 0) {
            z8 = c1973h.f18886d;
        }
        return c1973h.b(enumC1979k, enumC1975i, z7, z8);
    }

    public final C1973h b(EnumC1979k enumC1979k, EnumC1975i enumC1975i, boolean z7, boolean z8) {
        return new C1973h(enumC1979k, enumC1975i, z7, z8);
    }

    public final boolean d() {
        return this.f18885c;
    }

    public final EnumC1975i e() {
        return this.f18884b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1973h)) {
            return false;
        }
        C1973h c1973h = (C1973h) obj;
        return this.f18883a == c1973h.f18883a && this.f18884b == c1973h.f18884b && this.f18885c == c1973h.f18885c && this.f18886d == c1973h.f18886d;
    }

    public final EnumC1979k f() {
        return this.f18883a;
    }

    public final boolean g() {
        return this.f18886d;
    }

    public int hashCode() {
        EnumC1979k enumC1979k = this.f18883a;
        int iHashCode = (enumC1979k == null ? 0 : enumC1979k.hashCode()) * 31;
        EnumC1975i enumC1975i = this.f18884b;
        return ((((iHashCode + (enumC1975i != null ? enumC1975i.hashCode() : 0)) * 31) + Boolean.hashCode(this.f18885c)) * 31) + Boolean.hashCode(this.f18886d);
    }

    public String toString() {
        return "JavaTypeQualifiers(nullability=" + this.f18883a + ", mutability=" + this.f18884b + ", definitelyNotNull=" + this.f18885c + ", isNullabilityQualifierForWarning=" + this.f18886d + ')';
    }

    public /* synthetic */ C1973h(EnumC1979k enumC1979k, EnumC1975i enumC1975i, boolean z7, boolean z8, int i8, AbstractC2296k abstractC2296k) {
        this(enumC1979k, enumC1975i, z7, (i8 & 8) != 0 ? false : z8);
    }
}
