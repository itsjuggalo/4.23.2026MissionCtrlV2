package Z3;

import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class M implements L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final M f5875a = new M();

    @Override // Z3.L
    public UUID next() {
        UUID uuidRandomUUID = UUID.randomUUID();
        kotlin.jvm.internal.r.e(uuidRandomUUID, "randomUUID()");
        return uuidRandomUUID;
    }
}
