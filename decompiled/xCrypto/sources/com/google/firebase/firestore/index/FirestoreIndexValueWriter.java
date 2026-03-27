package com.google.firebase.firestore.index;

import A2.a;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.Values;
import com.google.protobuf.u0;
import java.util.Iterator;
import java.util.Map;
import p2.C1698D;
import p2.C1705b;
import p2.u;

/* JADX INFO: loaded from: classes.dex */
public class FirestoreIndexValueWriter {
    public static final int DOCUMENT_NAME_OFFSET = 5;
    public static final int INDEX_TYPE_ARRAY = 50;
    public static final int INDEX_TYPE_BLOB = 30;
    public static final int INDEX_TYPE_BOOLEAN = 10;
    public static final int INDEX_TYPE_GEOPOINT = 45;
    public static final int INDEX_TYPE_MAP = 55;
    public static final int INDEX_TYPE_NAN = 13;
    public static final int INDEX_TYPE_NULL = 5;
    public static final int INDEX_TYPE_NUMBER = 15;
    public static final int INDEX_TYPE_REFERENCE = 37;
    public static final int INDEX_TYPE_REFERENCE_SEGMENT = 60;
    public static final int INDEX_TYPE_STRING = 25;
    public static final int INDEX_TYPE_TIMESTAMP = 20;
    public static final int INDEX_TYPE_VECTOR = 53;
    public static final FirestoreIndexValueWriter INSTANCE = new FirestoreIndexValueWriter();
    public static final int NOT_TRUNCATED = 2;

    /* JADX INFO: renamed from: com.google.firebase.firestore.index.FirestoreIndexValueWriter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase;

        static {
            int[] iArr = new int[C1698D.c.values().length];
            $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase = iArr;
            try {
                iArr[C1698D.c.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[C1698D.c.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[C1698D.c.DOUBLE_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[C1698D.c.INTEGER_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[C1698D.c.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[C1698D.c.STRING_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[C1698D.c.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[C1698D.c.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[C1698D.c.GEO_POINT_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[C1698D.c.MAP_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[C1698D.c.ARRAY_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private FirestoreIndexValueWriter() {
    }

    private void writeIndexArray(C1705b c1705b, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        writeValueTypeLabel(directionalIndexByteEncoder, 50);
        Iterator it = c1705b.a().iterator();
        while (it.hasNext()) {
            writeIndexValueAux((C1698D) it.next(), directionalIndexByteEncoder);
        }
    }

    private void writeIndexEntityRef(String str, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        writeValueTypeLabel(directionalIndexByteEncoder, 37);
        ResourcePath resourcePathFromString = ResourcePath.fromString(str);
        int length = resourcePathFromString.length();
        for (int i4 = 5; i4 < length; i4++) {
            String segment = resourcePathFromString.getSegment(i4);
            writeValueTypeLabel(directionalIndexByteEncoder, 60);
            writeUnlabeledIndexString(segment, directionalIndexByteEncoder);
        }
    }

    private void writeIndexMap(u uVar, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        writeValueTypeLabel(directionalIndexByteEncoder, 55);
        for (Map.Entry entry : uVar.n().entrySet()) {
            String str = (String) entry.getKey();
            C1698D c1698d = (C1698D) entry.getValue();
            writeIndexString(str, directionalIndexByteEncoder);
            writeIndexValueAux(c1698d, directionalIndexByteEncoder);
        }
    }

    private void writeIndexString(String str, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        writeValueTypeLabel(directionalIndexByteEncoder, 25);
        writeUnlabeledIndexString(str, directionalIndexByteEncoder);
    }

    private void writeIndexValueAux(C1698D c1698d, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        switch (AnonymousClass1.$SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[c1698d.G().ordinal()]) {
            case 1:
                writeValueTypeLabel(directionalIndexByteEncoder, 5);
                return;
            case 2:
                writeValueTypeLabel(directionalIndexByteEncoder, 10);
                directionalIndexByteEncoder.writeLong(c1698d.w() ? 1L : 0L);
                return;
            case 3:
                double dZ = c1698d.z();
                if (Double.isNaN(dZ)) {
                    writeValueTypeLabel(directionalIndexByteEncoder, 13);
                    return;
                }
                writeValueTypeLabel(directionalIndexByteEncoder, 15);
                if (dZ == -0.0d) {
                    directionalIndexByteEncoder.writeDouble(0.0d);
                    return;
                } else {
                    directionalIndexByteEncoder.writeDouble(dZ);
                    return;
                }
            case 4:
                writeValueTypeLabel(directionalIndexByteEncoder, 15);
                directionalIndexByteEncoder.writeDouble(c1698d.B());
                return;
            case 5:
                u0 u0VarF = c1698d.F();
                writeValueTypeLabel(directionalIndexByteEncoder, 20);
                directionalIndexByteEncoder.writeLong(u0VarF.o());
                directionalIndexByteEncoder.writeLong(u0VarF.n());
                return;
            case 6:
                writeIndexString(c1698d.E(), directionalIndexByteEncoder);
                writeTruncationMarker(directionalIndexByteEncoder);
                return;
            case 7:
                writeValueTypeLabel(directionalIndexByteEncoder, 30);
                directionalIndexByteEncoder.writeBytes(c1698d.x());
                writeTruncationMarker(directionalIndexByteEncoder);
                return;
            case 8:
                writeIndexEntityRef(c1698d.D(), directionalIndexByteEncoder);
                return;
            case 9:
                a aVarA = c1698d.A();
                writeValueTypeLabel(directionalIndexByteEncoder, 45);
                directionalIndexByteEncoder.writeDouble(aVarA.n());
                directionalIndexByteEncoder.writeDouble(aVarA.o());
                return;
            case 10:
                if (Values.isMaxValue(c1698d)) {
                    writeValueTypeLabel(directionalIndexByteEncoder, Integer.MAX_VALUE);
                    return;
                } else if (Values.isVectorValue(c1698d)) {
                    writeIndexVector(c1698d.C(), directionalIndexByteEncoder);
                    return;
                } else {
                    writeIndexMap(c1698d.C(), directionalIndexByteEncoder);
                    writeTruncationMarker(directionalIndexByteEncoder);
                    return;
                }
            case 11:
                writeIndexArray(c1698d.v(), directionalIndexByteEncoder);
                writeTruncationMarker(directionalIndexByteEncoder);
                return;
            default:
                throw new IllegalArgumentException("unknown index value type " + c1698d.G());
        }
    }

    private void writeIndexVector(u uVar, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        Map mapN = uVar.n();
        writeValueTypeLabel(directionalIndexByteEncoder, 53);
        int iS = ((C1698D) mapN.get("value")).v().s();
        writeValueTypeLabel(directionalIndexByteEncoder, 15);
        directionalIndexByteEncoder.writeLong(iS);
        writeIndexString("value", directionalIndexByteEncoder);
        writeIndexValueAux((C1698D) mapN.get("value"), directionalIndexByteEncoder);
    }

    private void writeTruncationMarker(DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        directionalIndexByteEncoder.writeLong(2L);
    }

    private void writeUnlabeledIndexString(String str, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        directionalIndexByteEncoder.writeString(str);
    }

    private void writeValueTypeLabel(DirectionalIndexByteEncoder directionalIndexByteEncoder, int i4) {
        directionalIndexByteEncoder.writeLong(i4);
    }

    public void writeIndexValue(C1698D c1698d, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        writeIndexValueAux(c1698d, directionalIndexByteEncoder);
        directionalIndexByteEncoder.writeInfinity();
    }
}
