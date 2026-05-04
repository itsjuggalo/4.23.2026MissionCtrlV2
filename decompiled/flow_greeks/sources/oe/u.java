package oe;

import java.util.Arrays;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface u {
    Set a(ef.c cVar);

    ve.u b(ef.c cVar, boolean z10);

    ve.g c(a aVar);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ef.b f18093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f18094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ve.g f18095c;

        public a(ef.b classId, byte[] bArr, ve.g gVar) {
            kotlin.jvm.internal.t.f(classId, "classId");
            this.f18093a = classId;
            this.f18094b = bArr;
            this.f18095c = gVar;
        }

        public final ef.b a() {
            return this.f18093a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.t.b(this.f18093a, aVar.f18093a) && kotlin.jvm.internal.t.b(this.f18094b, aVar.f18094b) && kotlin.jvm.internal.t.b(this.f18095c, aVar.f18095c);
        }

        public int hashCode() {
            int iHashCode = this.f18093a.hashCode() * 31;
            byte[] bArr = this.f18094b;
            int iHashCode2 = (iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            ve.g gVar = this.f18095c;
            return iHashCode2 + (gVar != null ? gVar.hashCode() : 0);
        }

        public String toString() {
            return "Request(classId=" + this.f18093a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.f18094b) + ", outerClass=" + this.f18095c + ')';
        }

        public /* synthetic */ a(ef.b bVar, byte[] bArr, ve.g gVar, int i10, kotlin.jvm.internal.k kVar) {
            this(bVar, (i10 & 2) != 0 ? null : bArr, (i10 & 4) != 0 ? null : gVar);
        }
    }
}
