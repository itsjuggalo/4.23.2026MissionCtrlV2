package io.flutter.plugins.firebase.firestore;

import com.google.firebase.firestore.FirebaseFirestore;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseFirestoreExtension {
    private final String databaseURL;
    private final FirebaseFirestore instance;

    public FlutterFirebaseFirestoreExtension(FirebaseFirestore firebaseFirestore, String str) {
        this.instance = firebaseFirestore;
        this.databaseURL = str;
    }

    public String getDatabaseURL() {
        return this.databaseURL;
    }

    public FirebaseFirestore getInstance() {
        return this.instance;
    }
}
