package P1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import k4.C2105D;

/* JADX INFO: renamed from: P1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0648b extends Q1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f4287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0648b f4284e = new C0648b(0);
    public static final Parcelable.Creator<C0648b> CREATOR = new q();

    public C0648b(int i7, int i8, PendingIntent pendingIntent, String str) {
        this.f4285a = i7;
        this.f4286b = i8;
        this.f4287c = pendingIntent;
        this.f4288d = str;
    }

    public static String F(int i7) {
        if (i7 == 99) {
            return "UNFINISHED";
        }
        if (i7 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i7) {
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
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return "SERVICE_INVALID";
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i7) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case com.amazon.c.a.a.c.f10119g /* 16 */:
                        return "API_UNAVAILABLE";
                    case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        return "SIGN_IN_FAILED";
                    case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    case 25:
                        return "API_INSTALL_REQUIRED";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i7 + ")";
                }
        }
    }

    public int A() {
        return this.f4286b;
    }

    public String B() {
        return this.f4288d;
    }

    public PendingIntent C() {
        return this.f4287c;
    }

    public boolean D() {
        return (this.f4286b == 0 || this.f4287c == null) ? false : true;
    }

    public boolean E() {
        return this.f4286b == 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0648b)) {
            return false;
        }
        C0648b c0648b = (C0648b) obj;
        return this.f4286b == c0648b.f4286b && AbstractC1206q.b(this.f4287c, c0648b.f4287c) && AbstractC1206q.b(this.f4288d, c0648b.f4288d);
    }

    public int hashCode() {
        return AbstractC1206q.c(Integer.valueOf(this.f4286b), this.f4287c, this.f4288d);
    }

    public String toString() {
        AbstractC1206q.a aVarD = AbstractC1206q.d(this);
        aVarD.a("statusCode", F(this.f4286b));
        aVarD.a("resolution", this.f4287c);
        aVarD.a("message", this.f4288d);
        return aVarD.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.f4285a;
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, i8);
        Q1.c.t(parcel, 2, A());
        Q1.c.C(parcel, 3, C(), i7, false);
        Q1.c.E(parcel, 4, B(), false);
        Q1.c.b(parcel, iA);
    }

    public C0648b(int i7) {
        this(i7, null, null);
    }

    public C0648b(int i7, PendingIntent pendingIntent) {
        this(i7, pendingIntent, null);
    }

    public C0648b(int i7, PendingIntent pendingIntent, String str) {
        this(1, i7, pendingIntent, str);
    }
}
