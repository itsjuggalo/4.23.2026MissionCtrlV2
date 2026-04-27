package T2;

import java.util.Arrays;
import java.util.HashSet;
import s3.B0;
import s3.I0;

/* JADX INFO: renamed from: T2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0247k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashSet f2969d = new HashSet(Arrays.asList("date", "x-google-backends", "x-google-netmon-label", "x-google-service", "x-google-gfe-request-trace"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A.c f2970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final U2.f f2971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f2972c;

    public C0247k(U2.f fVar, A.c cVar, s sVar) {
        this.f2971b = fVar;
        this.f2970a = cVar;
        this.f2972c = sVar;
    }

    public static boolean a(K2.J j4) {
        switch (j4.ordinal()) {
            case 0:
                throw new IllegalArgumentException("Treated status OK as error");
            case 1:
            case 2:
            case 4:
            case 8:
            case 13:
            case 14:
            case 16:
                return false;
            case 3:
            case 5:
            case 6:
            case 7:
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
            case 11:
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
            case 15:
                return true;
            default:
                throw new IllegalArgumentException("Unknown gRPC status code: " + j4);
        }
    }
}
