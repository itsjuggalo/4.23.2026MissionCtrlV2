package d7;

import Y6.O0;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public final class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2711i f17036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f17037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final O0[] f17038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17039d;

    public O(InterfaceC2711i interfaceC2711i, int i8) {
        this.f17036a = interfaceC2711i;
        this.f17037b = new Object[i8];
        this.f17038c = new O0[i8];
    }

    public final void a(O0 o02, Object obj) {
        Object[] objArr = this.f17037b;
        int i8 = this.f17039d;
        objArr[i8] = obj;
        O0[] o0Arr = this.f17038c;
        this.f17039d = i8 + 1;
        AbstractC2304t.d(o02, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        o0Arr[i8] = o02;
    }

    public final void b(InterfaceC2711i interfaceC2711i) {
        int length = this.f17038c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i8 = length - 1;
            O0 o02 = this.f17038c[length];
            AbstractC2304t.c(o02);
            o02.s0(interfaceC2711i, this.f17037b[length]);
            if (i8 < 0) {
                return;
            } else {
                length = i8;
            }
        }
    }
}
