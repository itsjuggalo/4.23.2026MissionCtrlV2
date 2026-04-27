package com.google.protobuf;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public final class J0 extends L0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5649b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ J0(Unsafe unsafe, int i) {
        super(unsafe);
        this.f5649b = i;
    }

    @Override // com.google.protobuf.L0
    public final void c(long j4, byte[] bArr, long j6, long j7) {
        switch (this.f5649b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.protobuf.L0
    public final boolean d(Object obj, long j4) {
        switch (this.f5649b) {
            case 0:
                if (M0.f5660h) {
                    if (M0.h(obj, j4) == 0) {
                    }
                } else if (M0.i(obj, j4) == 0) {
                }
                break;
            default:
                if (M0.f5660h) {
                    if (M0.h(obj, j4) == 0) {
                    }
                } else if (M0.i(obj, j4) == 0) {
                }
                break;
        }
        return false;
    }

    @Override // com.google.protobuf.L0
    public final byte e(long j4) {
        switch (this.f5649b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.protobuf.L0
    public final byte f(Object obj, long j4) {
        switch (this.f5649b) {
            case 0:
                if (!M0.f5660h) {
                }
                break;
            default:
                if (!M0.f5660h) {
                }
                break;
        }
        return M0.i(obj, j4);
    }

    @Override // com.google.protobuf.L0
    public final double g(Object obj, long j4) {
        switch (this.f5649b) {
        }
        return Double.longBitsToDouble(j(obj, j4));
    }

    @Override // com.google.protobuf.L0
    public final float h(Object obj, long j4) {
        switch (this.f5649b) {
        }
        return Float.intBitsToFloat(i(obj, j4));
    }

    @Override // com.google.protobuf.L0
    public final void m(Object obj, long j4, boolean z6) {
        switch (this.f5649b) {
            case 0:
                if (!M0.f5660h) {
                    M0.m(obj, j4, z6 ? (byte) 1 : (byte) 0);
                } else {
                    M0.l(obj, j4, z6 ? (byte) 1 : (byte) 0);
                }
                break;
            default:
                if (!M0.f5660h) {
                    M0.m(obj, j4, z6 ? (byte) 1 : (byte) 0);
                } else {
                    M0.l(obj, j4, z6 ? (byte) 1 : (byte) 0);
                }
                break;
        }
    }

    @Override // com.google.protobuf.L0
    public final void n(Object obj, long j4, byte b3) {
        switch (this.f5649b) {
            case 0:
                if (!M0.f5660h) {
                    M0.m(obj, j4, b3);
                } else {
                    M0.l(obj, j4, b3);
                }
                break;
            default:
                if (!M0.f5660h) {
                    M0.m(obj, j4, b3);
                } else {
                    M0.l(obj, j4, b3);
                }
                break;
        }
    }

    @Override // com.google.protobuf.L0
    public final void o(Object obj, long j4, double d4) {
        switch (this.f5649b) {
            case 0:
                r(obj, j4, Double.doubleToLongBits(d4));
                break;
            default:
                r(obj, j4, Double.doubleToLongBits(d4));
                break;
        }
    }

    @Override // com.google.protobuf.L0
    public final void p(Object obj, long j4, float f6) {
        switch (this.f5649b) {
            case 0:
                q(obj, j4, Float.floatToIntBits(f6));
                break;
            default:
                q(obj, j4, Float.floatToIntBits(f6));
                break;
        }
    }

    @Override // com.google.protobuf.L0
    public final boolean u() {
        switch (this.f5649b) {
        }
        return false;
    }
}
