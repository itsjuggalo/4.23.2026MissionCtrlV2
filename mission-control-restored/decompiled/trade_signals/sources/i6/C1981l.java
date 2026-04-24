package i6;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: i6.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1981l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC1979k f18901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18902b;

    public C1981l(EnumC1979k qualifier, boolean z7) {
        AbstractC2304t.f(qualifier, "qualifier");
        this.f18901a = qualifier;
        this.f18902b = z7;
    }

    public static /* synthetic */ C1981l b(C1981l c1981l, EnumC1979k enumC1979k, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            enumC1979k = c1981l.f18901a;
        }
        if ((i8 & 2) != 0) {
            z7 = c1981l.f18902b;
        }
        return c1981l.a(enumC1979k, z7);
    }

    public final C1981l a(EnumC1979k qualifier, boolean z7) {
        AbstractC2304t.f(qualifier, "qualifier");
        return new C1981l(qualifier, z7);
    }

    public final EnumC1979k c() {
        return this.f18901a;
    }

    public final boolean d() {
        return this.f18902b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1981l)) {
            return false;
        }
        C1981l c1981l = (C1981l) obj;
        return this.f18901a == c1981l.f18901a && this.f18902b == c1981l.f18902b;
    }

    public int hashCode() {
        return (this.f18901a.hashCode() * 31) + Boolean.hashCode(this.f18902b);
    }

    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.f18901a + ", isForWarningOnly=" + this.f18902b + ')';
    }

    public /* synthetic */ C1981l(EnumC1979k enumC1979k, boolean z7, int i8, AbstractC2296k abstractC2296k) {
        this(enumC1979k, (i8 & 2) != 0 ? false : z7);
    }
}
