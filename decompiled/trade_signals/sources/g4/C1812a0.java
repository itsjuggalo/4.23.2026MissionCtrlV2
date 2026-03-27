package g4;

import java.util.UUID;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: g4.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1812a0 implements InterfaceC1810Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1812a0 f18135a = new C1812a0();

    @Override // g4.InterfaceC1810Z
    public UUID next() {
        UUID uuidRandomUUID = UUID.randomUUID();
        AbstractC2304t.e(uuidRandomUUID, "randomUUID(...)");
        return uuidRandomUUID;
    }
}
