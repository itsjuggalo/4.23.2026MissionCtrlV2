package x0;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class u extends c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(String type, Bundle data) {
        super(type, data);
        kotlin.jvm.internal.t.f(type, "type");
        kotlin.jvm.internal.t.f(data, "data");
        if (type.length() <= 0) {
            throw new IllegalArgumentException("type should not be empty");
        }
    }
}
