package c0;

import b6.InterfaceC1102x;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    public static final class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Q5.o f9288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC1102x f9289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final v f9290c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final H5.g f9291d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Q5.o transform, InterfaceC1102x ack, v vVar, H5.g callerContext) {
            super(null);
            kotlin.jvm.internal.r.f(transform, "transform");
            kotlin.jvm.internal.r.f(ack, "ack");
            kotlin.jvm.internal.r.f(callerContext, "callerContext");
            this.f9288a = transform;
            this.f9289b = ack;
            this.f9290c = vVar;
            this.f9291d = callerContext;
        }

        public final InterfaceC1102x a() {
            return this.f9289b;
        }

        public final H5.g b() {
            return this.f9291d;
        }

        public v c() {
            return this.f9290c;
        }

        public final Q5.o d() {
            return this.f9288a;
        }
    }

    public /* synthetic */ p(AbstractC2148j abstractC2148j) {
        this();
    }

    public p() {
    }
}
