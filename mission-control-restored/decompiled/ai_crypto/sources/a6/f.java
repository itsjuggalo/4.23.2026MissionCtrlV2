package a6;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends e {
    public static final d d(char c7, boolean z7) {
        if (!z7) {
            if (c7 == 'D') {
                return d.f6413h;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c7);
        }
        if (c7 == 'H') {
            return d.f6412g;
        }
        if (c7 == 'M') {
            return d.f6411f;
        }
        if (c7 == 'S') {
            return d.f6410e;
        }
        throw new IllegalArgumentException("Invalid duration ISO time unit: " + c7);
    }

    public static final d e(String shortName) {
        r.f(shortName, "shortName");
        int iHashCode = shortName.hashCode();
        if (iHashCode != 100) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3494) {
                            if (iHashCode != 3525) {
                                if (iHashCode == 3742 && shortName.equals("us")) {
                                    return d.f6408c;
                                }
                            } else if (shortName.equals("ns")) {
                                return d.f6407b;
                            }
                        } else if (shortName.equals("ms")) {
                            return d.f6409d;
                        }
                    } else if (shortName.equals("s")) {
                        return d.f6410e;
                    }
                } else if (shortName.equals("m")) {
                    return d.f6411f;
                }
            } else if (shortName.equals("h")) {
                return d.f6412g;
            }
        } else if (shortName.equals("d")) {
            return d.f6413h;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + shortName);
    }
}
