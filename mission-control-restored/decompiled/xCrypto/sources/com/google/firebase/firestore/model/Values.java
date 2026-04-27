package com.google.firebase.firestore.model;

import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.protobuf.AbstractC1062i;
import com.google.protobuf.f0;
import com.google.protobuf.u0;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import p2.C1698D;
import p2.C1705b;
import p2.InterfaceC1706c;
import p2.u;

/* JADX INFO: loaded from: classes.dex */
public class Values {
    public static final C1698D MAX_VALUE;
    public static final C1698D MAX_VALUE_TYPE;
    public static C1698D MIN_ARRAY = null;
    public static C1698D MIN_BOOLEAN = null;
    public static C1698D MIN_BYTES = null;
    public static C1698D MIN_GEO_POINT = null;
    public static C1698D MIN_MAP = null;
    public static C1698D MIN_NUMBER = null;
    public static C1698D MIN_REFERENCE = null;
    public static C1698D MIN_STRING = null;
    public static C1698D MIN_TIMESTAMP = null;
    public static final C1698D MIN_VALUE;
    private static final C1698D MIN_VECTOR_VALUE;
    public static final C1698D NAN_VALUE = (C1698D) C1698D.I().k(Double.NaN).build();
    public static final C1698D NULL_VALUE;
    public static final String TYPE_KEY = "__type__";
    public static final int TYPE_ORDER_ARRAY = 9;
    public static final int TYPE_ORDER_BLOB = 6;
    public static final int TYPE_ORDER_BOOLEAN = 1;
    public static final int TYPE_ORDER_GEOPOINT = 8;
    public static final int TYPE_ORDER_MAP = 11;
    public static final int TYPE_ORDER_MAX_VALUE = Integer.MAX_VALUE;
    public static final int TYPE_ORDER_NULL = 0;
    public static final int TYPE_ORDER_NUMBER = 2;
    public static final int TYPE_ORDER_REFERENCE = 7;
    public static final int TYPE_ORDER_SERVER_TIMESTAMP = 4;
    public static final int TYPE_ORDER_STRING = 5;
    public static final int TYPE_ORDER_TIMESTAMP = 3;
    public static final int TYPE_ORDER_VECTOR = 10;
    public static final String VECTOR_MAP_VECTORS_KEY = "value";
    public static final C1698D VECTOR_VALUE_TYPE;

