package W6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends e {
    public static final d d(char c8, boolean z7) {
        if (!z7) {
            if (c8 == 'D') {
                return d.f9319h;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c8);
        }
        if (c8 == 'H') {
            return d.f9318g;
        }
        if (c8 == 'M') {
            return d.f9317f;
        }
        if (c8 == 'S') {
            return d.f9316e;
        }
        throw new IllegalArgumentException("Invalid duration ISO time unit: " + c8);
    }

    public static final d e(String shortName) {
        AbstractC2304t.f(shortName, "shortName");
        int iHashCode = shortName.hashCode();
        if (iHashCode != 100) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3494) {
                            if (iHashCode != 3525) {
                                if (iHashCode == 3742 && shortName.equals("us")) {
                                    return d.f9314c;
                                }
                            } else if (shortName.equals("ns")) {
                                return d.f9313b;
                            }
                        } else if (shortName.equals("ms")) {
                            return d.f9315d;
                        }
                    } else if (shortName.equals("s")) {
                        return d.f9316e;
                    }
                } else if (shortName.equals("m")) {
                    return d.f9317f;
                }
            } else if (shortName.equals("h")) {
                return d.f9318g;
            }
        } else if (shortName.equals("d")) {
            return d.f9319h;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + shortName);
    }
}
