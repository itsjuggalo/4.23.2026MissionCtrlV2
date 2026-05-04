package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x0 {
    public static final w0 a(eh.b json, String source) {
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(source, "source");
        return !json.f().a() ? new w0(source) : new y0(source);
    }
}
