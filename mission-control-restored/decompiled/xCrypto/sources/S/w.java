package S;

import kotlin.jvm.internal.AbstractC1585j;
import t3.InterfaceC1847x;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    public static final class a extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i3.o f3819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC1847x f3820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final D f3821c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Z2.i f3822d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i3.o transform, InterfaceC1847x ack, D d4, Z2.i callerContext) {
            super(null);
            kotlin.jvm.internal.r.f(transform, "transform");
            kotlin.jvm.internal.r.f(ack, "ack");
            kotlin.jvm.internal.r.f(callerContext, "callerContext");
            this.f3819a = transform;
            this.f3820b = ack;
            this.f3821c = d4;
            this.f3822d = callerContext;
        }

        public final InterfaceC1847x a() {
            return this.f3820b;
        }

        public final Z2.i b() {
            return this.f3822d;
        }

        public D c() {
            return this.f3821c;
        }

        public final i3.o d() {
            return this.f3819a;
        }
    }

    public /* synthetic */ w(AbstractC1585j abstractC1585j) {
        this();
    }

    public w() {
    }
}
