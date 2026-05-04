package ua;

import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z0 f22724a = new z0();

    @Override // ua.y0
    public UUID next() {
        UUID uuidRandomUUID = UUID.randomUUID();
        kotlin.jvm.internal.t.e(uuidRandomUUID, "randomUUID(...)");
        return uuidRandomUUID;
    }
}
