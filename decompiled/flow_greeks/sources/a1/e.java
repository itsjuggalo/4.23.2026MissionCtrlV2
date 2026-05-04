package a1;

import kg.z;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import y0.g;
import y0.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f14e = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public final h a(String type, String str) {
            t.f(type, "type");
            try {
                if (z.J(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION", false, 2, null)) {
                    return d.f12g.a(type, str);
                }
                throw new b1.b();
            } catch (b1.b unused) {
                return new g(type, str);
            }
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String type, CharSequence charSequence) {
        super(type, charSequence);
        t.f(type, "type");
        this.f15d = type;
        if (a().length() <= 0) {
            throw new IllegalArgumentException("type must not be empty");
        }
    }

    public String a() {
        return this.f15d;
    }
}
