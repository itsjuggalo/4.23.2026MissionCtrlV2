package P6;

import P6.f;
import R5.InterfaceC0868z;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class A implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6481a;

    public static final class a extends A {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6482b;

        public a(int i8) {
            StringBuilder sb = new StringBuilder();
            sb.append("must have at least ");
            sb.append(i8);
            sb.append(" value parameter");
            sb.append(i8 > 1 ? "s" : "");
            super(sb.toString(), null);
            this.f6482b = i8;
        }

        @Override // P6.f
        public boolean a(InterfaceC0868z functionDescriptor) {
            AbstractC2304t.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.k().size() >= this.f6482b;
        }
    }

    public static final class b extends A {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6483b;

        public b(int i8) {
            super("must have exactly " + i8 + " value parameters", null);
            this.f6483b = i8;
        }

        @Override // P6.f
        public boolean a(InterfaceC0868z functionDescriptor) {
            AbstractC2304t.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.k().size() == this.f6483b;
        }
    }

    public static final class c extends A {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f6484b = new c();

        public c() {
            super("must have no value parameters", null);
        }

        @Override // P6.f
        public boolean a(InterfaceC0868z functionDescriptor) {
            AbstractC2304t.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.k().isEmpty();
        }
    }

    public static final class d extends A {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f6485b = new d();

        public d() {
            super("must have a single value parameter", null);
        }

        @Override // P6.f
        public boolean a(InterfaceC0868z functionDescriptor) {
            AbstractC2304t.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.k().size() == 1;
        }
    }

    public A(String str) {
        this.f6481a = str;
    }

    @Override // P6.f
    public String b(InterfaceC0868z interfaceC0868z) {
        return f.a.a(this, interfaceC0868z);
    }

    @Override // P6.f
    public String getDescription() {
        return this.f6481a;
    }

    public /* synthetic */ A(String str, AbstractC2296k abstractC2296k) {
        this(str);
    }
}
