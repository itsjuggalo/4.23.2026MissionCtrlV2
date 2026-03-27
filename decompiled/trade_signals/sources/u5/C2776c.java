package u5;

import s5.InterfaceC2707e;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: u5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2776c implements InterfaceC2707e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2776c f23520a = new C2776c();

    @Override // s5.InterfaceC2707e
    public InterfaceC2711i getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // s5.InterfaceC2707e
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