    /* JADX INFO: renamed from: com.google.firebase.firestore.model.Values$1, reason: invalid class name */
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
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[C1698D.c.INTEGER_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[C1698D.c.DOUBLE_VALUE.ordinal()] = 4;
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
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[C1698D.c.ARRAY_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[C1698D.c.MAP_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    static {
        C1698D c1698d = (C1698D) C1698D.I().p(f0.NULL_VALUE).build();
        NULL_VALUE = c1698d;
        MIN_VALUE = c1698d;
        C1698D c1698d2 = (C1698D) C1698D.I().r("__max__").build();
        MAX_VALUE_TYPE = c1698d2;
        MAX_VALUE = (C1698D) C1698D.I().n(u.t().h(TYPE_KEY, c1698d2)).build();
        C1698D c1698d3 = (C1698D) C1698D.I().r("__vector__").build();
        VECTOR_VALUE_TYPE = c1698d3;
        MIN_VECTOR_VALUE = (C1698D) C1698D.I().n(u.t().h(TYPE_KEY, c1698d3).h("value", (C1698D) C1698D.I().g(C1705b.t()).build())).build();
        MIN_BOOLEAN = (C1698D) C1698D.I().i(false).build();
        MIN_NUMBER = (C1698D) C1698D.I().k(Double.NaN).build();
        MIN_TIMESTAMP = (C1698D) C1698D.I().s(u0.p().g(Long.MIN_VALUE)).build();
        MIN_STRING = (C1698D) C1698D.I().r("").build();
        MIN_BYTES = (C1698D) C1698D.I().j(AbstractC1062i.f11025b).build();
        MIN_REFERENCE = refValue(DatabaseId.EMPTY, DocumentKey.empty());
        MIN_GEO_POINT = (C1698D) C1698D.I().l(A2.a.p().f(-90.0d).g(-180.0d)).build();
        MIN_ARRAY = (C1698D) C1698D.I().h(C1705b.q()).build();
        MIN_MAP = (C1698D) C1698D.I().o(u.l()).build();
    }

    private static boolean arrayEquals(C1698D c1698d, C1698D c1698d2) {
        C1705b c1705bV = c1698d.v();
        C1705b c1705bV2 = c1698d2.v();
        if (c1705bV.s() != c1705bV2.s()) {
            return false;
        }
        for (int i4 = 0; i4 < c1705bV.s(); i4++) {
            if (!equals(c1705bV.r(i4), c1705bV2.r(i4))) {
                return false;
            }
        }
        return true;
    }

    public static String canonicalId(C1698D c1698d) {
        StringBuilder sb = new StringBuilder();
        canonifyValue(sb, c1698d);
        return sb.toString();
    }

    private static void canonifyArray(StringBuilder sb, C1705b c1705b) {
        sb.append("[");
        for (int i4 = 0; i4 < c1705b.s(); i4++) {
            canonifyValue(sb, c1705b.r(i4));
            if (i4 != c1705b.s() - 1) {
                sb.append(com.amazon.a.a.o.b.f.f8804a);
            }
        }
        sb.append("]");
    }

    private static void canonifyGeoPoint(StringBuilder sb, A2.a aVar) {
        sb.append(String.format("geo(%s,%s)", Double.valueOf(aVar.n()), Double.valueOf(aVar.o())));
    }

    private static void canonifyObject(StringBuilder sb, u uVar) {
        ArrayList<String> arrayList = new ArrayList(uVar.n().keySet());
        Collections.sort(arrayList);
        sb.append("{");
        boolean z4 = true;
        for (String str : arrayList) {
            if (z4) {
                z4 = false;
            } else {
                sb.append(com.amazon.a.a.o.b.f.f8804a);
            }
            sb.append(str);
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            canonifyValue(sb, uVar.p(str));
        }
        sb.append("}");
    }

    private static void canonifyReference(StringBuilder sb, C1698D c1698d) {
        Assert.hardAssert(isReferenceValue(c1698d), "Value should be a ReferenceValue", new Object[0]);
        sb.append(DocumentKey.fromName(c1698d.D()));
    }

    private static void canonifyTimestamp(StringBuilder sb, u0 u0Var) {
        sb.append(String.format("time(%s,%s)", Long.valueOf(u0Var.o()), Integer.valueOf(u0Var.n())));
    }

    private static void canonifyValue(StringBuilder sb, C1698D c1698d) {
        switch (AnonymousClass1.$SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[c1698d.G().ordinal()]) {
            case 1:
                sb.append("null");
                return;
            case 2:
                sb.append(c1698d.w());
                return;
            case 3:
                sb.append(c1698d.B());
                return;
            case 4:
                sb.append(c1698d.z());
                return;
            case 5:
                canonifyTimestamp(sb, c1698d.F());
                return;
            case 6:
                sb.append(c1698d.E());
                return;
            case 7:
                sb.append(Util.toDebugString(c1698d.x()));
                return;
            case 8:
                canonifyReference(sb, c1698d);
                return;
            case 9:
                canonifyGeoPoint(sb, c1698d.A());
                return;
            case 10:
                canonifyArray(sb, c1698d.v());
                return;
            case 11:
                canonifyObject(sb, c1698d.C());
                return;
            default:
                throw Assert.fail("Invalid value type: " + c1698d.G(), new Object[0]);
        }
    }

    public static int compare(C1698D c1698d, C1698D c1698d2) {
        int iTypeOrder = typeOrder(c1698d);
        int iTypeOrder2 = typeOrder(c1698d2);
        if (iTypeOrder != iTypeOrder2) {
            return Util.compareIntegers(iTypeOrder, iTypeOrder2);
        }
        if (iTypeOrder != Integer.MAX_VALUE) {
            switch (iTypeOrder) {
                case 0:
                    break;
                case 1:
                    return Util.compareBooleans(c1698d.w(), c1698d2.w());
                case 2:
                    return compareNumbers(c1698d, c1698d2);
                case 3:
                    return compareTimestamps(c1698d.F(), c1698d2.F());
                case 4:
                    return compareTimestamps(ServerTimestamps.getLocalWriteTime(c1698d), ServerTimestamps.getLocalWriteTime(c1698d2));
                case 5:
                    return Util.compareUtf8Strings(c1698d.E(), c1698d2.E());
                case 6:
                    return Util.compareByteStrings(c1698d.x(), c1698d2.x());
                case 7:
                    return compareReferences(c1698d.D(), c1698d2.D());
                case 8:
                    return compareGeoPoints(c1698d.A(), c1698d2.A());
                case 9:
                    return compareArrays(c1698d.v(), c1698d2.v());
                case 10:
                    return compareVectors(c1698d.C(), c1698d2.C());
                case 11:
                    return compareMaps(c1698d.C(), c1698d2.C());
                default:
                    throw Assert.fail("Invalid value type: " + iTypeOrder, new Object[0]);
            }
        }
        return 0;
    }

    private static int compareArrays(C1705b c1705b, C1705b c1705b2) {
        int iMin = Math.min(c1705b.s(), c1705b2.s());
        for (int i4 = 0; i4 < iMin; i4++) {
            int iCompare = compare(c1705b.r(i4), c1705b2.r(i4));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Util.compareIntegers(c1705b.s(), c1705b2.s());
    }

    private static int compareGeoPoints(A2.a aVar, A2.a aVar2) {
        int iCompareDoubles = Util.compareDoubles(aVar.n(), aVar2.n());
        return iCompareDoubles == 0 ? Util.compareDoubles(aVar.o(), aVar2.o()) : iCompareDoubles;
    }

    private static int compareMaps(u uVar, u uVar2) {
        Iterator it = new TreeMap(uVar.n()).entrySet().iterator();
        Iterator it2 = new TreeMap(uVar2.n()).entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int iCompareUtf8Strings = Util.compareUtf8Strings((String) entry.getKey(), (String) entry2.getKey());
            if (iCompareUtf8Strings != 0) {
                return iCompareUtf8Strings;
            }
            int iCompare = compare((C1698D) entry.getValue(), (C1698D) entry2.getValue());
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Util.compareBooleans(it.hasNext(), it2.hasNext());
    }

    private static int compareNumbers(C1698D c1698d, C1698D c1698d2) {
        C1698D.c cVarG = c1698d.G();
        C1698D.c cVar = C1698D.c.DOUBLE_VALUE;
        if (cVarG == cVar) {
            double dZ = c1698d.z();
            if (c1698d2.G() == cVar) {
                return Util.compareDoubles(dZ, c1698d2.z());
            }
            if (c1698d2.G() == C1698D.c.INTEGER_VALUE) {
                return Util.compareMixed(dZ, c1698d2.B());
            }
        } else {
            C1698D.c cVarG2 = c1698d.G();
            C1698D.c cVar2 = C1698D.c.INTEGER_VALUE;
            if (cVarG2 == cVar2) {
                long jB = c1698d.B();
                if (c1698d2.G() == cVar2) {
                    return Util.compareLongs(jB, c1698d2.B());
                }
                if (c1698d2.G() == cVar) {
                    return Util.compareMixed(c1698d2.z(), jB) * (-1);
                }
            }
        }
        throw Assert.fail("Unexpected values: %s vs %s", c1698d, c1698d2);
    }

    private static int compareReferences(String str, String str2) {
        String[] strArrSplit = str.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
        String[] strArrSplit2 = str2.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i4 = 0; i4 < iMin; i4++) {
            int iCompareTo = strArrSplit[i4].compareTo(strArrSplit2[i4]);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Util.compareIntegers(strArrSplit.length, strArrSplit2.length);
    }

    private static int compareTimestamps(u0 u0Var, u0 u0Var2) {
        int iCompareLongs = Util.compareLongs(u0Var.o(), u0Var2.o());
        return iCompareLongs != 0 ? iCompareLongs : Util.compareIntegers(u0Var.n(), u0Var2.n());
    }

    private static int compareVectors(u uVar, u uVar2) {
        Map mapN = uVar.n();
        Map mapN2 = uVar2.n();
        C1705b c1705bV = ((C1698D) mapN.get("value")).v();
        C1705b c1705bV2 = ((C1698D) mapN2.get("value")).v();
        int iCompareIntegers = Util.compareIntegers(c1705bV.s(), c1705bV2.s());
        return iCompareIntegers != 0 ? iCompareIntegers : compareArrays(c1705bV, c1705bV2);
    }

    public static boolean contains(InterfaceC1706c interfaceC1706c, C1698D c1698d) {
        Iterator it = interfaceC1706c.a().iterator();
        while (it.hasNext()) {
            if (equals((C1698D) it.next(), c1698d)) {
                return true;
            }
        }
        return false;
    }

    public static boolean equals(C1698D c1698d, C1698D c1698d2) {
        int iTypeOrder;
        if (c1698d == c1698d2) {
            return true;
        }
        if (c1698d == null || c1698d2 == null || (iTypeOrder = typeOrder(c1698d)) != typeOrder(c1698d2)) {
            return false;
        }
        if (iTypeOrder == 2) {
            return numberEquals(c1698d, c1698d2);
        }
        if (iTypeOrder == 4) {
            return ServerTimestamps.getLocalWriteTime(c1698d).equals(ServerTimestamps.getLocalWriteTime(c1698d2));
        }
        if (iTypeOrder == Integer.MAX_VALUE) {
            return true;
        }
        switch (iTypeOrder) {
            case 9:
                return arrayEquals(c1698d, c1698d2);
            case 10:
            case 11:
                return objectEquals(c1698d, c1698d2);
            default:
                return c1698d.equals(c1698d2);
        }
    }

    public static C1698D getLowerBound(C1698D c1698d) {
        switch (AnonymousClass1.$SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[c1698d.G().ordinal()]) {
            case 1:
                return NULL_VALUE;
            case 2:
                return MIN_BOOLEAN;
            case 3:
            case 4:
                return MIN_NUMBER;
            case 5:
                return MIN_TIMESTAMP;
            case 6:
                return MIN_STRING;
            case 7:
                return MIN_BYTES;
            case 8:
                return MIN_REFERENCE;
            case 9:
                return MIN_GEO_POINT;
            case 10:
                return MIN_ARRAY;
            case 11:
                return isVectorValue(c1698d) ? MIN_VECTOR_VALUE : MIN_MAP;
            default:
                throw new IllegalArgumentException("Unknown value type: " + c1698d.G());
        }
    }

    public static C1698D getUpperBound(C1698D c1698d) {
        switch (AnonymousClass1.$SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[c1698d.G().ordinal()]) {
            case 1:
                return MIN_BOOLEAN;
            case 2:
                return MIN_NUMBER;
            case 3:
            case 4:
                return MIN_TIMESTAMP;
            case 5:
                return MIN_STRING;
            case 6:
                return MIN_BYTES;
            case 7:
                return MIN_REFERENCE;
            case 8:
                return MIN_GEO_POINT;
            case 9:
                return MIN_ARRAY;
            case 10:
                return MIN_VECTOR_VALUE;
            case 11:
                return isVectorValue(c1698d) ? MIN_MAP : MAX_VALUE;
            default:
                throw new IllegalArgumentException("Unknown value type: " + c1698d.G());
        }
    }

    public static boolean isArray(C1698D c1698d) {
        return c1698d != null && c1698d.G() == C1698D.c.ARRAY_VALUE;
    }

    public static boolean isDouble(C1698D c1698d) {
        return c1698d != null && c1698d.G() == C1698D.c.DOUBLE_VALUE;
    }

    public static boolean isInteger(C1698D c1698d) {
        return c1698d != null && c1698d.G() == C1698D.c.INTEGER_VALUE;
    }

    public static boolean isMapValue(C1698D c1698d) {
        return c1698d != null && c1698d.G() == C1698D.c.MAP_VALUE;
    }

    public static boolean isMaxValue(C1698D c1698d) {
        return MAX_VALUE_TYPE.equals(c1698d.C().n().get(TYPE_KEY));
    }

    public static boolean isNanValue(C1698D c1698d) {
        return c1698d != null && Double.isNaN(c1698d.z());
    }

    public static boolean isNullValue(C1698D c1698d) {
        return c1698d != null && c1698d.G() == C1698D.c.NULL_VALUE;
    }

    public static boolean isNumber(C1698D c1698d) {
        return isInteger(c1698d) || isDouble(c1698d);
    }

    public static boolean isReferenceValue(C1698D c1698d) {
        return c1698d != null && c1698d.G() == C1698D.c.REFERENCE_VALUE;
    }

    public static boolean isVectorValue(C1698D c1698d) {
        return VECTOR_VALUE_TYPE.equals(c1698d.C().n().get(TYPE_KEY));
    }

    public static int lowerBoundCompare(C1698D c1698d, boolean z4, C1698D c1698d2, boolean z5) {
        int iCompare = compare(c1698d, c1698d2);
        if (iCompare != 0) {
            return iCompare;
        }
        if (!z4 || z5) {
            return (z4 || !z5) ? 0 : 1;
        }
        return -1;
    }

    private static boolean numberEquals(C1698D c1698d, C1698D c1698d2) {
        C1698D.c cVarG = c1698d.G();
        C1698D.c cVar = C1698D.c.INTEGER_VALUE;
        if (cVarG == cVar && c1698d2.G() == cVar) {
            return c1698d.B() == c1698d2.B();
        }
        C1698D.c cVarG2 = c1698d.G();
        C1698D.c cVar2 = C1698D.c.DOUBLE_VALUE;
        return cVarG2 == cVar2 && c1698d2.G() == cVar2 && Double.doubleToLongBits(c1698d.z()) == Double.doubleToLongBits(c1698d2.z());
    }

    private static boolean objectEquals(C1698D c1698d, C1698D c1698d2) {
        u uVarC = c1698d.C();
        u uVarC2 = c1698d2.C();
        if (uVarC.m() != uVarC2.m()) {
            return false;
        }
        for (Map.Entry entry : uVarC.n().entrySet()) {
            if (!equals((C1698D) entry.getValue(), (C1698D) uVarC2.n().get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static C1698D refValue(DatabaseId databaseId, DocumentKey documentKey) {
        return (C1698D) C1698D.I().q(String.format("projects/%s/databases/%s/documents/%s", databaseId.getProjectId(), databaseId.getDatabaseId(), documentKey.toString())).build();
    }

    public static int typeOrder(C1698D c1698d) {
        switch (AnonymousClass1.$SwitchMap$com$google$firestore$v1$Value$ValueTypeCase[c1698d.G().ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 9;
            case 11:
                if (ServerTimestamps.isServerTimestamp(c1698d)) {
                    return 4;
                }
                if (isMaxValue(c1698d)) {
                    return Integer.MAX_VALUE;
                }
                return isVectorValue(c1698d) ? 10 : 11;
            default:
                throw Assert.fail("Invalid value type: " + c1698d.G(), new Object[0]);
        }
    }

    public static int upperBoundCompare(C1698D c1698d, boolean z4, C1698D c1698d2, boolean z5) {
        int iCompare = compare(c1698d, c1698d2);
        if (iCompare != 0) {
            return iCompare;
        }
        if (!z4 || z5) {
            return (z4 || !z5) ? 0 : -1;
        }
        return 1;
    }
}
