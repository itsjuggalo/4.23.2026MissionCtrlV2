package io.flutter.plugins.firebase.firestore;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseFirestoreTransactionResult {
    public final Exception exception;

    private FlutterFirebaseFirestoreTransactionResult(Exception exc) {
        this.exception = exc;
    }

    public static FlutterFirebaseFirestoreTransactionResult complete() {
        return new FlutterFirebaseFirestoreTransactionResult();
    }

    public static FlutterFirebaseFirestoreTransactionResult failed(Exception exc) {
        return new FlutterFirebaseFirestoreTransactionResult(exc);
    }

    private FlutterFirebaseFirestoreTransactionResult() {
        this.exception = null;
    }
}
