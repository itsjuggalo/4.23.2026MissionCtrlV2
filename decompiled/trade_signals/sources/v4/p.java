package v4;

/* JADX INFO: loaded from: classes.dex */
public interface p {

    public class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f23860a;

        public a(k kVar) {
            this.f23860a = kVar;
        }

        @Override // v4.l
        public int a() {
            return this.f23860a.f23838c;
        }

        @Override // v4.l
        public boolean b() {
            return this.f23860a.F();
        }
    }

    static p a(String str, int i8, int i9) {
        return i8 == 1 ? new t(str, i9) : new r(str, i8, i9);
    }

    void b(m mVar);

    void c();

    default void d(k kVar, Runnable runnable) {
        b(new m(kVar == null ? null : new a(kVar), runnable));
    }

    void start();
}
