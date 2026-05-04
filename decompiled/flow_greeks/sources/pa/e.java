package pa;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f18431a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map f18432a = new HashMap();

        public e b() {
            return new e(this);
        }

        public a c(String str, double d10) {
            this.f18432a.put(str, Double.toString(d10));
            return this;
        }

        public a d(String str, long j10) {
            this.f18432a.put(str, Long.toString(j10));
            return this;
        }

        public a e(String str, String str2) {
            this.f18432a.put(str, str2);
            return this;
        }
    }

    public e(a aVar) {
        this.f18431a = aVar.f18432a;
    }
}
