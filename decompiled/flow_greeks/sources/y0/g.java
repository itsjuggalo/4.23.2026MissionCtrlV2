package y0;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f25155d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String type, CharSequence charSequence) {
        super(type, charSequence);
        t.f(type, "type");
        this.f25155d = type;
        if (a().length() <= 0) {
            throw new IllegalArgumentException("type must not be empty");
        }
    }

    public String a() {
        return this.f25155d;
    }
}
