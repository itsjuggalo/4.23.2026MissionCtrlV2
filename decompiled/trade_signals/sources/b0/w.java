package b0;

import Y6.InterfaceC1034v;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    public static final class a extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final B5.o f12810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC1034v f12811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final I f12812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final InterfaceC2711i f12813d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(B5.o transform, InterfaceC1034v ack, I i8, InterfaceC2711i callerContext) {
            super(null);
            AbstractC2304t.f(transform, "transform");
            AbstractC2304t.f(ack, "ack");
            AbstractC2304t.f(callerContext, "callerContext");
            this.f12810a = transform;
            this.f12811b = ack;
            this.f12812c = i8;
            this.f12813d = callerContext;
        }

        public final InterfaceC1034v a() {
            return this.f12811b;
        }

        public final InterfaceC2711i b() {
            return this.f12813d;
        }

        public I c() {
            return this.f12812c;
        }

        public final B5.o d() {
            return this.f12810a;
        }
    }

    public w() {
    }

    public /* synthetic */ w(AbstractC2296k abstractC2296k) {
        this();
    }
}
