package y0;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Exception {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0466a f25145c = new C0466a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f25147b;

    /* JADX INFO: renamed from: y0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0466a {
        public /* synthetic */ C0466a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public C0466a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String type, CharSequence charSequence) {
        super(charSequence != null ? charSequence.toString() : null);
        t.f(type, "type");
        this.f25146a = type;
        this.f25147b = charSequence;
    }
}
