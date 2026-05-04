package io.flutter.plugins.firebase.firestore.utils;

import com.google.firebase.firestore.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class ServerTimestampBehaviorConverter {
    public static d.a toServerTimestampBehavior(String str) {
        if (str == null) {
            return d.a.NONE;
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -1959779032) {
            if (iHashCode != -1273775369) {
                if (iHashCode == 3387192) {
                    str.equals("none");
                }
            } else if (str.equals("previous")) {
                return d.a.PREVIOUS;
            }
        } else if (str.equals("estimate")) {
            return d.a.ESTIMATE;
        }
        return d.a.NONE;
    }
}
