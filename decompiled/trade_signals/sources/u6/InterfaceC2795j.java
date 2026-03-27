package u6;

import R5.InterfaceC0844a;
import R5.InterfaceC0848e;

/* JADX INFO: renamed from: u6.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2795j {

    /* JADX INFO: renamed from: u6.j$a */
    public enum a {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH
    }

    /* JADX INFO: renamed from: u6.j$b */
    public enum b {
        OVERRIDABLE,
        INCOMPATIBLE,
        UNKNOWN
    }

    b a(InterfaceC0844a interfaceC0844a, InterfaceC0844a interfaceC0844a2, InterfaceC0848e interfaceC0848e);

    a b();
}
