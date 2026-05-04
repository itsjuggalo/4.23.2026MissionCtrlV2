package com.google.firebase.firestore;

import com.google.firebase.firestore.d;
import java.util.Map;
import n9.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j extends d {
    public j(FirebaseFirestore firebaseFirestore, j9.k kVar, j9.h hVar, boolean z10, boolean z11) {
        super(firebaseFirestore, kVar, hVar, z10, z11);
    }

    public static j h(FirebaseFirestore firebaseFirestore, j9.h hVar, boolean z10, boolean z11) {
        return new j(firebaseFirestore, hVar.getKey(), hVar, z10, z11);
    }

    @Override // com.google.firebase.firestore.d
    public Map d() {
        Map mapD = super.d();
        n9.b.d(mapD != null, "Data in a QueryDocumentSnapshot should be non-null", new Object[0]);
        return mapD;
    }

    @Override // com.google.firebase.firestore.d
    public Map e(d.a aVar) {
        x.c(aVar, "Provided serverTimestampBehavior value must not be null.");
        Map mapE = super.e(aVar);
        n9.b.d(mapE != null, "Data in a QueryDocumentSnapshot should be non-null", new Object[0]);
        return mapE;
    }
}
