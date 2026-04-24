package Y3;

import com.google.firebase.messaging.N;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f9598b = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Y3.a f9599a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Y3.a f9600a = null;

        public b a() {
            return new b(this.f9600a);
        }

        public a b(Y3.a aVar) {
            this.f9600a = aVar;
            return this;
        }
    }

    public b(Y3.a aVar) {
        this.f9599a = aVar;
    }

    public static a b() {
        return new a();
    }

    public Y3.a a() {
        return this.f9599a;
    }

    public byte[] c() {
        return N.a(this);
    }
}
