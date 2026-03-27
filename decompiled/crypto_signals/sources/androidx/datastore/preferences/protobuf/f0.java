package androidx.datastore.preferences.protobuf;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public final class f0 extends h0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4549b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(Unsafe unsafe, int i) {
        super(unsafe);
        this.f4549b = i;
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final boolean c(Object obj, long j4) {
        switch (this.f4549b) {
            case 0:
                if (!i0.f4571g) {
                }
                break;
            default:
                if (!i0.f4571g) {
                }
                break;
        }
        return i0.c(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final double d(Object obj, long j4) {
        switch (this.f4549b) {
        }
        return Double.longBitsToDouble(g(obj, j4));
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final float e(Object obj, long j4) {
        switch (this.f4549b) {
        }
        return Float.intBitsToFloat(f(obj, j4));
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final void j(Object obj, long j4, boolean z6) {
        switch (this.f4549b) {
            case 0:
                if (!i0.f4571g) {
                    i0.l(obj, j4, z6 ? (byte) 1 : (byte) 0);
                } else {
                    i0.k(obj, j4, z6 ? (byte) 1 : (byte) 0);
                }
                break;
            default:
                if (!i0.f4571g) {
                    i0.l(obj, j4, z6 ? (byte) 1 : (byte) 0);
                } else {
                    i0.k(obj, j4, z6 ? (byte) 1 : (byte) 0);
                }
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final void k(Object obj, long j4, byte b3) {
        switch (this.f4549b) {
            case 0:
                if (!i0.f4571g) {
                    i0.l(obj, j4, b3);
                } else {
                    i0.k(obj, j4, b3);
                }
                break;
            default:
                if (!i0.f4571g) {
                    i0.l(obj, j4, b3);
                } else {
                    i0.k(obj, j4, b3);
                }
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final void l(Object obj, long j4, double d4) {
        switch (this.f4549b) {
            case 0:
                o(obj, j4, Double.doubleToLongBits(d4));
                break;
            default:
                o(obj, j4, Double.doubleToLongBits(d4));
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final void m(Object obj, long j4, float f6) {
        switch (this.f4549b) {
            case 0:
                n(obj, j4, Float.floatToIntBits(f6));
                break;
            default:
                n(obj, j4, Float.floatToIntBits(f6));
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final boolean r() {
        switch (this.f4549b) {
        }
        return false;
    }
}
