package r2;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f19229c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19231b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends i {
        public a(String str, String str2) {
            super(str, str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends i {
        public b(String str, String str2) {
            super(str, str2);
        }
    }

    public i(String str, String str2) {
        this.f19230a = str;
        this.f19231b = str2;
        f19229c.add(this);
    }
}
