package s3;

import a.AbstractC0284a;
import s4.C1054a;

/* JADX INFO: renamed from: s3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1024h {
    public static G4.g a(String str, String str2, String str3) {
        return AbstractC0284a.d(new C1054a(str, str2, str3));
    }

    public static String b(String str, String str2) {
        return str + str2;
    }

    public static String c(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String d(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static void e(G4.g gVar, R4.l lVar) {
        lVar.invoke(new G4.h(gVar));
    }

    public static void f(String str, String str2, String str3) {
        AbstractC0284a.d(new C1054a(str, str2, str3));
    }

    public static /* synthetic */ String g(int i) {
        switch (i) {
            case 1:
                return "NULL_VALUE";
            case 2:
                return "BOOLEAN_VALUE";
            case 3:
                return "INTEGER_VALUE";
            case 4:
                return "DOUBLE_VALUE";
            case 5:
                return "TIMESTAMP_VALUE";
            case 6:
                return "STRING_VALUE";
            case 7:
                return "BYTES_VALUE";
            case 8:
                return "REFERENCE_VALUE";
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return "GEO_POINT_VALUE";
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return "ARRAY_VALUE";
            case 11:
                return "MAP_VALUE";
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return "VALUETYPE_NOT_SET";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String h(int i) {
        return i != 1 ? i != 2 ? "null" : "PLAINTEXT" : "TLS";
    }

    public static /* synthetic */ String i(int i) {
        return i != 1 ? i != 2 ? "null" : "OUTBOUND" : "INBOUND";
    }
}
