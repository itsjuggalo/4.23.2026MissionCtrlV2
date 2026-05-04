package oe;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final we.l f18097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Collection f18098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18099c;

    public w(we.l nullabilityQualifier, Collection qualifierApplicabilityTypes, boolean z10) {
        kotlin.jvm.internal.t.f(nullabilityQualifier, "nullabilityQualifier");
        kotlin.jvm.internal.t.f(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        this.f18097a = nullabilityQualifier;
        this.f18098b = qualifierApplicabilityTypes;
        this.f18099c = z10;
    }

    public static /* synthetic */ w b(w wVar, we.l lVar, Collection collection, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = wVar.f18097a;
        }
        if ((i10 & 2) != 0) {
            collection = wVar.f18098b;
        }
        if ((i10 & 4) != 0) {
            z10 = wVar.f18099c;
        }
        return wVar.a(lVar, collection, z10);
    }

    public final w a(we.l nullabilityQualifier, Collection qualifierApplicabilityTypes, boolean z10) {
        kotlin.jvm.internal.t.f(nullabilityQualifier, "nullabilityQualifier");
        kotlin.jvm.internal.t.f(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        return new w(nullabilityQualifier, qualifierApplicabilityTypes, z10);
    }

    public final boolean c() {
        return this.f18099c;
    }

    public final we.l d() {
        return this.f18097a;
    }

    public final Collection e() {
        return this.f18098b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return kotlin.jvm.internal.t.b(this.f18097a, wVar.f18097a) && kotlin.jvm.internal.t.b(this.f18098b, wVar.f18098b) && this.f18099c == wVar.f18099c;
    }

    public int hashCode() {
        return (((this.f18097a.hashCode() * 31) + this.f18098b.hashCode()) * 31) + Boolean.hashCode(this.f18099c);
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.f18097a + ", qualifierApplicabilityTypes=" + this.f18098b + ", definitelyNotNull=" + this.f18099c + ')';
    }

    public /* synthetic */ w(we.l lVar, Collection collection, boolean z10, int i10, kotlin.jvm.internal.k kVar) {
        this(lVar, collection, (i10 & 4) != 0 ? lVar.c() == we.k.f23994c : z10);
    }
}
