package io.flutter.plugins.firebase.firestore;

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
