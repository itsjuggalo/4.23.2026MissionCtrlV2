package y0;

import android.os.Bundle;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends Exception {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f25156c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f25158b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final h a(Bundle bundle) {
            t.f(bundle, "bundle");
            String string = bundle.getString("androidx.credentials.provider.extra.CREATE_CREDENTIAL_EXCEPTION_TYPE");
            if (string != null) {
                return b1.a.a(string, bundle.getCharSequence("androidx.credentials.provider.extra.CREATE_CREDENTIAL_EXCEPTION_MESSAGE"));
            }
            throw new IllegalArgumentException("Bundle was missing exception type.");
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(String type, CharSequence charSequence) {
        super(charSequence != null ? charSequence.toString() : null);
        t.f(type, "type");
        this.f25157a = type;
        this.f25158b = charSequence;
    }
}
