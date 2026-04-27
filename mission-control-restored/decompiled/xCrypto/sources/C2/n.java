package C2;

/* JADX INFO: loaded from: classes3.dex */
public interface n {

    public class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f212a;

        public a(i iVar) {
            this.f212a = iVar;
        }

        @Override // C2.j
        public int a() {
            return this.f212a.f190c;
        }

        @Override // C2.j
        public boolean b() {
            return this.f212a.F();
        }
    }

    static n a(String str, int i4, int i5) {
        return i4 == 1 ? new r(str, i5) : new p(str, i4, i5);
    }

    default void b(i iVar, Runnable runnable) {
        d(new k(iVar == null ? null : new a(iVar), runnable));
    }

    void c();

    void d(k kVar);

    void start();
}
