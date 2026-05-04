package y0;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends Exception {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f25151c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f25153b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String type, CharSequence charSequence) {
        super(charSequence != null ? charSequence.toString() : null);
        t.f(type, "type");
        this.f25152a = type;
        this.f25153b = charSequence;
    }
}
