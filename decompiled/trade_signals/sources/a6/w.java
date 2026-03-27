package a6;

import i6.C1981l;
import i6.EnumC1979k;
import java.util.Collection;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1981l f10160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Collection f10161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10162c;

    public w(C1981l nullabilityQualifier, Collection qualifierApplicabilityTypes, boolean z7) {
        AbstractC2304t.f(nullabilityQualifier, "nullabilityQualifier");
        AbstractC2304t.f(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        this.f10160a = nullabilityQualifier;
        this.f10161b = qualifierApplicabilityTypes;
        this.f10162c = z7;
    }

    public static /* synthetic */ w b(w wVar, C1981l c1981l, Collection collection, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            c1981l = wVar.f10160a;
        }
        if ((i8 & 2) != 0) {
            collection = wVar.f10161b;
        }
        if ((i8 & 4) != 0) {
            z7 = wVar.f10162c;
        }
        return wVar.a(c1981l, collection, z7);
    }

    public final w a(C1981l nullabilityQualifier, Collection qualifierApplicabilityTypes, boolean z7) {
        AbstractC2304t.f(nullabilityQualifier, "nullabilityQualifier");
        AbstractC2304t.f(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        return new w(nullabilityQualifier, qualifierApplicabilityTypes, z7);
    }

    public final boolean c() {
        return this.f10162c;
    }

    public final C1981l d() {
        return this.f10160a;
    }

    public final Collection e() {
        return this.f10161b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return AbstractC2304t.b(this.f10160a, wVar.f10160a) && AbstractC2304t.b(this.f10161b, wVar.f10161b) && this.f10162c == wVar.f10162c;
    }

    public int hashCode() {
        return (((this.f10160a.hashCode() * 31) + this.f10161b.hashCode()) * 31) + Boolean.hashCode(this.f10162c);
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.f10160a + ", qualifierApplicabilityTypes=" + this.f10161b + ", definitelyNotNull=" + this.f10162c + ')';
    }

    public /* synthetic */ w(C1981l c1981l, Collection collection, boolean z7, int i8, AbstractC2296k abstractC2296k) {
        this(c1981l, collection, (i8 & 4) != 0 ? c1981l.c() == EnumC1979k.f18897c : z7);
    }
}
