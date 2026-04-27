package Q1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1293m;
import io.flutter.Build;
import io.flutter.plugins.firebase.database.Constants;

/* JADX INFO: renamed from: Q1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0790b extends T1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f6681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0790b f6678e = new C0790b(0);
    public static final Parcelable.Creator<C0790b> CREATOR = new q();

    public C0790b(int i8) {
        this(i8, null, null);
    }

    public static String n(int i8) {
        if (i8 == 99) {
            return "UNFINISHED";
        }
        if (i8 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i8) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i8) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case com.amazon.c.a.a.c.f14230g /* 16 */:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case Build.API_LEVELS.API_22 /* 22 */:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case Build.API_LEVELS.API_23 /* 23 */:
                        return "API_DISABLED";
                    case Build.API_LEVELS.API_24 /* 24 */:
                        return "API_DISABLED_FOR_CONNECTION";
                    case Build.API_LEVELS.API_25 /* 25 */:
                        return "API_INSTALL_REQUIRED";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i8 + ")";
                }
        }
    }

    public int a() {
        return this.f6680b;
    }

    public String d() {
        return this.f6682d;
    }

    public PendingIntent e() {
        return this.f6681c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0790b)) {
            return false;
        }
        C0790b c0790b = (C0790b) obj;
        return this.f6680b == c0790b.f6680b && AbstractC1293m.a(this.f6681c, c0790b.f6681c) && AbstractC1293m.a(this.f6682d, c0790b.f6682d);
    }

    public boolean f() {
        return (this.f6680b == 0 || this.f6681c == null) ? false : true;
    }

    public boolean h() {
        return this.f6680b == 0;
    }

    public int hashCode() {
        return AbstractC1293m.b(Integer.valueOf(this.f6680b), this.f6681c, this.f6682d);
    }

    public String toString() {
        AbstractC1293m.a aVarC = AbstractC1293m.c(this);
        aVarC.a("statusCode", n(this.f6680b));
        aVarC.a("resolution", this.f6681c);
        aVarC.a(Constants.ERROR_MESSAGE, this.f6682d);
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        int i9 = this.f6679a;
        int iA = T1.c.a(parcel);
        T1.c.j(parcel, 1, i9);
        T1.c.j(parcel, 2, a());
        T1.c.o(parcel, 3, e(), i8, false);
        T1.c.p(parcel, 4, d(), false);
        T1.c.b(parcel, iA);
    }

    public C0790b(int i8, int i9, PendingIntent pendingIntent, String str) {
        this.f6679a = i8;
        this.f6680b = i9;
        this.f6681c = pendingIntent;
        this.f6682d = str;
    }

    public C0790b(int i8, PendingIntent pendingIntent) {
        this(i8, pendingIntent, null);
    }

    public C0790b(int i8, PendingIntent pendingIntent, String str) {
        this(1, i8, pendingIntent, str);
    }
}
