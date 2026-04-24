package com.google.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: com.google.protobuf.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0496z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC0496z f5820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC0496z f5821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC0496z[] f5822d;
    public static final /* synthetic */ EnumC0496z[] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5823a;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0496z EF0;

    static {
        Q q6 = Q.DOUBLE;
        EnumC0496z enumC0496z = new EnumC0496z("DOUBLE", 0, 0, 1, q6);
        Q q7 = Q.FLOAT;
        EnumC0496z enumC0496z2 = new EnumC0496z("FLOAT", 1, 1, 1, q7);
        Q q8 = Q.LONG;
        EnumC0496z enumC0496z3 = new EnumC0496z("INT64", 2, 2, 1, q8);
        EnumC0496z enumC0496z4 = new EnumC0496z("UINT64", 3, 3, 1, q8);
        Q q9 = Q.INT;
        EnumC0496z enumC0496z5 = new EnumC0496z("INT32", 4, 4, 1, q9);
        EnumC0496z enumC0496z6 = new EnumC0496z("FIXED64", 5, 5, 1, q8);
        EnumC0496z enumC0496z7 = new EnumC0496z("FIXED32", 6, 6, 1, q9);
        Q q10 = Q.BOOLEAN;
        EnumC0496z enumC0496z8 = new EnumC0496z("BOOL", 7, 7, 1, q10);
        Q q11 = Q.STRING;
        EnumC0496z enumC0496z9 = new EnumC0496z("STRING", 8, 8, 1, q11);
        Q q12 = Q.MESSAGE;
        EnumC0496z enumC0496z10 = new EnumC0496z("MESSAGE", 9, 9, 1, q12);
        Q q13 = Q.BYTE_STRING;
        EnumC0496z enumC0496z11 = new EnumC0496z("BYTES", 10, 10, 1, q13);
        EnumC0496z enumC0496z12 = new EnumC0496z("UINT32", 11, 11, 1, q9);
        Q q14 = Q.ENUM;
        EnumC0496z enumC0496z13 = new EnumC0496z("ENUM", 12, 12, 1, q14);
        EnumC0496z enumC0496z14 = new EnumC0496z("SFIXED32", 13, 13, 1, q9);
        EnumC0496z enumC0496z15 = new EnumC0496z("SFIXED64", 14, 14, 1, q8);
        EnumC0496z enumC0496z16 = new EnumC0496z("SINT32", 15, 15, 1, q9);
        EnumC0496z enumC0496z17 = new EnumC0496z("SINT64", 16, 16, 1, q8);
        EnumC0496z enumC0496z18 = new EnumC0496z("GROUP", 17, 17, 1, q12);
        EnumC0496z enumC0496z19 = new EnumC0496z("DOUBLE_LIST", 18, 18, 2, q6);
        EnumC0496z enumC0496z20 = new EnumC0496z("FLOAT_LIST", 19, 19, 2, q7);
        EnumC0496z enumC0496z21 = new EnumC0496z("INT64_LIST", 20, 20, 2, q8);
        EnumC0496z enumC0496z22 = new EnumC0496z("UINT64_LIST", 21, 21, 2, q8);
        EnumC0496z enumC0496z23 = new EnumC0496z("INT32_LIST", 22, 22, 2, q9);
        EnumC0496z enumC0496z24 = new EnumC0496z("FIXED64_LIST", 23, 23, 2, q8);
        EnumC0496z enumC0496z25 = new EnumC0496z("FIXED32_LIST", 24, 24, 2, q9);
        EnumC0496z enumC0496z26 = new EnumC0496z("BOOL_LIST", 25, 25, 2, q10);
        EnumC0496z enumC0496z27 = new EnumC0496z("STRING_LIST", 26, 26, 2, q11);
        EnumC0496z enumC0496z28 = new EnumC0496z("MESSAGE_LIST", 27, 27, 2, q12);
        EnumC0496z enumC0496z29 = new EnumC0496z("BYTES_LIST", 28, 28, 2, q13);
        EnumC0496z enumC0496z30 = new EnumC0496z("UINT32_LIST", 29, 29, 2, q9);
        EnumC0496z enumC0496z31 = new EnumC0496z("ENUM_LIST", 30, 30, 2, q14);
        EnumC0496z enumC0496z32 = new EnumC0496z("SFIXED32_LIST", 31, 31, 2, q9);
        EnumC0496z enumC0496z33 = new EnumC0496z("SFIXED64_LIST", 32, 32, 2, q8);
        EnumC0496z enumC0496z34 = new EnumC0496z("SINT32_LIST", 33, 33, 2, q9);
        EnumC0496z enumC0496z35 = new EnumC0496z("SINT64_LIST", 34, 34, 2, q8);
        EnumC0496z enumC0496z36 = new EnumC0496z("DOUBLE_LIST_PACKED", 35, 35, 3, q6);
        f5820b = enumC0496z36;
        EnumC0496z enumC0496z37 = new EnumC0496z("FLOAT_LIST_PACKED", 36, 36, 3, q7);
        EnumC0496z enumC0496z38 = new EnumC0496z("INT64_LIST_PACKED", 37, 37, 3, q8);
        EnumC0496z enumC0496z39 = new EnumC0496z("UINT64_LIST_PACKED", 38, 38, 3, q8);
        EnumC0496z enumC0496z40 = new EnumC0496z("INT32_LIST_PACKED", 39, 39, 3, q9);
        EnumC0496z enumC0496z41 = new EnumC0496z("FIXED64_LIST_PACKED", 40, 40, 3, q8);
        EnumC0496z enumC0496z42 = new EnumC0496z("FIXED32_LIST_PACKED", 41, 41, 3, q9);
        EnumC0496z enumC0496z43 = new EnumC0496z("BOOL_LIST_PACKED", 42, 42, 3, q10);
        EnumC0496z enumC0496z44 = new EnumC0496z("UINT32_LIST_PACKED", 43, 43, 3, q9);
        EnumC0496z enumC0496z45 = new EnumC0496z("ENUM_LIST_PACKED", 44, 44, 3, q14);
        EnumC0496z enumC0496z46 = new EnumC0496z("SFIXED32_LIST_PACKED", 45, 45, 3, q9);
        EnumC0496z enumC0496z47 = new EnumC0496z("SFIXED64_LIST_PACKED", 46, 46, 3, q8);
        EnumC0496z enumC0496z48 = new EnumC0496z("SINT32_LIST_PACKED", 47, 47, 3, q9);
        EnumC0496z enumC0496z49 = new EnumC0496z("SINT64_LIST_PACKED", 48, 48, 3, q8);
        f5821c = enumC0496z49;
        e = new EnumC0496z[]{enumC0496z, enumC0496z2, enumC0496z3, enumC0496z4, enumC0496z5, enumC0496z6, enumC0496z7, enumC0496z8, enumC0496z9, enumC0496z10, enumC0496z11, enumC0496z12, enumC0496z13, enumC0496z14, enumC0496z15, enumC0496z16, enumC0496z17, enumC0496z18, enumC0496z19, enumC0496z20, enumC0496z21, enumC0496z22, enumC0496z23, enumC0496z24, enumC0496z25, enumC0496z26, enumC0496z27, enumC0496z28, enumC0496z29, enumC0496z30, enumC0496z31, enumC0496z32, enumC0496z33, enumC0496z34, enumC0496z35, enumC0496z36, enumC0496z37, enumC0496z38, enumC0496z39, enumC0496z40, enumC0496z41, enumC0496z42, enumC0496z43, enumC0496z44, enumC0496z45, enumC0496z46, enumC0496z47, enumC0496z48, enumC0496z49, new EnumC0496z("GROUP_LIST", 49, 49, 2, q12), new EnumC0496z("MAP", 50, 50, 4, Q.VOID)};
        EnumC0496z[] enumC0496zArrValues = values();
        f5822d = new EnumC0496z[enumC0496zArrValues.length];
        for (EnumC0496z enumC0496z50 : enumC0496zArrValues) {
            f5822d[enumC0496z50.f5823a] = enumC0496z50;
        }
    }

    public EnumC0496z(String str, int i, int i6, int i7, Q q6) {
        this.f5823a = i6;
        int iC = S.i.c(i7);
        if (iC == 1 || iC == 3) {
            q6.getClass();
        }
        if (i7 == 1) {
            q6.ordinal();
        }
    }

    public static EnumC0496z valueOf(String str) {
        return (EnumC0496z) Enum.valueOf(EnumC0496z.class, str);
    }

    public static EnumC0496z[] values() {
        return (EnumC0496z[]) e.clone();
    }
}
