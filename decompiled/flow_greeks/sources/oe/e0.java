package oe;

import java.util.EnumMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumMap f17965a;

    public e0(EnumMap defaultQualifiers) {
        kotlin.jvm.internal.t.f(defaultQualifiers, "defaultQualifiers");
        this.f17965a = defaultQualifiers;
    }

    public final w a(c cVar) {
        return (w) this.f17965a.get(cVar);
    }

    public final EnumMap b() {
        return this.f17965a;
    }
}
