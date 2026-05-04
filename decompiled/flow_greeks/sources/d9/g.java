package d9;

import com.google.firebase.firestore.FirebaseFirestore;
import g9.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f7866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.firebase.firestore.j f7867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7869d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7870a;

        static {
            int[] iArr = new int[m.a.values().length];
            f7870a = iArr;
            try {
                iArr[m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7870a[m.a.METADATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7870a[m.a.MODIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7870a[m.a.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        ADDED,
        MODIFIED,
        REMOVED
    }

    public g(com.google.firebase.firestore.j jVar, b bVar, int i10, int i11) {
        this.f7866a = bVar;
        this.f7867b = jVar;
        this.f7868c = i10;
        this.f7869d = i11;
    }

    public static List a(FirebaseFirestore firebaseFirestore, b1 b1Var, g9.y1 y1Var) {
        int iP;
        int iP2;
        ArrayList arrayList = new ArrayList();
        if (y1Var.g().isEmpty()) {
            j9.h hVar = null;
            int i10 = 0;
            for (g9.m mVar : y1Var.d()) {
                j9.h hVarB = mVar.b();
                com.google.firebase.firestore.j jVarH = com.google.firebase.firestore.j.h(firebaseFirestore, hVarB, y1Var.k(), y1Var.f().contains(hVarB.getKey()));
                n9.b.d(mVar.c() == m.a.ADDED, "Invalid added event for first snapshot", new Object[0]);
                n9.b.d(hVar == null || y1Var.h().c().compare(hVar, hVarB) < 0, "Got added events in wrong order", new Object[0]);
                arrayList.add(new g(jVarH, b.ADDED, -1, i10));
                hVar = hVarB;
                i10++;
            }
        } else {
            j9.m mVarG = y1Var.g();
            for (g9.m mVar2 : y1Var.d()) {
                if (b1Var != b1.EXCLUDE || mVar2.c() != m.a.METADATA) {
                    j9.h hVarB2 = mVar2.b();
                    com.google.firebase.firestore.j jVarH2 = com.google.firebase.firestore.j.h(firebaseFirestore, hVarB2, y1Var.k(), y1Var.f().contains(hVarB2.getKey()));
                    b bVarF = f(mVar2);
                    if (bVarF != b.ADDED) {
                        iP = mVarG.p(hVarB2.getKey());
                        n9.b.d(iP >= 0, "Index for document not found", new Object[0]);
                        mVarG = mVarG.q(hVarB2.getKey());
                    } else {
                        iP = -1;
                    }
                    if (bVarF != b.REMOVED) {
                        mVarG = mVarG.c(hVarB2);
                        iP2 = mVarG.p(hVarB2.getKey());
                        n9.b.d(iP2 >= 0, "Index for document not found", new Object[0]);
                    } else {
                        iP2 = -1;
                    }
                    arrayList.add(new g(jVarH2, bVarF, iP, iP2));
                }
            }
        }
        return arrayList;
    }

    public static b f(g9.m mVar) {
        int i10 = a.f7870a[mVar.c().ordinal()];
        if (i10 == 1) {
            return b.ADDED;
        }
        if (i10 == 2 || i10 == 3) {
            return b.MODIFIED;
        }
        if (i10 == 4) {
            return b.REMOVED;
        }
        throw new IllegalArgumentException("Unknown view change type: " + mVar.c());
    }

    public com.google.firebase.firestore.j b() {
        return this.f7867b;
    }

    public int c() {
        return this.f7869d;
    }

    public int d() {
        return this.f7868c;
    }

    public b e() {
        return this.f7866a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.f7866a.equals(gVar.f7866a) && this.f7867b.equals(gVar.f7867b) && this.f7868c == gVar.f7868c && this.f7869d == gVar.f7869d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f7866a.hashCode() * 31) + this.f7867b.hashCode()) * 31) + this.f7868c) * 31) + this.f7869d;
    }
}
