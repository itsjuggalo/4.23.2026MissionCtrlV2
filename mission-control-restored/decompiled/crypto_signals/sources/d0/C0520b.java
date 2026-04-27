package d0;

import N1.D0;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.j;

/* JADX INFO: renamed from: d0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0520b extends D0 {
    public /* synthetic */ C0520b(int i) {
        this(C0519a.f5946b);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0520b(D0 initialExtras) {
        super(1);
        j.e(initialExtras, "initialExtras");
        ((LinkedHashMap) this.f1130a).putAll((LinkedHashMap) initialExtras.f1130a);
    }
}
