package b4;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: b4.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1202e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f12896a;

    /* JADX INFO: renamed from: b4.e$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map f12897a = new HashMap();

        public C1202e b() {
            return new C1202e(this);
        }

        public a c(String str, double d8) {
            this.f12897a.put(str, Double.toString(d8));
            return this;
        }

        public a d(String str, long j8) {
            this.f12897a.put(str, Long.toString(j8));
            return this;
        }

        public a e(String str, String str2) {
            this.f12897a.put(str, str2);
            return this;
        }
    }

    public C1202e(a aVar) {
        this.f12896a = aVar.f12897a;
    }
}
