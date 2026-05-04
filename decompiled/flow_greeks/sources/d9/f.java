package d9;

import com.google.firebase.firestore.FirebaseFirestore;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f extends com.google.firebase.firestore.i {
    public f(j9.t tVar, FirebaseFirestore firebaseFirestore) {
        super(g9.b1.b(tVar), firebaseFirestore);
        if (tVar.u() % 2 == 1) {
            return;
        }
        throw new IllegalArgumentException("Invalid collection reference. Collection references must have an odd number of segments, but " + tVar.c() + " has " + tVar.u());
    }
}
