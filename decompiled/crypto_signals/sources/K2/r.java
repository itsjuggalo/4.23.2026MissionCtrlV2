package K2;

import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FirebaseFirestore f966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q2.h f967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Q2.k f968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h0 f969d;

    public r(FirebaseFirestore firebaseFirestore, Q2.h hVar, Q2.k kVar, boolean z6, boolean z7) {
        firebaseFirestore.getClass();
        this.f966a = firebaseFirestore;
        hVar.getClass();
        this.f967b = hVar;
        this.f968c = kVar;
        this.f969d = new h0(z7, z6);
    }

    public HashMap a(EnumC0066q enumC0066q) {
        s3.D.k(enumC0066q, "Provided serverTimestampBehavior value must not be null.");
        A.c cVar = new A.c(6, this.f966a, enumC0066q);
        Q2.k kVar = this.f968c;
        if (kVar == null) {
            return null;
        }
        return cVar.e(kVar.e.b().L().w());
    }

    public Map b() {
        return a(EnumC0066q.f965d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f966a.equals(rVar.f966a) && this.f967b.equals(rVar.f967b) && this.f969d.equals(rVar.f969d)) {
            Q2.k kVar = rVar.f968c;
            Q2.k kVar2 = this.f968c;
            if (kVar2 != null ? !(kVar == null || !kVar2.e.equals(kVar.e)) : kVar == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f967b.f2674a.hashCode() + (this.f966a.hashCode() * 31)) * 31;
        Q2.k kVar = this.f968c;
        return this.f969d.hashCode() + ((((iHashCode + (kVar != null ? kVar.f2679a.f2674a.hashCode() : 0)) * 31) + (kVar != null ? kVar.e.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "DocumentSnapshot{key=" + this.f967b + ", metadata=" + this.f969d + ", doc=" + this.f968c + '}';
    }
}
