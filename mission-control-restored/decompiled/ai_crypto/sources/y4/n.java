package y4;

/* JADX INFO: loaded from: classes2.dex */
public interface n {

    public class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f25733a;

        public a(i iVar) {
            this.f25733a = iVar;
        }

        @Override // y4.j
        public int a() {
            return this.f25733a.f25711c;
        }

        @Override // y4.j
        public boolean b() {
            return this.f25733a.F();
        }
    }

    static n b(String str, int i7, int i8) {
        return i7 == 1 ? new r(str, i8) : new p(str, i7, i8);
    }

    void a(k kVar);

    void c();

    default void d(i iVar, Runnable runnable) {
        a(new k(iVar == null ? null : new a(iVar), runnable));
    }

    void start();
}
