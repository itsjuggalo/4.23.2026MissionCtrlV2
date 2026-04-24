package s6;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends w {
    public static final s INSTANCE = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f23063a = "null";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ E5.j f23064b = E5.k.a(E5.l.f1675b, a.f23065a);

    public static final class a extends kotlin.jvm.internal.s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f23065a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final n6.b invoke() {
            return t.f23066a;
        }
    }

    public s() {
        super(null);
    }

    @Override // s6.w
    public String a() {
        return f23063a;
    }

    @Override // s6.w
    public boolean c() {
        return false;
    }

    public final /* synthetic */ n6.b g() {
        return (n6.b) f23064b.getValue();
    }

    public final n6.b serializer() {
        return g();
    }
}
