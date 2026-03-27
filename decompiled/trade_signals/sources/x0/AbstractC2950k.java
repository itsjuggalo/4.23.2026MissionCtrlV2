package x0;

import com.revenuecat.purchases.common.Constants;
import java.util.Arrays;

/* JADX INFO: renamed from: x0.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2950k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f24135a = {48, 49, 53, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f24136b = {48, 49, 48, 0};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f24137c = {48, 48, 57, 0};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f24138d = {48, 48, 53, 0};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f24139e = {48, 48, 49, 0};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f24140f = {48, 48, 49, 0};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f24141g = {48, 48, 50, 0};

    public static String a(byte[] bArr) {
        return (Arrays.equals(bArr, f24139e) || Arrays.equals(bArr, f24138d)) ? Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR : "!";
    }
}
