package io.flutter.plugins.firebase.firestore.streamhandler;

import io.flutter.plugins.firebase.firestore.GeneratedAndroidFirebaseFirestore;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface OnTransactionResultListener {
    void receiveTransactionResponse(GeneratedAndroidFirebaseFirestore.PigeonTransactionResult pigeonTransactionResult, List<GeneratedAndroidFirebaseFirestore.PigeonTransactionCommand> list);
}
