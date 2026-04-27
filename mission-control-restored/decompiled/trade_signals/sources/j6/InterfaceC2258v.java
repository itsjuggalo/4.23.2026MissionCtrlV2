package j6;

import h6.InterfaceC1898g;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p6.C2602e;

/* JADX INFO: renamed from: j6.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2258v extends E6.A {

    /* JADX INFO: renamed from: j6.v$a */
    public static abstract class a {

        /* JADX INFO: renamed from: j6.v$a$a, reason: collision with other inner class name */
        public static final class C0335a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final InterfaceC2260x f20233a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final byte[] f20234b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0335a(InterfaceC2260x kotlinJvmBinaryClass, byte[] bArr) {
                super(null);
                AbstractC2304t.f(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.f20233a = kotlinJvmBinaryClass;
                this.f20234b = bArr;
            }

            public final InterfaceC2260x b() {
                return this.f20233a;
            }

            public /* synthetic */ C0335a(InterfaceC2260x interfaceC2260x, byte[] bArr, int i8, AbstractC2296k abstractC2296k) {
                this(interfaceC2260x, (i8 & 2) != 0 ? null : bArr);
            }
        }

        public a() {
        }

        public final InterfaceC2260x a() {
            C0335a c0335a = this instanceof C0335a ? (C0335a) this : null;
            if (c0335a != null) {
                return c0335a.b();
            }
            return null;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    a b(InterfaceC1898g interfaceC1898g, C2602e c2602e);

    a c(q6.b bVar, C2602e c2602e);
}
