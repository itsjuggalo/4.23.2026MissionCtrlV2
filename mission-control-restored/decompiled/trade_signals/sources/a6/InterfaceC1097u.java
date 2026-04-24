package a6;

import h6.InterfaceC1898g;
import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: a6.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC1097u {

    /* JADX INFO: renamed from: a6.u$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q6.b f10156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f10157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InterfaceC1898g f10158c;

        public a(q6.b classId, byte[] bArr, InterfaceC1898g interfaceC1898g) {
            AbstractC2304t.f(classId, "classId");
            this.f10156a = classId;
            this.f10157b = bArr;
            this.f10158c = interfaceC1898g;
        }

        public final q6.b a() {
            return this.f10156a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC2304t.b(this.f10156a, aVar.f10156a) && AbstractC2304t.b(this.f10157b, aVar.f10157b) && AbstractC2304t.b(this.f10158c, aVar.f10158c);
        }

        public int hashCode() {
            int iHashCode = this.f10156a.hashCode() * 31;
            byte[] bArr = this.f10157b;
            int iHashCode2 = (iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            InterfaceC1898g interfaceC1898g = this.f10158c;
            return iHashCode2 + (interfaceC1898g != null ? interfaceC1898g.hashCode() : 0);
        }

        public String toString() {
            return "Request(classId=" + this.f10156a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.f10157b) + ", outerClass=" + this.f10158c + ')';
        }

        public /* synthetic */ a(q6.b bVar, byte[] bArr, InterfaceC1898g interfaceC1898g, int i8, AbstractC2296k abstractC2296k) {
            this(bVar, (i8 & 2) != 0 ? null : bArr, (i8 & 4) != 0 ? null : interfaceC1898g);
        }
    }

    InterfaceC1898g a(a aVar);

    Set b(q6.c cVar);

    h6.u c(q6.c cVar, boolean z7);
}
