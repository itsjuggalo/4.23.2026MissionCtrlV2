package j$.time;

import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class x extends ZoneId {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f13338d = 0;
    private static final long serialVersionUID = 8386373296231747096L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient j$.time.zone.f f13340c;

    static x W(String str, boolean z4) {
        j$.time.zone.f fVarB;
        Objects.requireNonNull(str, "zoneId");
        int length = str.length();
        if (length >= 2) {
            for (int i4 = 0; i4 < length; i4++) {
                char cCharAt = str.charAt(i4);
                if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt != '/' || i4 == 0) && ((cCharAt < '0' || cCharAt > '9' || i4 == 0) && ((cCharAt != '~' || i4 == 0) && ((cCharAt != '.' || i4 == 0) && ((cCharAt != '_' || i4 == 0) && ((cCharAt != '+' || i4 == 0) && (cCharAt != '-' || i4 == 0))))))))) {
                    throw new c("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
                }
            }
            try {
                fVarB = j$.time.zone.j.b(str, true);
            } catch (j$.time.zone.g e4) {
                if (z4) {
                    throw e4;
                }
                fVarB = null;
            }
            return new x(str, fVarB);
        }
        throw new c("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
    }

    x(String str, j$.time.zone.f fVar) {
        this.f13339b = str;
        this.f13340c = fVar;
    }

    @Override // j$.time.ZoneId
    public final String s() {
        return this.f13339b;
    }

    @Override // j$.time.ZoneId
    public final j$.time.zone.f r() {
        j$.time.zone.f fVar = this.f13340c;
        return fVar != null ? fVar : j$.time.zone.j.b(this.f13339b, false);
    }

    private Object writeReplace() {
        return new s((byte) 7, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.ZoneId
    final void T(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(7);
        objectOutput.writeUTF(this.f13339b);
    }

    final void Z(DataOutput dataOutput) {
        dataOutput.writeUTF(this.f13339b);
    }
}
