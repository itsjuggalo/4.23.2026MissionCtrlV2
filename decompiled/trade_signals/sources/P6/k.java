package P6;

import P6.f;
import R5.InterfaceC0868z;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6508a;

    public static final class a extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f6509b = new a();

        public a() {
            super("must be a member function", null);
        }

        @Override // P6.f
        public boolean a(InterfaceC0868z functionDescriptor) {
            AbstractC2304t.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.g0() != null;
        }
    }

    public static final class b extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f6510b = new b();

        public b() {
            super("must be a member or an extension function", null);
        }

        @Override // P6.f
        public boolean a(InterfaceC0868z functionDescriptor) {
            AbstractC2304t.f(functionDescriptor, "functionDescriptor");
            return (functionDescriptor.g0() == null && functionDescriptor.l0() == null) ? false : true;
        }
    }

    public k(String str) {
        this.f6508a = str;
    }

    @Override // P6.f
    public String b(InterfaceC0868z interfaceC0868z) {
        return f.a.a(this, interfaceC0868z);
    }

    @Override // P6.f
    public String getDescription() {
        return this.f6508a;
    }

    public /* synthetic */ k(String str, AbstractC2296k abstractC2296k) {
        this(str);
    }
}
