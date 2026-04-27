package a6;

import java.util.EnumMap;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumMap f10013a;

    public E(EnumMap defaultQualifiers) {
        AbstractC2304t.f(defaultQualifiers, "defaultQualifiers");
        this.f10013a = defaultQualifiers;
    }

    public final w a(EnumC1080c enumC1080c) {
        return (w) this.f10013a.get(enumC1080c);
    }

    public final EnumMap b() {
        return this.f10013a;
    }
}
