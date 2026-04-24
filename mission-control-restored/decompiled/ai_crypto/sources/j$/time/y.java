package j$.time;

import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class y extends ZoneId {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f17299d = 0;
    private static final long serialVersionUID = 8386373296231747096L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f17300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient j$.time.zone.f f17301c;

    static y W(String str, boolean z7) {
        j$.time.zone.f fVarB;
        Objects.requireNonNull(str, "zoneId");
        int length = str.length();
        if (length >= 2) {
            for (int i7 = 0; i7 < length; i7++) {
                char cCharAt = str.charAt(i7);
                if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt != '/' || i7 == 0) && ((cCharAt < '0' || cCharAt > '9' || i7 == 0) && ((cCharAt != '~' || i7 == 0) && ((cCharAt != '.' || i7 == 0) && ((cCharAt != '_' || i7 == 0) && ((cCharAt != '+' || i7 == 0) && (cCharAt != '-' || i7 == 0))))))))) {
                    throw new c("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
                }
            }
            try {
                fVarB = j$.time.zone.j.b(str, true);
            } catch (j$.time.zone.g e7) {
                if (z7) {
                    throw e7;
                }
                fVarB = null;
            }
            return new y(str, fVarB);
        }
        throw new c("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
    }

    y(String str, j$.time.zone.f fVar) {
        this.f17300b = str;
        this.f17301c = fVar;
    }

    @Override // j$.time.ZoneId
    public final String s() {
        return this.f17300b;
    }

    @Override // j$.time.ZoneId
    public final j$.time.zone.f r() {
        j$.time.zone.f fVar = this.f17301c;
        return fVar != null ? fVar : j$.time.zone.j.b(this.f17300b, false);
    }

    private Object writeReplace() {
        return new t((byte) 7, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.ZoneId
    final void T(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(7);
        objectOutput.writeUTF(this.f17300b);
    }

    final void Z(DataOutput dataOutput) {
        dataOutput.writeUTF(this.f17300b);
    }
}
