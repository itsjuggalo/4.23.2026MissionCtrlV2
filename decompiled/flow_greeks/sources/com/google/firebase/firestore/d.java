package com.google.firebase.firestore;

import d9.s1;
import java.util.Map;
import n9.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FirebaseFirestore f6140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j9.k f6141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j9.h f6142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s1 f6143d;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.google.firebase.firestore.d$a, still in use, count: 1, list:
      (r0v0 com.google.firebase.firestore.d$a) from 0x0024: SPUT (r0v0 com.google.firebase.firestore.d$a) (LINE:37) com.google.firebase.firestore.d.a.d com.google.firebase.firestore.d$a
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        NONE,
        ESTIMATE,
        PREVIOUS;


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f6147d = new a();

        static {
        }

        public a() {
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f6148e.clone();
        }
    }

    public d(FirebaseFirestore firebaseFirestore, j9.k kVar, j9.h hVar, boolean z10, boolean z11) {
        this.f6140a = (FirebaseFirestore) x.b(firebaseFirestore);
        this.f6141b = (j9.k) x.b(kVar);
        this.f6142c = hVar;
        this.f6143d = new s1(z11, z10);
    }

    public static d b(FirebaseFirestore firebaseFirestore, j9.h hVar, boolean z10, boolean z11) {
        return new d(firebaseFirestore, hVar.getKey(), hVar, z10, z11);
    }

    public static d c(FirebaseFirestore firebaseFirestore, j9.k kVar, boolean z10) {
        return new d(firebaseFirestore, kVar, null, z10, false);
    }

    public boolean a() {
        return this.f6142c != null;
    }

    public Map d() {
        return e(a.f6147d);
    }

    public Map e(a aVar) {
        x.c(aVar, "Provided serverTimestampBehavior value must not be null.");
        m mVar = new m(this.f6140a, aVar);
        j9.h hVar = this.f6142c;
        if (hVar == null) {
            return null;
        }
        return mVar.b(hVar.getData().k());
    }

    public boolean equals(Object obj) {
        j9.h hVar;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f6140a.equals(dVar.f6140a) && this.f6141b.equals(dVar.f6141b) && this.f6143d.equals(dVar.f6143d) && ((hVar = this.f6142c) != null ? !(dVar.f6142c == null || !hVar.getData().equals(dVar.f6142c.getData())) : dVar.f6142c == null);
    }

    public s1 f() {
        return this.f6143d;
    }

    public c g() {
        return new c(this.f6141b, this.f6140a);
    }

    public int hashCode() {
        int iHashCode = ((this.f6140a.hashCode() * 31) + this.f6141b.hashCode()) * 31;
        j9.h hVar = this.f6142c;
        int iHashCode2 = (iHashCode + (hVar != null ? hVar.getKey().hashCode() : 0)) * 31;
        j9.h hVar2 = this.f6142c;
        return ((iHashCode2 + (hVar2 != null ? hVar2.getData().hashCode() : 0)) * 31) + this.f6143d.hashCode();
    }

    public String toString() {
        return "DocumentSnapshot{key=" + this.f6141b + ", metadata=" + this.f6143d + ", doc=" + this.f6142c + '}';
    }
}
